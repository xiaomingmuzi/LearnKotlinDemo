package com.lixm.kotlin.demo

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/22
 */
enum class LogLevel(var id:Int) { //枚举类
    //注意，枚举类中可以有构造方法，有其他定义方法，但需要添加分号隔离
    VERBOSE(0),DEBUG(1),INFO(2),WARN(3),ERROR(4),ASSERT(5);

    fun getTag():String{
        return "$id  $name"
    }

    override fun toString(): String {
        return "$name   $ordinal"
    }
}

fun main(args: Array<String>) {
    println(LogLevel.DEBUG.getTag())
    println(LogLevel.DEBUG.ordinal)
    LogLevel.values().map(::println)
}

