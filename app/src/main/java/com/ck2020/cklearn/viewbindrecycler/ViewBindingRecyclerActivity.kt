package com.ck2020.cklearn.viewbindrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ck2020.cklearn.databinding.ActivityViewBindingRecyclerBinding

class ViewBindingRecyclerActivity : AppCompatActivity() {
    private lateinit var mBind: ActivityViewBindingRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = ActivityViewBindingRecyclerBinding.inflate(layoutInflater)
        setContentView(mBind.root)
        mBind.recycle.layoutManager = LinearLayoutManager(this)
//        mBind.recycle.adapter = ViewBindingTestAdapter(mutableListOf("1", "2", "3", "4"))
        mBind.recycle.adapter = BaseViewBindingTestAdapter(mutableListOf("1", "2", "3", "4"))
    }
}