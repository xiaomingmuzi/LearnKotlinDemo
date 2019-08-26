package com.lixm.kotlin.video5

/**
 * Describe:闭包
 *
 * Author: Lixm
 * Date: 2019/8/23
 */
val string = "Hello world"

fun makeFun(): () -> Unit {
    var count = 0
    return fun() {
        println(++count)
    }
}

fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return fun(): Long {
        val result = second
        second += first
        first = second - first
        return result
    }
}

//使用迭代器打印斐波拉契函数
fun fibonacci2(): Iterable<Long> {
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator() {
            override fun hasNext() = true
            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }
        }
    }
}

//fun add(x: Int) = fun(y: Int) = x + y
//等价于
fun add(x: Int): (Int) -> Int {

    //也可以定一个类
    data class Persong(val name:String)

    return fun(y: Int): Int {
        return x + y
    }
}

fun main(args: Array<String>) {
//    val x = makeFun()
//    x()
//    x()
//    x()
//    x()
//    x()
//    x() //输出 1 2 3 4 5 6  说明count的值没有释放，一直在累加

//    val x = fibonacci()
//    println(x())
//    println(x())
//    println(x())
//    println(x())
//    println(x())
//    println(x())

//    for (i in fibonacci2()) {
//        if (i > 100) break
//        println(i)
//    }

    val add5 = add(5)
    println(add5(2))
}