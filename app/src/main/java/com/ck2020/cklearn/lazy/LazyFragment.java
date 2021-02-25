package com.ck2020.cklearn.lazy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;

/**
 * @author chenke
 * @create 2021/2/25
 * @Describe
 */
public abstract class LazyFragment extends Fragment {
    private final String TAG = "lazy_fragment";
    private View mRootView;

    private boolean viewCreated = false;

    private boolean currentVisibleStatus = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayout(), container, false);
        }
        initView(mRootView);
        viewCreated = true;
        Log.i(TAG, getClass().getSimpleName() + "====>onCreateView");
        if (getUserVisibleHint()) {
            setUserVisibleHint(true);
        }
        return mRootView;
    }

    public abstract int getLayout();

    public abstract void initView(View view);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i(TAG, getClass().getSimpleName() + "====>setUserVisibleHint");
        if (viewCreated) {
            if (!currentVisibleStatus && isVisibleToUser) {
                dispatchUserVisibleStatus(true);
            } else if (currentVisibleStatus && !isVisibleToUser) {
                dispatchUserVisibleStatus(false);
            }
        }
    }

    public void dispatchUserVisibleStatus(boolean isUserVisibleStatus) {
        currentVisibleStatus = isUserVisibleStatus;
        if (isUserVisibleStatus) {
            onStartLoad();
        } else {
            onStopLoad();
        }
        //在嵌套模式下，让子类的fragment进行分发
        FragmentManager fm = getChildFragmentManager();
        List<Fragment> fragments = fm.getFragments();
        if (fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof LazyFragment) {
                    if (fragment.getUserVisibleHint()) {
                        ((LazyFragment) fragment).dispatchUserVisibleStatus(true);
                    }
                }
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint() && !currentVisibleStatus) {
            Log.i(TAG, getClass().getSimpleName() + "加载数据====>onResume");
            dispatchUserVisibleStatus(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint() && currentVisibleStatus) {
            Log.i(TAG, getClass().getSimpleName() + "暂停加载====>onPause");
            dispatchUserVisibleStatus(false);
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
