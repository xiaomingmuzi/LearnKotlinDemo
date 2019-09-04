package com.lixm.kotlin.video7

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Describe:包装类，用于切换线程
 *
 * Author: Lixm
 * Date: 2019/9/3
 */
class UICotinuationWrapper<T>(val continuation: Continuation<T>) : Continuation<T> {

    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resumeWith(result: Result<T>) {
        //切换线程的工具类包装
       continuation.resumeWith(result)
    }

}