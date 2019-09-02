package com.lixm.kotlin.video7

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/8/30
 */
object HttpError {
    const val HTTP_ERROR_NO_DATA = 999
    const val HTTP_ERROR_UNKNOWN = 998
}

data class HttpException(val code: Int) : Exception()