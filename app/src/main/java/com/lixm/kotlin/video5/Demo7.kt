package com.lixm.kotlin.video5

import java.io.File

/**
 * Describe:统计字符串个数程序开发，统计  build.gradle  文件
 *
 * Author: Lixm
 * Date: 2019/8/26
 */
fun main(args: Array<String>) {
    //方式一
    val map = HashMap<Char, Int>()
    val text = File("build.gradle")
            .readText()//读取文件
            .toCharArray()//转换成字符串数组
            .filterNot(Char::isWhitespace)//过滤掉空格
            .forEach {
                val count = map[it]
                if (count == null) map[it] = 1
                else map[it] = count + 1
            }
    map.forEach(::println)

    println("\n\n\n第二种使用分组的方式")
    File("build.gradle")
            .readText()
            .toCharArray()
            .filterNot(Char::isWhitespace)
            .groupBy { it }
            .map {
                it.key to it.value.size
            }
            .forEach(::println)
}