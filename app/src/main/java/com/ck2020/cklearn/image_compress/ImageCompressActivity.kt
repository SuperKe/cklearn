package com.ck2020.cklearn.image_compress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ck2020.cklearn.R
import com.ck2020.cklearn.databinding.ActivityImageCompressBinding
import com.ck2020.cklearn.databinding.ItemImageCompressLayoutBinding
import com.ck2020.cklearn.viewbindrecycler.BaseViewHolderKotlin

class ImageCompressActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityImageCompressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityImageCompressBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.recycle.layoutManager = LinearLayoutManager(this)
        mBinding.recycle.adapter = ImageAdapter()
    }

    inner class ImageAdapter : RecyclerView.Adapter<BaseViewHolderKotlin<ItemImageCompressLayoutBinding>>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolderKotlin<ItemImageCompressLayoutBinding> {
            val holder = ItemImageCompressLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return BaseViewHolderKotlin(holder)
        }

        override fun onBindViewHolder(holder: BaseViewHolderKotlin<ItemImageCompressLayoutBinding>, position: Int) {
            holder.viewBind.ivSrc.setImageBitmap(ImageCompressUtil.resizeBitmap(this@ImageCompressActivity, R.mipmap.image_test, 150, 150, false))
//            holder.viewBind.ivSrc.setImageResource(R.mipmap.image_test)
//            holder.viewBind.ivSrc.setImageBitmap(BitmapFactory.decodeResource(this@ImageCompressActivity.resources,R.mipmap.image_test))
        }

        override fun getItemCount(): Int {
            return 100
        }
    }
}