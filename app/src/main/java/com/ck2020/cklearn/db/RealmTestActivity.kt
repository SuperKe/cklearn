package com.ck2020.cklearn.db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ck2020.cklearn.databinding.ActivityRealmTestBinding
import com.ck2020.cklearn.db.realm.AddressSingleBean
import io.realm.Realm
import io.realm.RealmConfiguration
import java.lang.StringBuilder

class RealmTestActivity : AppCompatActivity() {
    private lateinit var mBind: ActivityRealmTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = ActivityRealmTestBinding.inflate(layoutInflater)
        setContentView(mBind.root)
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("test.db")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)

        mBind.btnWrite.setOnClickListener {
            val list = ArrayList<AddressSingleBean>()
            for (i in 0..10) {
                val address = AddressSingleBean()
                address.areaSid = "$i"
                address.areaName = "地址${i}"
                list.add(address)
            }
            DataBaseManager.executeAddressInsertOrUpdate(list)
        }
        mBind.btnRead.setOnClickListener {
            DataBaseManager.executeAddressFind(object : DbImp<List<AddressSingleBean>> {
                override fun call(t: List<AddressSingleBean>) {
                    val stringBuilder = StringBuilder()
                    t.forEach {
                        stringBuilder.append("${it.areaName}")
                    }
                    mBind.tvAddress.text = stringBuilder.toString()
                }
            })
        }
    }
}