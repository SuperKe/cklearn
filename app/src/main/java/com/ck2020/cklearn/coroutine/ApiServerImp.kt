package com.ck2020.cklearn.coroutine

import com.ck2020.cklearn.coroutine.bean.YouDaoResultBean
import com.ck2020.cklearn.coroutine.call.ApiResult
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author chenke
 * @create 2021/1/19
 * @Describe
 */
interface ApiServerImp {
    @FormUrlEncoded
    @POST("translate?doctype=json")
    suspend fun translate(@Field("i") i: String): ApiResult<YouDaoResultBean>
}