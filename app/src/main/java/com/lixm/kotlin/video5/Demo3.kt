package com.lixm.kotlin.video5

/**
 * Describe:递归优化
 *
 * Author: Lixm
 * Date: 2019/8/23
 */
data class ListNode(var value: Int, var next: ListNode? = null)

//尾递归 添加关键字 tailrec 标明递归
tailrec fun findListNode(head: ListNode?, value: Int): ListNode? {
    head ?: return null
    if (head.value == value) return head
    return findListNode(head.next, value) //返回结点自身，属于尾递归
}

fun main(args: Array<String>) {
    val MAX_COUNT = 100000
    val head = ListNode(0)
    var p = head
    //初始化一个链表
    for (i in 0..MAX_COUNT) {
        p.next = ListNode(i)
        p = p.next!!
    }

    //当MAX_COUNT 的值很大时，同样的尾递归方法，添加了tailrec 关键字后，进行了优化，没有出现崩溃的问题
    println(findListNode(head, MAX_COUNT - 2)?.value)
}


//求阶乘,返回的是一个n乘个体，不属于尾递归  同样添加 tailrec 关键字以后，系统提示该方法并不属于尾递归
fun fastoria(n: Long): Long {
    return n * fastoria(n - 1)
}

data class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//不属于尾递归
fun findTreeNode(root: TreeNode?, value: Int): TreeNode? {
    root ?: return null
    if (root.value == value) return root
    return findTreeNode(root.left, value) ?: findTreeNode(root.right, value)
}