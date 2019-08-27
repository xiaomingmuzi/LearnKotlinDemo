package com.lixm.kotlin.video6

/**
 * Describe:专门定义html相关内容
 *
 * Author: Lixm
 * Date: 2019/8/26
 */

/**
 * 传入的block 是Tag 的扩展方法，无参，也没有返回值
 */
fun html(block: Tag.() -> Unit): Tag {
    return Tag("html").apply(block)
}

/**
 * 一定要是Tag的扩展方法，并添加到 children
 */
fun Tag.head(block: Head.() -> Unit) {
    this@head + Head().apply(block)
}

fun Tag.body(block: Body.() -> Unit) {
    this@body + Body().apply(block)
}

// + 对应  String.unaryPlus 加号运算符
class StringNode(val content: String) : Node {
    override fun render() = content
}

class Head : Tag("head")

class Body : Tag("body") {
    var id by MapDelegate(properties)

    var hclass by MapDelegate(properties)
}