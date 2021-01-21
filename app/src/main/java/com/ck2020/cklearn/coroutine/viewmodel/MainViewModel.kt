package com.ck2020.cklearn.coroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ck2020.cklearn.coroutine.ApiServer
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
            val youDaoResult = ApiServer.mApiRetrofit.translate(word)
            translateResult.value = youDaoResult.translateResult[0][0].tgt
        }
    }
}