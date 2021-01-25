package com.ck2020.cklearn.kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ck2020.cklearn.databinding.ActivityFuncBinding
import com.ck2020.cklearn.kt.expand_func.TestExpandActivity
import com.ck2020.cklearn.kt.high_order_func.TestHighOrderActivity

/**
 * 函数
 */
class FuncActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFuncBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFuncBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btExpand.setOnClickListener {
            startActivity(TestExpandActivity::class.java)
        }
        binding.btHigh.setOnClickListener {
            startActivity(TestHighOrderActivity::class.java)
        }
    }

    private fun <T> startActivity(classs: Class<T>) {
        startActivity(Intent(MainActivity@ this, classs))
    }
}