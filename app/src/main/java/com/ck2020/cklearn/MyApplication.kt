package com.ck2020.cklearn

import android.app.Application
import com.didichuxing.doraemonkit.DoraemonKit

/**
 * @author chenke
 * @create 2021/2/2
 * @Describe
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DoraemonKit.install(this, mutableListOf(), "25b65423ec1ec7e29908d56fe8d9db33")
    }
}