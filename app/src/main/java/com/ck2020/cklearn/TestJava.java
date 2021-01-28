package com.ck2020.cklearn;

/**
 * @author chenke
 * @create 2021/1/27
 * @Describe
 */
class TestJava {
    public static void main(String[] args) {

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
