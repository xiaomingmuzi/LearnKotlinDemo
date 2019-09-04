package com.lixm.kotlin.video7.async

import java.util.concurrent.Executors

/**
 * Describe:异步任务处理
 *
 * Author: Lixm
 * Date: 2019/9/2
 */
private val pool by lazy {
    Executors.newCachedThreadPool()
}

class AsyncTask(val block: () -> Unit) {
    fun execute() = pool.execute(block)
}