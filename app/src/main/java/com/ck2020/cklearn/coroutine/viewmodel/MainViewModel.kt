package com.ck2020.cklearn.coroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ck2020.cklearn.coroutine.ApiServer
import com.ck2020.cklearn.coroutine.call.ApiResult
import kotlinx.coroutines.launch

/**
 * @author chenke
 * @create 2021/1/20
 * @Describe
 */
class MainViewModel : ViewModel() {
    /**
     * liveData存储接口数据
     */
    val translateResult: MutableLiveData<String> = MutableLiveData()

    /**
     * 调用接口翻译
     */
    fun translate(word: String) {
        //协程作用域
        viewModelScope.launch {
            when (val youDaoResult = ApiServer.mApiRetrofit.translate(word)) {
                is ApiResult.onSuccess -> {
                    translateResult.value = youDaoResult.data.translateResult[0][0].tgt
                }
                is ApiResult.onError -> {
                    translateResult.value = youDaoResult.errMessage
                }
            }
        }
    }
}