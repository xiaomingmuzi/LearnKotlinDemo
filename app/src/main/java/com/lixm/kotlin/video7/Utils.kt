package com.lixm.kotlin.video7

import com.lixm.kotlin.video7.async.AsyncContext
import com.lixm.kotlin.video7.async.AsyncTask
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
    block.startCoroutine(completion = ContextContinuation(AsyncContext()))
}

/**
 * 代码封装
 * <T> 表示泛型参数
 */
suspend fun <T> startHaoShi(block: () -> T) = suspendCoroutine<T> { continuation ->
    println("异步任务开始前")
    AsyncTask {
        try {
            continuation.resume(block())
        } catch (e: Exception) {
            e.printStackTrace()
            println("下载图片异常")
            continuation.resumeWithException(e)
        }
    }.execute()
}

/**
 * 开始加载图片
 * suspendCoroutine 方法返回的是T ,
 * T 是 ByteArray 是协程的返回值
 * continuation::resume 的返回值也是 T
 *
 * 封装后，变为一个普通函数
 */
 fun startLoadImg(url: String): ByteArray {
    println("异步任务开始前")
    println("开始下载图片")
    val okHttpClient = OkHttpClient.Builder().build()
    val request = Request.Builder().url(url).build()
    val response = okHttpClient.newCall(request).execute()  // execute 同步方法
    if (response.isSuccessful) {
        println("下载成功")
        response.body()?.byteStream()?.readBytes()?.let {
            return it
        }
        throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
    } else {
        println("下载失败")
        throw HttpException(response.code())
    }
}