package com.ck2020.cklearn.db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ck2020.cklearn.R
import com.ck2020.cklearn.databinding.ActivityDbHelperTestBinding

class DbHelperTestActivity : AppCompatActivity() {
    private lateinit var mBind: ActivityDbHelperTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = ActivityDbHelperTestBinding.inflate(layoutInflater)
        setContentView(mBind.root)
        mBind.btnWrite.setOnClickListener {
            val db = DataBaseManager.createDb(this)
            db.writableDatabase
        }
        mBind.btnRead.setOnClickListener {

        }
    }
}