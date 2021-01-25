package com.ck2020.cklearn.kt

import com.ck2020.cklearn.kt.expand_func.ExpandFunc

/**
 * @author chenke
 * @create 2021/1/25
 * @Describe
 * 拓展，作用域为kt
 */
fun ExpandFunc.expandMul(a: Int, b: Int): Int {
    return sumAb(a, b) * divAb(a, b)
}