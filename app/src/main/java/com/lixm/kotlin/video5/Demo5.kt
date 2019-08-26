package com.lixm.kotlin.video5

/**
 * Describe:函数复合 f(g(x))
 *
 * Author: Lixm
 * Date: 2019/8/26
 */

val add5 = { i: Int -> i + 5 }
val multiplyBy2 = { i: Int -> i * 2 }

fun main(args: Array<String>) {
    println(multiplyBy2(add5(8)))

    val add5AndThenMultiply = (add5 andThen multiplyBy2)
    println("方法一复合方法二的结果：${add5AndThenMultiply(8)}")
    val add5ComposeMultiply = add5 compose multiplyBy2
    println("方法二复合方法一的计算结果：${add5ComposeMultiply(8)}")
}

//复合函数,先执行方法一，在执行方法二
infix fun <P1, P2, R> Function1<P1, P2>.andThen(function: Function1<P2, R>): Function1<P1, R> {
    return fun(p1: P1): R {
        return function.invoke(this.invoke(p1))
    }
}
//复合函数，先执行方法二，在执行方法一
infix fun <P1, P2, R> Function1<P2, R>.compose(function: Function1<P1, P2>): Function1<P1, R> {
    return fun(p1: P1): R {
        return this.invoke(function.invoke(p1))
    }
}