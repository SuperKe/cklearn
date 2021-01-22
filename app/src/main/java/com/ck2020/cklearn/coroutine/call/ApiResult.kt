package com.ck2020.cklearn.coroutine.call

/**
 * @author chenke
 * @create 2021/1/21
 * @Describe
 * 处理返回的密封了
 * 规范retrofit callAdapter的异常处理
 */
sealed class ApiResult<out T> {
    /**
     * 业务逻辑输出接口数据
     */
    data class onSuccess<out T>(val data: T) : ApiResult<T>()

    /**
     * 业务逻辑输出错误日志
     */
    data class onError(val code: Int, val errMessage: String?) : ApiResult<Nothing>()
}
