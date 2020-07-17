package com.ck2020.cklearn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ck2020.cklearn.customview.verificationview.VerificationActivity
import com.ck2020.cklearn.customview.volumeview.VolumeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_verification.setOnClickListener {
            startActivity(VerificationActivity::class.java)
        }
        bt_volume.setOnClickListener {
            startActivity(VolumeActivity::class.java)
        }
    }

    private fun <T> startActivity(classs: Class<T>) {
        startActivity(Intent(MainActivity@ this, classs))
    }
}