package com.ck2020.cklearn.coroutine

import com.ck2020.cklearn.coroutine.call.ApiResultAdapter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author chenke
 * @create 2021/1/19
 * @Describe
 * 作用域为coroutine包内
 */
private const val BASE_URL = "http://fanyi.youdao.com/"

//okHttp上层拦截器
private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(BusinessErrorInterceptor())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(ApiResultAdapter())
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()