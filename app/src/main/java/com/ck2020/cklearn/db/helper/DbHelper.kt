package com.ck2020.cklearn.db.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * @author chenke
 * @create 2021/2/3
 * @Describe
 */
class DbHelper : SQLiteOpenHelper {
    companion object {
        const val db_name = "leaner.db"
    }

    constructor(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : super(context, name, factory, version)

    private val dpCreate = "create table user(" +
            "id integer primary key autoincrement," +
            "name text," +
            "age text," +
            "gender text)"

    private val dbInsert = ""

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(dpCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
