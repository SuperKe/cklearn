package com.ck2020.cklearn.lazy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

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
     * 视图是否已经创建
     */
    private boolean isViewCreated = false;
    /**
     * 当前的fragment是否可见
     */
    private boolean isUserVisibleHint = false;

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + "====>onCreateView");
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(), container, false);
        }
        initView(rootView);
        isViewCreated = true;
        //第一次分发
        if (getUserVisibleHint()) {
            setUserVisibleHint(true);
        }
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
     * 可见状态发生状态会回调该函数
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isViewCreated) {
            Log.i(TAG, getClass().getSimpleName() + "====>setUserVisibleHint");
            if (!isUserVisibleHint && isVisibleToUser) {
                //从不可见->可见，加载数据
                dispatchVisibleStatus(true);
            } else if (isUserVisibleHint && !isVisibleToUser) {
                //从可见->不可见，停止加载数据
                dispatchVisibleStatus(false);
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, getClass().getSimpleName() + "====>onResume");
        //当从其他界面回到该fragment触发
        if (!isUserVisibleHint && getUserVisibleHint()) {
            dispatchVisibleStatus(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, getClass().getSimpleName() + "====>onPause");
        //当从该fragment跳出至其他界面触发
        if (isUserVisibleHint && !getUserVisibleHint()) {
            dispatchVisibleStatus(false);
        }
    }

    /**
     * 分发可见与不可见状态
     */
    public void dispatchVisibleStatus(boolean isVisibleStatus) {
        if (isVisibleStatus) {
            onStartLoad();
        } else {
            onStopLoad();
        }
        //数据加载过后，更新当前fragment的可见状态
        isUserVisibleHint = isVisibleStatus;
        //分发父级的fragment
        FragmentManager fm = getChildFragmentManager();
        List<Fragment> childFragments = fm.getFragments();
        if (childFragments.size() > 0) {
            for (Fragment fragment : childFragments) {
                if (fragment instanceof LazyFragment) {
                    if (fragment.getUserVisibleHint()) {
                        ((LazyFragment) fragment).dispatchVisibleStatus(isVisibleStatus);
                    }
                }
            }
        }
    }

    /**
     * 子类重写该方法来实现开始加载数据
     */
    public void onStartLoad() {
        Log.i(TAG, getClass().getSimpleName() + "====>开始加载数据onStartLoad");
    }

    /**
     * 子类重写该方法来实现暂停数据加载
     */
    public void onStopLoad() {
        Log.i(TAG, getClass().getSimpleName() + "====>停止加载数据onStopLoad");
    }
}