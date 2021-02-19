package com.ck2020.cklearn.viewbindrecycler;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * @author chenke
 * @create 2021/2/19
 * @Describe java 版本
 */
public class BaseViewHolderJ<T extends ViewBinding> extends RecyclerView.ViewHolder {
    public T t;

    public BaseViewHolderJ(T t) {
        super(t.getRoot());
        this.t = t;
    }
}
