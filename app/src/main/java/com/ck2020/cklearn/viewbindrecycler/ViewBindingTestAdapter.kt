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
class ViewBindingTestAdapter(private val testList: MutableList<String>) : RecyclerView.Adapter<ViewBindingTestAdapter.MyViewHolder>() {
    /**
     * viewHolder中传入val 的ViewBinding，即可以在onBindViewHolder中直接get住这个viewBinding(ItemViewBindTestAdapterLayoutBinding)
     * 启发，全局可以共用一个ViewHolder(BaseViewHolder)即可以传入不同的ViewBinding对象
     */
    inner class MyViewHolder(val view: ItemViewBindTestAdapterLayoutBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingTestAdapter.MyViewHolder {
        val view = ItemViewBindTestAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.tvTest.text = testList[position]
    }

    override fun getItemCount(): Int {
        return testList.size
    }
}