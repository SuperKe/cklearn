package com.ck2020.cklearn.lazy.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * @author chenke
 * @create 2021/2/24
 * @Describe
 * kotlin版本懒加载简易版，没有stopLoad
 */
public abstract class LazyFragmentKt : Fragment() {
    // 界面是否已创建完成
    private var isViewCreated = false

    // 是否对用户可见
    private var isVisibleToUser = false

    // 数据是否已请求
    private var isDataLoaded = false
    public abstract fun getLayout(): Int
    public abstract fun initView(view: View)

    /**
     * 第一次可见时触发调用,此处实现具体的数据请求逻辑
     */
    public fun onStartLoad() {

    }

    private var mRootView: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayout(), container, false)
        }
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(mRootView!!)
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        tryLoadData()
        tryLoadWithOutResume()
    }

    /**
     * 保证在initData后触发
     */
    override fun onResume() {
        super.onResume()
        isViewCreated = true
        tryLoadData()
        tryLoadWithOutResume()
    }

    /**
     * ViewPager场景下，判断父fragment是否可见
     */
    private fun isParentVisible(): Boolean {
        val fragment: Fragment? = parentFragment
        return fragment == null || (fragment is LazyFragmentKt && fragment.isVisibleToUser) ||
                (fragment is LazyFragmentKt && fragment.isVisibleToUser)
    }

    /**
     * ViewPager场景下，当前fragment可见时，如果其子fragment也可见，则让子fragment请求数据
     */
    private fun dispatchParentVisibleState() {
        val fragmentManager: FragmentManager = childFragmentManager
        val fragments: List<Fragment> = fragmentManager.fragments
        if (fragments.isEmpty()) {
            return
        }
        for (child in fragments) {
            if (child is LazyFragmentKt && child.isVisibleToUser) {
                child.tryLoadData()
            }
        }
    }

    private fun tryLoadData() {
        if (isViewCreated && isVisibleToUser && isParentVisible()) {
            onStartLoad()
            //通知子Fragment请求数据
            dispatchParentVisibleState()
        }
    }

    private fun tryLoadWithOutResume() {
        if (isViewCreated && isVisibleToUser && isParentVisible() && isDataLoaded) {
            isDataLoaded = true
            //通知子Fragment请求数据
            lazyLoadDataWithOutResume()
            dispatchParentVisibleState()
        }
    }

    /**
     *第一次可见时触发调用,此处实现具体的数据请求逻辑,第二次onResume时候不触发
     */
    public fun lazyLoadDataWithOutResume() {

    }
}