package com.ck2020.cklearn.db

/**
 * @author chenke
 * @create 2021/2/2
 * @Describe
 */
interface DbImp<T> {
    fun call(t: T)
}