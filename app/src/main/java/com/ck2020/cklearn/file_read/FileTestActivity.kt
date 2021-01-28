package com.ck2020.cklearn.file_read

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.constant.PermissionConstants
import com.blankj.utilcode.util.PermissionUtils
import com.ck2020.cklearn.databinding.ActivityFileTestBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream

class FileTestActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityFileTestBinding
    private var isSuccess = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFileTestBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        PermissionUtils
            .permission(PermissionConstants.STORAGE)
            .callback(object : PermissionUtils.SimpleCallback {
                override fun onGranted() {
                    isSuccess = true
                }

                override fun onDenied() {
                    isSuccess = false
                }
            }).request()
        mBinding.btFileSave.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val editSave = mBinding.etFileTest.text.toString()
                val saveResult = withContext(Dispatchers.IO) {
                    doFile(editSave, ::save)
                }
                mBinding.tvSaveResult.text = "保存结果：${saveResult}"
            }
        }
        mBinding.btFileRead.setOnClickListener {
            //todo 生命周期和app生命一样，最终使用viewModelScope
            GlobalScope.launch(Dispatchers.Main) {
                val readResult = withContext(Dispatchers.IO) {
                    doFile("读取结果：", ::read)
                }
                mBinding.tvFileRead.text = "${readResult}"
            }
        }
    }

    suspend fun doFile(message: String, doFile: (String) -> String): String {
        return doFile.invoke(message)
    }

    private fun save(message: String): String {
        return if (isSuccess) {
            try {
                val openOut = openFileOutput("data.txt", Context.MODE_PRIVATE)
                openOut.use {
                    it.write(message.toByteArray())
                }
                "success"
            } catch (e: Exception) {
                e.printStackTrace()
                "failed"
            }
        } else {
            "没有权限"
        }
    }

    private fun read(txt: String): String {
        return if (isSuccess) {
            try {
                val openOut = openFileInput("data.txt")
                val reader = BufferedInputStream(openOut)
                val message = StringBuilder()
                message.append(txt)
                reader.use {
                    message.append(it.reader().readText())
                }
                message.toString()
            } catch (e: Exception) {
                e.printStackTrace()
                "${e.printStackTrace()}"
            }

        } else {
            "没有权限"
        }
    }
}
