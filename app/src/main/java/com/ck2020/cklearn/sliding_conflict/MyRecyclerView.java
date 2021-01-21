package com.ck2020.cklearn.sliding_conflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author chenke
 * @create 2020/7/24
 * @Describe
 */
class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {

            }

            @Override
            public void onViewDetachedFromWindow(View v) {

            }
        });
    }

    /**
     * 是否拦截滚动
     */
    private boolean isInterceptScroll = false;

    /**
     * @param isInterceptScroll 是否让recyclerview滚动
     */
    public void setEnableScroll(boolean isInterceptScroll) {
        setNestedScrollingEnabled(isInterceptScroll);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return !isInterceptScroll;
    }
}
