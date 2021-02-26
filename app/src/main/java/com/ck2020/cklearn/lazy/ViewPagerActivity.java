package com.ck2020.cklearn.lazy;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ck2020.cklearn.databinding.ActivityViewPagerBinding;

import java.util.ArrayList;
import java.util.List;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT;

/**
 * 懒加载的viewpager+fragment
 * 嵌套模式,结构
 * viewpager[
 * fragmentOne{viewpager[fragmentA,fragmentB,fragmentC,fragmentD]},
 * fragmentTow,
 * fragmentThree,
 * fragmentFour]
 */
public class ViewPagerActivity extends AppCompatActivity {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<TextView> textViewList = new ArrayList<>();
    private ActivityViewPagerBinding mViewBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBind = ActivityViewPagerBinding.inflate(getLayoutInflater());
        setContentView(mViewBind.getRoot());

        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());
        fragmentList.add(new FragmentFour());

        textViewList.add(mViewBind.tvOne);
        textViewList.add(mViewBind.tvTwo);
        textViewList.add(mViewBind.tvThree);
        textViewList.add(mViewBind.tvFour);

        FragmentStatePagerAdapter mAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
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
        mViewBind.viewPager.setAdapter(mAdapter);
        mViewBind.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (TextView tv : textViewList) {
                    tv.setTextSize(12);
                }
                TextView tvChecked = textViewList.get(position);
                tvChecked.setTextSize(20);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewBind.tvOne.setOnClickListener(v -> {
            mViewBind.viewPager.setCurrentItem(0);
        });
        mViewBind.tvTwo.setOnClickListener(v -> {
            mViewBind.viewPager.setCurrentItem(1);
        });
        mViewBind.tvThree.setOnClickListener(v -> {
            mViewBind.viewPager.setCurrentItem(2);
        });
        mViewBind.tvFour.setOnClickListener(v -> {
            mViewBind.viewPager.setCurrentItem(3);
        });
    }
}