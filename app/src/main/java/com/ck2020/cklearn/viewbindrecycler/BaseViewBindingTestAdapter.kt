package com.ck2020.cklearn.viewbindrecycler

import android.view.LayoutInflater
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

    RecyclerView.Adapter<BaseViewHolderKotlin<ItemViewBindTestAdapterLayoutBinding>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolderKotlin<ItemViewBindTestAdapterLayoutBinding> {
        val view = ItemViewBindTestAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BaseViewHolderKotlin(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolderKotlin<ItemViewBindTestAdapterLayoutBinding>, position: Int) {
        holder.viewBind.tvTest.text = testList[position]
    }

    override fun getItemCount(): Int {
        return testList.size
    }
}