package com.ck2020.cklearn.viewbindrecycler

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author chenke
 * @create 2021/2/19
 * @Describe
 *kotlin版本
 */
class BaseViewHolder<T : ViewBinding>(val t: T) : RecyclerView.ViewHolder(t.root)
