package com.lixm.kotlin.video7

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.lixm.kotlin.R
import kotlinx.android.synthetic.main.activity_down_load_img.*

class DownLoadImgActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_down_load_img)
        button.setOnClickListener {
            getImgFromNet()
        }
    }

    fun getImgFromNet() {
//        val okHttpClient = OkHttpClient.Builder().build()
//        val request = Request.Builder().url("https://wx2.sinaimg.cn/mw690/61e7f4aaly1g6he99w57qj20qw0fr1kx.jpg").build()
//        okHttpClient.newCall(request).enqueue(object : Callback { //enqueue 异步方法
//            override fun onFailure(call: Call, e: IOException) {
//                Log.e("getImgFromNet", "ERROR")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                val bytes = response.body()?.bytes()
//                val message = Message.obtain()
//                with(message) {
//                    what = 0
//                    obj = bytes
//                }
//                handler.sendMessage(message)
//            }
//        })
        startXieCheng {
            val imgData = startLoadImg("https://wx2.sinaimg.cn/mw690/61e7f4aaly1g6he99w57qj20qw0fr1kx.jpg")
            val bitmap = BitmapFactory.decodeByteArray(imgData, 0, imgData.size)
            imageView.setImageBitmap(bitmap)
        }

    }

    val handler = Handler(object : Handler.Callback {
        override fun handleMessage(msg: Message?): Boolean {
            when (msg!!.what) {
                0 -> {
                    val bytes: ByteArray = msg.obj as ByteArray
                    val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                    imageView.setImageBitmap(bitmap)
                }
            }
            return true
        }
    })
}
