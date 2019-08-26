package com.lixm.kotlin.video5

/**
 * Describe:高级函数调用
 *
 * Author: Lixm
 * Date: 2019/8/23
 */
fun main(args: Array<String>) {
    args.forEach(::println)

    val helloWorld = Hello::world

    args.filter(String::isNotEmpty)

    //需要参数的函数引用，不能直接使用类名调用，需要使用对象调用
    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::println)
}

class PdfPrinter {
    fun println(any: Any) {
        //调用系统的println方法，如果不加前面包名，则会直接变成递归函数
        kotlin.io.println(any)
    }
}

class Hello {
    fun world() {
        println("Hello world")
    }
}