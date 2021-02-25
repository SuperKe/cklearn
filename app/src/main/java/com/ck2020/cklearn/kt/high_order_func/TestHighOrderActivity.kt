package com.ck2020.cklearn.kt.high_order_func

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.ToastUtils
import com.ck2020.cklearn.databinding.ActivityHighOrderBinding

/**
 * 高阶函数
 */
class TestHighOrderActivity : AppCompatActivity() {
    private lateinit var mHighOrderBind: ActivityHighOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHighOrderBind = ActivityHighOrderBinding.inflate(layoutInflater)
        setContentView(mHighOrderBind.root)
        mHighOrderBind.btPlus.setOnClickListener {
            //执行plus函数
            val a = mHighOrderBind.etHighA.text.toString().toInt()
            val b = mHighOrderBind.etHighB.text.toString().toInt()
            val c = mHighOrderBind.etNumberC.text.toString().toInt()
            val d = mHighOrderBind.etNumberD.text.toString().toInt()
            val result = HighOrderFunc.highOrderFuncSimple(a, b) { _, _ ->
                c + d
            }
            val result_ = HighOrderFunc.highOrderFuncSimple(a, b, ::plus)
            ToastUtils.showShort(result_)
            mHighOrderBind.tvResult.text = "$result"
        }
        mHighOrderBind.btMinus.setOnClickListener {
            //执行minus函数
            val a = mHighOrderBind.etHighA.text.toString().toInt()
            val b = mHighOrderBind.etHighB.text.toString().toInt()
            val c = mHighOrderBind.etNumberC.text.toString().toInt()
            val d = mHighOrderBind.etNumberD.text.toString().toInt()
            val result = HighOrderFunc.highOrderFuncSimple(a, b) { _, _ ->
                c - d
            }
            mHighOrderBind.tvResult.text = "$result"
            val result_ = HighOrderFunc.highOrderFuncSimple(a, b, ::minus)
            ToastUtils.showShort(result_)
        }
        val result = HighOrderFunc.highOrderFuncSimple(1, 2, sum)
    }

    /**
     * 函数类型
     */
    val sum = { x: Int, y: Int -> x + y }

    /**
     * 加
     */
    fun plus(a: Int, b: Int): Int {
        return a.plus(b)
    }

    /**
     * 减
     */
    fun minus(a: Int, b: Int): Int {
        return a.minus(b)
    }

    fun methodA(final2: String) {
        val final3 = "The parameter is " + final2
    }

    fun methodB(final2: String) {
        val final3 = "The parameter is " + final2
    }

    val d = { b: Int -> b.toString() }
}