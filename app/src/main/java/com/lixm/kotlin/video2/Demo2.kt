package com.lixm.kotlin.video2

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/28
 */
open class 人(val 姓名: String, val 性格: String, val 喜欢: String) {
    init {
        println("$姓名 的性格$性格，喜欢$喜欢")
    }
}

class 妹子(val name: String, val character: String, val like: String) : 人(name, character, like)
class 帅哥(val name: String, val character: String, val like: String) : 人(name, character, like)

fun main(args: Array<String>) {
    val 妹子 = 妹子("袁咏仪", "开朗", "买包包")
    val 帅哥 = 帅哥("张智霖", "宠老婆", "给老婆买包包")
    println(妹子 is 人)
}