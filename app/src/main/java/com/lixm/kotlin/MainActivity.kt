package com.lixm.kotlin

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        var sum = sum(3, 5)
        sum_txt.text = "和为：$sum"
        printProduct("6", "7")
        printProduct("000", "1")
        getStringLength("10000")
        getStringLength(111)
        useFor()
        useFor1()
        useWhile()
        print_null.text = useWhen("hello") + "\n" + useWhen(100L) + "\n" + useWhen("你好")
        useRange()
        useRange1()

        shuliediedai()
        diedai()
        useIn()
        useLambda()
    }

    abstract class Shape(val sides: List<Double>) {
        val perimeter: Double get() = sides.sum()
        abstract fun calculateArea(): Double
    }

    interface RectangleProperties {
        val isSquare: Boolean
    }

//    class Rectangle(
//            var height:Double
//    var length:Double
//    ):Shape(listOf(height,length,height,length)),RectangleProperties{
//        override val isSquare: Boolean
//            get() = length==height
//    }

    /**
     * 使用lambda表达式来过滤（filter）和映射（map）集合
     */
    fun useLambda() {
        val fruits = listOf<String>("banana", "avocado", "apple", "kiwi")
        fruits.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }

    /**
     * 使用in运算符来判断集合内是否包含某实例
     */
    fun useIn() {
        val items = setOf<String>("apple", "banana", "kiwi")
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }
    }

    /**
     * 数列迭代
     */
    fun shuliediedai() {
        for (x in 1..10 step 2) {
            print("$x ")
        }
        for (x in 9 downTo 0 step 3) {
            print("$x ")
        }
        println()
    }

    /**
     * 使用区间迭代
     */
    fun diedai() {
        for (x in 1..5) {
            print(x)
        }
        println()
    }

    /**
     * 使用区间range
     * 使用in运算符来检测某个数字是否在指定的区间内
     */
    fun useRange() {
        val x = 10
        val y = 9
        if (x in 1..y + 1)
            println("first in range")

    }

    /**
     * 检测某个数字是否在指定区间外
     */
    fun useRange1() {
        val list = listOf<String>("a", "b", "c")
        if (-1 !in 0..list.lastIndex)
            println("-1 is out of range")
        if (list.size !in list.indices)
            println("list size is out of valid list indices range too")

    }

    /**
     * 使用when表达式
     */
    fun useWhen(obj: Any): String =
            when (obj) {
                1 -> "one"
                "hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a String"
                else -> "Unknow"
            }

    /**
     * 使用while表达式
     */
    fun useWhile() {
        val items = listOf<String>("小丽", "Lee", "098")
        var index = 0
        while (index < items.size) {
            println("useWhile item at $index is ${items[index]}")
            index++
        }
    }


    fun useFor() {
        val items = listOf<String>("apple", "banana", "kiwi")
        for (item in items)
            println("userFor item is $item")
    }

    fun useFor1() {
        val items = listOf<String>("apple", "banana", "kiwi")
        for (index in items.indices)
            println("item at $index is ${items[index]}")
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 可以输出为空的函数
     */
    fun printProduct(arg1: String, arg2: String) {
        val x = Integer.parseInt(arg1)
        val y = Integer.parseInt(arg2)
        if (x != null && y != null) {
            println("arg1*arg2=" + x * y)
        } else {
            println("either '$arg1' or '$arg2' is not a number")
        }
    }

    /**
     * is 运算符检测一个表达式是否某类型的一个实例。
     * 如果一个不可变的局部变量或属性已经判断出为某类型，
     * 那么检测后的分支中可以直接当作该类型使用，无需显式转换
     */
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            //'obj'在该条件分之内自动转换成‘String’
            return obj.length
        }
        //在离开类型检测分支后，‘obj’仍然是‘Any’类型
        return null
    }

    fun getStringLength1(obj: Any): Int? {
        if (obj !is String) return null
        //‘obj’在这一分支自动转换为‘String’
        else return obj.length
    }

    fun getStringLength2(obj: Any): Int? {
        //'obj'在‘&&’右边自动转换成‘String’类型
        if (obj is String && obj.length > 0) {
            return obj.length
        }
        return null
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

}
