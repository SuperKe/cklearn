package com.ck2020.cklearn.viewbindrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ck2020.cklearn.databinding.ItemViewBindTestAdapterLayoutBinding

/**
 * @author chenke
 * @create 2021/2/19
 * @Describe
 * adapter中使用viewBinding
 */
class BaseViewBindingTestAdapter(private val testList: MutableList<String>) :

    RecyclerView.Adapter<BaseViewHolder<ItemViewBindTestAdapterLayoutBinding>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemViewBindTestAdapterLayoutBinding> {
        val view = ItemViewBindTestAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemViewBindTestAdapterLayoutBinding>, position: Int) {
        holder.t.tvTest.text = testList[position]
    }

    override fun getItemCount(): Int {
        return testList.size
    }
}