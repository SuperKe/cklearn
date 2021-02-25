package com.ck2020.cklearn.lazy;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ck2020.cklearn.R;
import com.ck2020.cklearn.lazy.child.FragmentA;
import com.ck2020.cklearn.lazy.child.FragmentB;
import com.ck2020.cklearn.lazy.child.FragmentC;
import com.ck2020.cklearn.lazy.child.FragmentD;

import java.util.ArrayList;
import java.util.List;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

/**
 * @author chenke
 * @create 2021/2/23
 * @Describe
 */
public class FragmentOne extends LazyFragmentX {

    @Override
    public int getLayout() {
        return R.layout.fragment_one;
    }

    private TextView tvA, tvB, tvC, tvD;
    private List<TextView> tvList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager mViewPage;

    @Override
    public void initView(View rootView) {
        mViewPage = rootView.findViewById(R.id.view_pager);
        tvA = rootView.findViewById(R.id.tv_a);
        tvB = rootView.findViewById(R.id.tv_b);
        tvC = rootView.findViewById(R.id.tv_c);
        tvD = rootView.findViewById(R.id.tv_d);
        fragmentList.add(new FragmentA());
        fragmentList.add(new FragmentB());
        fragmentList.add(new FragmentC());
        fragmentList.add(new FragmentD());
        tvList.add(tvA);
        tvList.add(tvB);
        tvList.add(tvC);
        tvList.add(tvD);
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        mViewPage.setAdapter(mAdapter);
    }
}
