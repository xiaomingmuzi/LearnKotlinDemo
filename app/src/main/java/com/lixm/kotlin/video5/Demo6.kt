package com.lixm.kotlin.video5

import java.io.OutputStream
import java.nio.charset.Charset

/**
 * Describe:科理化和偏函数
 *
 * Author: Lixm
 * Date: 2019/8/26
 */
fun log(tag: String, target: OutputStream, message: Any?) {
    target.write("[$tag] $message \n".toByteArray())
}

//fun log(tag:String)
//    =fun(target:OutputStream)
//    =fun(message:Any?){
//            target.write("[$tag] $message \n".toByteArray())
//        }

fun main(args: Array<String>) {
    log("普通打印日志方式：[Lixm] ", System.out, "Hello world")
//    log("科理化打印：[Lixm]")(System.out)("你好，世界")
    //科理化的调用方式
    ::log.curried()("科理化打印：[Lixm]")(System.out)("你好，世界")

    //如果前两个参数是固定，每次调用只需传入最后的几个参数，那么可以使用偏函数的概念
    //得到的 consoleLogWithTag 就是 log的偏函数
    val consoleLogWithTag = ::log.curried()("科理化打印：[Lixm]")(System.out)
    //那么每次调用，可以直接使用
    consoleLogWithTag("你好，偏函数1")
    consoleLogWithTag("你好，偏函数2")
    consoleLogWithTag("你好，偏函数3")

    val bytes = "我是中国人"
    val stringFromGBK = makeStringFromGbkBytes(bytes.toByteArray(charset("GBK")))
    consoleLogWithTag(stringFromGBK)
}

//手动写方法的科理化版本
fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)

//获取指定位置参数的偏函数
val makeString = fun(byteArray: ByteArray, charset: Charset): String {
    return String(byteArray, charset)
}

val makeStringFromGbkBytes = makeString.partial2(charset("GBK"))

//固定参数二 ，参数一可以 自由传入
fun <P1, P2, R> Function2<P1, P2, R>.partial2(p2: P2) = fun(p1: P1) = this(p1, p2)

//固定参数一，参数二可以自由传入
fun <P1, P2, R> Function2<P1, P2, R>.partial1(p1: P1) = fun(p2: P2) = this(p1, p2)

