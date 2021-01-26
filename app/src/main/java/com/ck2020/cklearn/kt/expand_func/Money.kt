package com.ck2020.cklearn.kt.expand_func

import java.math.BigDecimal

/**
 * @author chenke
 * @create 2021/1/26
 * @Describe
 */
data class Money(var amount: BigDecimal = BigDecimal(0)) {
    /**
     * 运算符重载
     */
    operator fun plus(money: Money): Money {
        return Money(amount + money.amount)
    }
}

