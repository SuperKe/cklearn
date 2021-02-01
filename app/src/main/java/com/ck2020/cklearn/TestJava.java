package com.ck2020.cklearn;

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
