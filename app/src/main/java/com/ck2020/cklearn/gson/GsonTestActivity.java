package com.ck2020.cklearn.gson;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ck2020.cklearn.customview.Logel;
import com.ck2020.cklearn.databinding.ActivityGsonTestBinding;
import com.google.gson.Gson;

/**
 * @author chenke
 * 探索Gson在序列化json的时候，可能导致的错误
 * 因为gson在序列化的时候，依次调用了
 * 1:newDefaultConstructor(rawType) 通过反射无参构造函数来生成对象
 * 2:newDetaultImplementationConstructor(tyoe,rawType) 通过反射为 Collection 和 Map 等集合框架类型来生成对象
 * 3:newUnsafeAllocator  通过 Unsafe 包来生成对象，最后方案
 * 所以如果没有无参构造函数，这里收到后端返回的null字段，在kotlin中，将会绕过空检测机制，但是在调用的时候，kotlin会检测空安全，抛出
 * method kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull;
 * 这也是gson导致默认值不生效的原因：没有无参构造函数才用到了Unsafe构建对象
 */
public class GsonTestActivity extends AppCompatActivity {
    private ActivityGsonTestBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityGsonTestBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        String userBeanJson1 = "{\"userAge\":26}";
        mBinding.btnGson.setOnClickListener(v -> {
            //UserBean定义了kotlin的非空对象，在进行解析的时候不会报错，但是调用的时候会报错
            UserBean userBean = new Gson().fromJson(userBeanJson1, UserBean.class);
            mBinding.tvGson.setText(userBean.getUserAge() + "");
            Logel.i(userBean.getUserAge());//不会null crash
//            Logel.i(userBean.getUserName());//null crash 一般是java:userBean.getUserName.xxx  null crash
            Logel.i(userBean.getUserName());//默认值失效,这里crash，解决方法，添加默认构造函数
        });
    }
}