package com.ck2020.cklearn.coroutine

/**
 * @author chenke
 * @create 2021/1/19
 * @Describe
 * api
 * 这里可以配置多个base的Retrofit
 */
object ApiServer {
    val mApiRetrofit: ApiServerImp by lazy { retrofit.create(ApiServerImp::class.java) }
}