package com.ck2020.cklearn.kt.expand_func

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.ToastUtils
import com.ck2020.cklearn.databinding.ActivityTestExpandBinding
//这里是作用域，整个kt包可见
import com.ck2020.cklearn.kt.expandMul

class TestExpandActivity : AppCompatActivity() {
    private lateinit var mExpandBind: ActivityTestExpandBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mExpandBind = ActivityTestExpandBinding.inflate(layoutInflater)
        setContentView(mExpandBind.root)
        mExpandBind.btExpandRun.setOnClickListener {
            ToastUtils.showShort("${ExpandFunc().expandMul(15, 10)}")
        }
    }
}