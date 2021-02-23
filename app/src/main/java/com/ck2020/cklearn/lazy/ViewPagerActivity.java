package com.ck2020.cklearn.lazy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ck2020.cklearn.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
    }
}