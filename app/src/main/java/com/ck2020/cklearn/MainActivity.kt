package com.ck2020.cklearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ck2020.cklearn.coroutine.CoroutineScopeActivity
import com.ck2020.cklearn.customview.verificationview.VerificationActivity
import com.ck2020.cklearn.customview.volumeview.VolumeActivity
import com.ck2020.cklearn.databinding.ActivityMainBinding
import com.ck2020.cklearn.file_read.FileMainActivity
import com.ck2020.cklearn.handler_demo.HandlerTestActivity
import com.ck2020.cklearn.image_compress.ImageCompressActivity
import com.ck2020.cklearn.kt.FuncActivity
import com.ck2020.cklearn.sliding_conflict.NestScrollRecyclerActivity
import com.ck2020.cklearn.volatile_demo.VolatileDemoActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        click()
    }

    private fun click() {
        binding.btVerification.setOnClickListener {
            startActivity(VerificationActivity::class.java)
        }
        binding.btVolume.setOnClickListener {
            startActivity(VolumeActivity::class.java)
        }
        binding.btSlidingConflict.setOnClickListener {
            startActivity(NestScrollRecyclerActivity::class.java)
        }
        binding.btVolatileDemo.setOnClickListener {
            startActivity(VolatileDemoActivity::class.java)
        }
        binding.btHandlerDemo.setOnClickListener {
            startActivity(HandlerTestActivity::class.java)
        }
        binding.btResultApi.setOnClickListener {
            //隐式启动
            startActivity(Intent("com.ck2021.cklean.FIRST"))
        }
        binding.btCoroutine.setOnClickListener {
            startActivity(CoroutineScopeActivity::class.java)
        }
        binding.btExpandHigh.setOnClickListener {
            startActivity(FuncActivity::class.java)
        }
        binding.btFile.setOnClickListener {
            startActivity(FileMainActivity::class.java)
        }
        binding.btnImageCompress.setOnClickListener {
            startActivity(ImageCompressActivity::class.java)
        }
    }

    private fun <T> startActivity(classs: Class<T>) {
        startActivity(Intent(MainActivity@ this, classs))
    }
}