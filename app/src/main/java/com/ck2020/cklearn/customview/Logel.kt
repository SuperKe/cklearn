package com.ck2020.cklearn.customview

import android.util.Log

/**
 * @author chenke
 * @create 2020/7/23
 * @Describe
 */
class Logel {
    companion object {
        @JvmStatic
        fun i(msg: String) {
            Log.i("gw", msg)
        }

        @JvmStatic
        fun i(msg: Int) {
            Log.i("gw", "$msg")
        }
    }
}