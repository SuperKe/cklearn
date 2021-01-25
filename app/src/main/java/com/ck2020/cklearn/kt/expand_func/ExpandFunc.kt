package com.ck2020.cklearn.kt.expand_func

import com.blankj.utilcode.util.ToastUtils

/**
 * @author chenke
 * @create 2021/1/25
 * @Describe
 * 拓展函数
 * 只有sum和div2个函数
 * 拓展函数就是在外部写函数插入到
 */
class ExpandFunc {

    constructor() {
        print("ExpandFunc")
    }

    /**
     * func a+b
     */
    fun sumAb(a: Int, b: Int): Int {
        return a.plus(b)
    }

    /**
     * func a-b
     */
    fun divAb(a: Int, b: Int): Int {
        return a.minus(b)
    }
}