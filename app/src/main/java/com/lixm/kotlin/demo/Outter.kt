package com.lixm.kotlin.demo

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/22
 */
open class Outter {
    val a: Int = 3

    //默认创建的内部类，是静态内部类，不能直接访问外部类的属性
    inner class Inner {
        val a: Int = 5
        fun hello() {
            //添加关键字 inner 以后，成为非静态内部类，可以直接访问外部类的属性
            println(a)
            //若内部类与外部类的属性重名时，仍需要访问外部类的属性，使用 this@Outter. 方式调用
            println(this@Outter.a)
        }
    }
}

interface OnclickListener {
    fun onClick()
}

class View {
    var onclickListener: OnclickListener? = null
}

fun main(args: Array<String>) {
    val view = View()
    view.onclickListener = object : Outter(), OnclickListener {
        override fun onClick() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}