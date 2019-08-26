package com.lixm.kotlin.video5

import java.io.BufferedReader
import java.io.FileReader

/**
 * Describe:forEach，map，flatMap，fold，reduce，let，with，use，apply等高级函数举例
 *
 * Author: Lixm
 * Date: 2019/8/23
 */
fun main(args: Array<String>) {
//    val list = listOf(1, 2, 3, 5, 6, 7)
//    第一步完成list的复制,并打印结果
//    var newList = ArrayList<Int>()
//    list.forEach {  //无返回值迭代
//       val newElement=it*2+1
//        newList.add(newElement)
//    }
//    newList.forEach(::println)
//    简化以上forEach高阶函数
//    var newList = list.map { it * 2 + 1 } //map 有返回值
//
//    val newList2=list.map { it.toDouble()}
//    newList2.forEach(::println)
//
//    整合一个整型集合的集合
//    val list = listOf(
//            1..20,
//            2..5,
//            100..105
//    )
//    平铺打印出具体数据
//    val flatList = list.flatMap {
//        it
//    }
//    平铺打印出编号
//    val flatList = list.flatMap { intRange ->
//        intRange.map { intElement ->
//            "No.$intElement"
//        }
//    }
//    flatList.forEach(::println)
//    上述lambda表达式可简化为
//    val flatList2 = list.flatMap {
//        it.map {
//            "No.$it"
//        }
//    }
//    flatList2.forEach(::println)

    //求整数的和
//    println("求以上元素的和：")
//    val flatList3 = list.flatMap { it }
//    println(flatList3.reduce { acc, i -> acc + i })

    //阶乘
//    println("求阶乘")
//    (0..6).map(::factorial).forEach(::println)

    //求阶乘的和
//    print("阶乘结果的和：")
//    println((0..6).map(::factorial).reduce { acc, i -> acc + i })
//    print("使用fold添加初始值：")
//    println((0..6).map(::factorial).fold(5, { acc, i -> acc + i }))
//    print("使用fold链接字符串：")
//    println((0..6).map(::factorial).fold(StringBuilder(), { a, i ->
//        a.append(i).append(",")
//    }))
//    print("使用joinToString拼接字符串：")
//    println((0..6).joinToString(","))
//
//    println("\n")
//    print("过滤出阶乘的奇数：")
//    println((0..6).map(::factorial).filter { it % 2 == 1 })
//    print("过滤出奇数位的元素：")
//    println((0..6).map(::factorial).filterIndexed { index, i -> index % 2 == 1 })
//    print("遇到第一个不符合规则的元素，结束运行：") //遇到第一个不符合规则的元素，结束运行
//    println((0..6).map(::factorial).takeWhile { it % 2 == 1 })

    findPerson()?.let { (name, age) ->
        //data class 可以拆分，有component函数
        println(name)
        println(age)
    }

    findPerson()?.apply {
        work()
        println(name)
    }

//    with(findPerson()){
//        work()
//        println(age)
//    }
//    val br = BufferedReader(FileReader("hello.txt"))
//    with(br) {
//        var line: String?
//        while (true) {
//            line = readLine() ?: break
//            println(line)
//        }
//        close()
//    }
    //以上内容可以简化为
//    val br = BufferedReader(FileReader("hello.txt")).readText()
//    println(br)
    //将上述with代码块，继续简化
    BufferedReader(FileReader("hello.txt")).use {
        var line: String?
        while (true) {
            line = it.readLine() ?: break
            println(line)
        }

    }
}

data class Person(val name: String, val age: Int) {
    fun work() {
        println("$name is working")
    }
}

fun findPerson(): Person? {
    return null
}

//求数据的阶乘
fun factorial(n: Int): Int {
    if (n == 0) return 1
    return (1..n).reduce { acc, i -> acc * i }
}