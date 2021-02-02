package com.ck2020.cklearn.db

import android.util.Log
import com.ck2020.cklearn.db.realm.AddressSingleBean
import io.realm.Realm

/**
 * @author chenke
 * @create 2021/2/2
 * @Describe
 * 数据库引擎操作类
 */
object DataBaseManager {
    private var mRealm: Realm = Realm.getDefaultInstance()

    fun getRealm(): Realm {
        return mRealm
    }

    fun close() {
        mRealm.close()
    }

    fun executeAddressInsertOrUpdate(addressInfo: ArrayList<AddressSingleBean>) {
        //插入异步
        mRealm.executeTransactionAsync({
            it.delete(AddressSingleBean::class.java)
            it.copyToRealmOrUpdate(addressInfo)
        }, { }, {
            it.printStackTrace()
        })
    }

    fun executeAddressFind(dbCall: DbImp<List<AddressSingleBean>>) {
        //异步
        mRealm.executeTransactionAsync({
            dbCall.call(it.where(AddressSingleBean::class.java).findAll().toMutableList())
        }, { Log.i("gw", "success") }, {
            it.printStackTrace()
        })
    }
}