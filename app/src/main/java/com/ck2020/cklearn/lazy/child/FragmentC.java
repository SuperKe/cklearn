package com.ck2020.cklearn.lazy.child;

import android.view.View;
import android.widget.TextView;

import com.ck2020.cklearn.R;
import com.ck2020.cklearn.lazy.LazyFragment;
import com.ck2020.cklearn.lazy.LazyFragmentX;

/**
 * @author chenke
 * @create 2021/2/23
 * @Describe
 */
public class FragmentC extends LazyFragmentX {

    @Override
    public int getLayout() {
        return R.layout.fragment_a;
    }

    @Override
    public void initView(View rootView) {
        TextView tvMain = rootView.findViewById(R.id.tv_main);
        tvMain.setText("C");
    }
}
