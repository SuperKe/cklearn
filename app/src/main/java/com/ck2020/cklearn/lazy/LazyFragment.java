package com.ck2020.cklearn.lazy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ck2020.cklearn.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 * 这里来实现一个懒加载的fragment
 * 懒加载是一种算法，因为viewpager(非viewpager2)的预加载无法避免，所有
 * 懒加载是预加载的一种优化，对viewpager内部的arrayList<fragment>的内存优化
 *
 * @author chenke
 * @Describe 预加载优化，懒加载
 */
public abstract class LazyFragment extends Fragment {
    public final String TAG = "lazy_fragment";
    /**
     * 是否可见
     */
    private boolean isVisibleHint = false;
    /**
     * 视图是否已经创建
     */
    private boolean isViewCreated = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "====>onCreateView");
        View rootView = inflater.inflate(getLayout(), container, false);
        initView(rootView);
        return rootView;
    }

    /**
     * 抽象子类的布局文件
     *
     * @return
     */
    public abstract int getLayout();

    /**
     * 子类实现，提供布局的rootView
     *
     * @param rootView
     */
    public abstract void initView(View rootView);

    /**
     * 该方法在androidx已经被废弃
     *
     * @param isVisibleToUser
     * @deprecated {@link FragmentTransaction#setMaxLifecycle(Fragment, Lifecycle.State)}
     * 这里使用该函数实现懒加载
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i(TAG, "====>setUserVisibleHint");
        this.isVisibleHint = isVisibleToUser;
        dispatchVisibleStatus();
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "====>onResume");
        isViewCreated = true;
        dispatchVisibleStatus();
    }

    /**
     * 分发可见与不可见状态
     */
    public void dispatchVisibleStatus() {
        if (isVisibleHint && isViewCreated) {
            onStartLoad();
        } else {
            onStopLoad();
        }
    }

    /**
     * 子类重写该方法来实现开始加载数据
     */
    public void onStartLoad() {
        Log.i(TAG, "====>onStartLoad");
    }

    /**
     * 子类重写该方法来实现暂停数据加载
     */
    public void onStopLoad() {
        Log.i(TAG, "====>onStopLoad");
    }
}