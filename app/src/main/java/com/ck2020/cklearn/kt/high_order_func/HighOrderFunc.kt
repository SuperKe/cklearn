package com.ck2020.cklearn.kt.high_order_func

import com.blankj.utilcode.util.ToastUtils

/**
 * @author chenke
 * @create 2021/1/25
 * @Describe
 * 高阶函数
 * 概念，如果一个函数，支持入参为函数类型的参数
 * 即该函数为高阶函数:写法
 * (a:type,b:type)->return_type
 * (a:Int,b:Int)->String
 * a:入参，类型int
 * b:入参，类型int
 * ->String:函数类型参数返回值
 */
object HighOrderFunc {
    /**
     * 加
     */
    fun plus(a: Int, b: Int): Int {
        return a.plus(b)
    }

    /**
     * 减
     */
    fun minus(a: Int, b: Int): Int {
        return a.minus(b)
    }

    /**
     * a:普通入参String
     * b:普通入参Int
     * func:函数类型入参Func
     */
    fun highOrderFuncSimple(a: Int, b: Int, func: (Int, Int) -> Int): String {
        return "a入参:${a}\nb入参${b}\n函数计算结果:${func.invoke(a, b)}"
    }
}