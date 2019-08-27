package com.lixm.kotlin.video6

/**
 * Describe:特定域语言 DSL 编写 HTML 代码
 *
 * Author: Lixm
 * Date: 2019/8/26
 */
fun main(args: Array<String>) {
    Tag("Html").apply {
        properties["id"] = "render"
        children.add(Tag("head"))
    }.render().let(::println)

    //上述代码，添加Nodes中的html方法后，可以优化为
    html {
        properties["id"] = "render"
        children.add(Tag("head"))
    }.render().let(::println)

    html {
        "id"("html")  //对应 String.invoke(String)
//        properties["id"] = "render"
//        children.add(Tag("head"))

        //与 String.invoke(block: Tag.() -> Unit) 方法对应
        "body"{
            "id"("blockID")
        }
        //head 和 body 对应继承自Tag 的类 并与 Tag.head(block: Head.() -> Unit)  方法对应
        head {
            "id"("headId")
        }

        body {
            id = "bodyID"
            hclass = "class"

            "a"{
                "href"("http://www.baidu.com")
                +"百度 地址"  // + 对应  String.unaryPlus 加号运算符
            }
        }
    }.render().let(::println)


}