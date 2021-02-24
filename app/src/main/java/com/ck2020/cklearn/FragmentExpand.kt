package com.ck2020.cklearn

import android.content.Intent
import androidx.fragment.app.Fragment

/**
 * @author chenke
 * @create 2021/2/24
 * @Describe
 * fragment拓展函数
 */
fun <T> Fragment.startActivityClass(clazz: Class<T>) {
    startActivity(Intent(activity, clazz))
}