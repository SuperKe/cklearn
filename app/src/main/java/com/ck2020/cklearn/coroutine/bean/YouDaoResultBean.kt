package com.ck2020.cklearn.coroutine.bean

/**
 * @author chenke
 * @create 2021/1/19
 * @Describe
 */
data class YouDaoResultBean(
    val type: String,
    val elapsedTime: Int,
    val translateResult: List<List<TranslateResult>>

) {
    data class TranslateResult(
        val src: String,
        val tgt: String
    )
}


