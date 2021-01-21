package com.ck2020.cklearn.volatile_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ck2020.cklearn.R

class VolatileDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volatile_demo)
        val sum = { x: Int, y: Int -> x + y }

        val b = fun(param: Int): String {
            return param.toString()
        }
        var x = a(sum)
    }


    fun sum1(x: Int): Int {
        return x
    }

    fun a(b: (Int, Int) -> Int): Int {
        return b(5, 5)
    }
}