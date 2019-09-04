package com.lixm.kotlin.video7

import android.os.Handler

/**
 * Describe:
 *
 * Author: Lixm
 * Date: 2019/9/3
 */
class ChangeThread {
    companion object {
        fun change(r: Runnable) {
            val handler = Handler()
            handler.post(r)
        }
    }
}


