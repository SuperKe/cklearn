package com.ck2020.cklearn.handler_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ck2020.cklearn.R
import kotlinx.android.synthetic.main.activity_handler_test.*

class HandlerTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_test)
        //ui2() success
        tv_content.setOnClickListener {
            //fail,crash
            ui2()
        }
    }

    private fun ui2() {
        Thread {
            tv_content.text = "我是子线程，我更新了UI"
        }.start()
    }
}