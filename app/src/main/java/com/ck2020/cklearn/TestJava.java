package com.ck2020.cklearn;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author chenke
 * @create 2021/1/27
 * @Describe
 */
class TestJava {
    public static void main(String[] args) {
        String str1 = "123", str2 = "123";
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer
        try {
            list.getClass().getMethod("add", Object.class).invoke(list, "asd");
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private void methodA(final String test) {
//        test = "a";//报错
        print(test);
    }

    private void methodB(String test) {
        test = "a";//通过
        print(test);
    }

    public void print(final String test) {
        System.out.print(test);
    }
}
