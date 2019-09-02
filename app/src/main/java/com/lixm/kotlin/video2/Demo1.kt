package com.lixm.kotlin.video2

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/27
 */

val aBoolean: Boolean = true
val anotherBoolean: Boolean = false

val aInt = 8
val anotherInt = 0xff //16进制的255
val moreInt = 0b00000011 //2进制的3
val maxInt = Int.MAX_VALUE
val minInt = Int.MIN_VALUE

fun main(args: Array<String>) {
    println(anotherInt)
    println(moreInt)
    println(maxInt)
    println(Math.pow(2.0, 31.0) - 1)
    println(minInt)
}