package com.lixm.kotlin.video7

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import com.lixm.kotlin.R
import kotlinx.android.synthetic.main.activity_down_load_img.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class DownLoadImgActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_down_load_img)

        EventBus.getDefault().register(this)

        button.setOnClickListener {
            getImgFromNet()
        }
    }

    private fun getImgFromNet() {
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
//            val imgData = startLoadImg("https://wx2.sinaimg.cn/mw690/61e7f4aaly1g6he99w57qj20qw0fr1kx.jpg")
//            println("图片资源，字节数组的长度：${imgData.size}")
////            val bitmap = BitmapFactory.decodeByteArray(imgData, 0, imgData.size)
////            imageView.setImageBitmap(bitmap)
//            val message = Message.obtain()
//            with(message) {
//                what = 0
//                obj = imgData
//            }
//            handler.sendMessage(message)

            //封装过以后
            val imgData= startHaoShi {
                startLoadImg("https://wx2.sinaimg.cn/mw690/61e7f4aaly1g6he99w57qj20qw0fr1kx.jpg")
            }

        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun transData(changeData:ChangeAndTransData){
        val bitmap = BitmapFactory.decodeByteArray(changeData.byteArray, 0, changeData.byteArray.size)
        imageView.setImageBitmap(bitmap)
    }

    private val handler = Handler(Handler.Callback { msg ->
        when (msg!!.what) {
            0 -> {
                val bytes: ByteArray = msg.obj as ByteArray
                val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                imageView.setImageBitmap(bitmap)
            }
        }
        true
    })

    override fun onDestroy() {
        super.onDestroy()

        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }
}
