package com.ck2020.cklearn.gson;

/**
 * @author chenke
 * @create 2021/2/26
 * @Describe
 */
public class UserBeanJ {
    private String userName = "test";
    private int userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
