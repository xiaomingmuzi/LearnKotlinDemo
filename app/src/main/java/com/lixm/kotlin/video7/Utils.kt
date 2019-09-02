package com.lixm.kotlin.video7

import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/30
 */
/**
 * 开始协程
 */
fun startXieCheng(block: suspend () -> Unit) {
    //startCoroutine 只有suspend方法才有的方法
    println("开始协程喽")
    block.startCoroutine(completion = BaseCompletion())
}

/**
 * 开始加载图片
 * suspendCoroutine 方法返回的是T ,
 * T 是 ByteArray 是协程的返回值
 * continuation::resume 的返回值也是 T
 */
suspend fun startLoadImg(url: String) = suspendCoroutine<ByteArray> { continuation ->
    try {
        println("开始下载图片")
        val okHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder().url(url).build()
        val response = okHttpClient.newCall(request).execute()  // execute 同步方法
        if (response.isSuccessful) {
            response.body()?.byteStream()?.readBytes()?.let(continuation::resume)
        } else {
            continuation.resumeWithException(HttpException(response.code()))
        }
    } catch (e: Exception) {
        e.printStackTrace()
        println("下载图片异常")
    }
}