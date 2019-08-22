package com.lixm.kotlin.demo

import com.lixm.kotlin.annotation.Poco

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/22
 */
@Poco
data class Country(var id: Int, var name: String)

class ComponentX {
    operator fun component1(): String {
        return "我是"
    }

    operator fun component2(): Int {
        return 1
    }

    operator fun component3(): Int {
        return 1
    }

    operator fun component4(): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val china = Country(0, "China")
    println(china) //data 类型的class  自动生成了get，set，toString，hasCode等方法

    //data类型的对象，有n个componentN方法，对应数据类型的第一个属性，第二个属性。。。。
    val (id, name) = china
    println("$id  $name")

    val componentX = ComponentX()
    val (a, b, c, d) = componentX
    println("$a  $b$c$d")

    //data 类型的对象，默认被编译成了final类型的java bean 对象，为了解决这一问题，需要添加两个插件
}