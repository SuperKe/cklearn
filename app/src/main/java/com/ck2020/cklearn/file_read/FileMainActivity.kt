package com.ck2020.cklearn.file_read

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ck2020.cklearn.databinding.ActivityFileMainBinding
import com.ck2020.cklearn.startWithClass

class FileMainActivity : AppCompatActivity() {
    private lateinit var mBind: ActivityFileMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = ActivityFileMainBinding.inflate(layoutInflater)
        setContentView(mBind.root)
        applicationContext.apply {

        }
        mBind.btFileFile.setOnClickListener {
            startWithClass(FileTestActivity::class.java)
        }
    }
}