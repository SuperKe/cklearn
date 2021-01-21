package com.ck2020.cklearn.sliding_conflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.ck2020.cklearn.customview.Logel;

/**
 * @author chenke
 * @create 2020/7/23
 * @Describe
 */
class MyNestedScrollview extends NestedScrollView implements NestedScrollView.OnScrollChangeListener {

    public MyNestedScrollview(@NonNull Context context) {
        this(context, null);
    }

    public MyNestedScrollview(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private int totalHeight = 0;
    private Context context;

    public MyNestedScrollview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setOnScrollChangeListener(this);
        //计算除recylce之外的控件高度
        post(new Runnable() {
            @Override
            public void run() {
                if (getChildCount() > 0) {
                    //获取到LinearLayout
                    View contentView = getChildAt(0);
                    if (contentView instanceof LinearLayout) {
                        //遍历全部的View，得到recycler以上的view的高度
                        if (((LinearLayout) contentView).getChildCount() > 0) {
                            for (int i = 0; i < ((LinearLayout) contentView).getChildCount(); i++) {
                                final View childView = ((LinearLayout) contentView).getChildAt(i);
                                if (childView instanceof RecyclerView) {
                                    return;
                                }
                                totalHeight += childView.getHeight();
                                Logel.i("i:" + i);
                                Logel.i("totalHeight:" + totalHeight);
                            }
                        }
                    }
                }
            }
        });
    }


    public void withRecyclerView(MyRecyclerView recyclerView) {
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
            //滑动到底部
            Logel.i("loadMore");
        }
    }
}
