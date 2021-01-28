package com.ck2020.cklearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 * @author chenke
 * @create 2021/1/28
 * @Describe
 */
fun <T> AppCompatActivity.startWithClass(classs: Class<T>) {
    startActivity(Intent(this, classs))
}