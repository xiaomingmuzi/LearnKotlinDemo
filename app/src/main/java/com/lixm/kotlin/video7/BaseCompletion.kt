package com.lixm.kotlin.video7

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/30
 */
class BaseCompletion : Continuation<Unit> {

    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {

    }

}