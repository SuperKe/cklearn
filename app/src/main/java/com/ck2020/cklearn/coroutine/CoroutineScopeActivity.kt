package com.ck2020.cklearn.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ck2020.cklearn.R
import com.ck2020.cklearn.coroutine.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_coroutine_scope.*

class CoroutineScopeActivity : AppCompatActivity() {

    private val mViewModel: MainViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_scope)
        bt_translate.setOnClickListener {
            mViewModel.translate(et_translate.text.toString())
        }
        mViewModel.translateResult.observeForever {
            tv_translate.text = "$it"
        }
    }
}