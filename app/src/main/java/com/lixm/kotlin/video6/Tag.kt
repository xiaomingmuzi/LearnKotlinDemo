package com.lixm.kotlin.video6

/**
 * Describe:通用标签，添加 open 可以继承
 *
 * Author: Lixm
 * Date: 2019/8/26
 */
open class Tag(var name: String) : Node {

    val children = ArrayList<Node>()//子节点  html ，body ，head
    val properties = HashMap<String, String>() //属性，宽，高，style之类的

    /**
     * String的扩展方法  invoke就是函数调用，传参的形式
     * 与main 中 "id"("html") 对应
     */
    operator fun String.invoke(value: String) {
        properties[this] = value  //this相当于该方法的调用者，也就是 id ，它的值的内容是value
    }
    /**
     * 与 main 中 "head"{}
     *
     */
    operator fun String.invoke(block: Tag.() -> Unit) {
        children.add(Tag(this).apply(block))
    }

    /**
     * 对应 a 标签中 的 +
     *  "a"{
    "href"("http://www.baidu.com")
    + "百度 地址"
    }
     */
    operator fun String.unaryPlus() {
        children.add(StringNode(this))
    }

    /**
     *   对应  this@head + Head().apply(block) 中的 + 运算符
     */
    operator fun plus(node: Node) {
        children.add(node)
    }

    // <html id="htmlid" style=""> <head> </head><body></body></html>
    override fun render(): String {
        return StringBuilder()
                .append("<")
                .append(name)
                .let { stringBuilder ->
                    if (this.properties.isNotEmpty()) {
                        stringBuilder.append(" ")
                        this.properties.forEach {
                            stringBuilder.append(it.key)
                                    .append("=\"")
                                    .append(it.value)
                                    .append("\" ")
                        }
                    }
                    stringBuilder
                }
                .append(">")
                .let { stringBuilder ->
                    children.map(Node::render)
                            .map(stringBuilder::append)
                    stringBuilder
                }
                .append("</$name>")
                .toString()
    }

}