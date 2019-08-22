package com.lixm.kotlin.demo

import kotlin.reflect.KProperty

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/22
 */
class Delegates {
    val hello by lazy {
        "helloWorld"
    }

    val hello1 by X()
    var hello2 by X()
}

class X {
    private var value: String? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue $thisRef->${property.name}")
        return value ?: ""
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setValue $thisRef->${property.name}= $value")
        this.value = value
    }
}

fun main(args: Array<String>) {
//    println("abc_".append(16))
//    println("abc_" * 16)
//    println("abc".a)  //打印扩展属性
    val delegates=Delegates()
    println(delegates.hello)
    println(delegates.hello1)
    println(delegates.hello2)
    delegates.hello2="你好么"
    println(delegates.hello2)

}

//fun String.append(int: Int): String { //扩展方法
operator fun String.times(int: Int): String {
    val sb = StringBuilder()
    for (i in 0 until int) {
        sb.append(this)
    }
    return sb.toString()
}

val String.a: String  //扩展属性
    get() = "abc"