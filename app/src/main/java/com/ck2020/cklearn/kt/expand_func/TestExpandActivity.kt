package com.ck2020.cklearn.kt.expand_func

//这里是作用域，整个kt包可见
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.ToastUtils
import com.ck2020.cklearn.databinding.ActivityTestExpandBinding
import com.ck2020.cklearn.kt.expandMul
import java.math.BigDecimal

class TestExpandActivity : AppCompatActivity() {
    private lateinit var mExpandBind: ActivityTestExpandBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mExpandBind = ActivityTestExpandBinding.inflate(layoutInflater)
        setContentView(mExpandBind.root)
        mExpandBind.btExpandRun.setOnClickListener {
            ToastUtils.showShort("${ExpandFunc().expandMul(15, 10)}")
        }
        mExpandBind.btnOperator.setOnClickListener {
            val money1 = Money(BigDecimal(mExpandBind.etOne.text.toString()))
            val money2 = Money(BigDecimal(mExpandBind.etTwo.text.toString()))
            ToastUtils.showShort("money1+money2=${(money1 + money2).amount.toDouble()}")
        }

    }
}