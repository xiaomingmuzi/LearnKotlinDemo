package com.lixm.kotlin.video2

/**
 * Describe:区间
 *
 * Author: Lixm
 * Date: 2019/8/28
 */

val range:IntRange = 0..1024  //表示闭区间，[0,1024]
val range2:IntRange = 0 until 1024 //开始开区间 [0,1023]

fun main(args: Array<String>) {

    //判断是否在某个区间
    println(100 in 0..200)
    println(100 in range)

    //遍历区间
//    for (i in range2){
//        print("$i，")
//    }
}

