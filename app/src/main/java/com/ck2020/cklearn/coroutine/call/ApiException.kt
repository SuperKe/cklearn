package com.ck2020.cklearn.coroutine.call

import java.io.IOException

/**
 * @author chenke
 * @create 2021/1/21
 * @Describe
 */
class ApiException(val errorCode: Int, val errorMsg: String) : IOException()