package com.ck2020.cklearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ck2020.cklearn.coroutine.CoroutineScopeActivity
import com.ck2020.cklearn.customview.verificationview.VerificationActivity
import com.ck2020.cklearn.customview.volumeview.VolumeActivity
import com.ck2020.cklearn.handler_demo.HandlerTestActivity
import com.ck2020.cklearn.sliding_conflict.NestScrollRecyclerActivity
import com.ck2020.cklearn.volatile_demo.VolatileDemoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        click()
    }

    private fun click() {
        bt_verification.setOnClickListener {
            startActivity(VerificationActivity::class.java)
        }
        bt_volume.setOnClickListener {
            startActivity(VolumeActivity::class.java)
        }
        bt_sliding_conflict.setOnClickListener {
            startActivity(NestScrollRecyclerActivity::class.java)
        }
        bt_volatile_demo.setOnClickListener {
            startActivity(VolatileDemoActivity::class.java)
        }
        bt_handler_demo.setOnClickListener {
            startActivity(HandlerTestActivity::class.java)
        }
        bt_result_api.setOnClickListener {
            //隐式启动
            startActivity(Intent("com.ck2021.cklean.FIRST"))
        }
        bt_coroutine.setOnClickListener {
            startActivity(CoroutineScopeActivity::class.java)
        }
    }

    private fun <T> startActivity(classs: Class<T>) {
        startActivity(Intent(MainActivity@ this, classs))
    }
}