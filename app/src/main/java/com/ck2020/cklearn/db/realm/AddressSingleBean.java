package com.ck2020.cklearn.db.realm;


import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * @author chenke
 * @create 2021/2/2
 * @Describe
 */
public class AddressSingleBean extends RealmObject {
    @PrimaryKey
    private String sid;
    private String channelSid;
    private int channelId;
    private String channelName;
    private String areaSid;
    private String areaName;
    private String address;
    private String zipCode;
    private String name;
    private String phone;
    private boolean addressDefault;
    private String userSid;
    private String state;
    @Ignore
    private boolean isChoice;
    @Ignore
    private String matchWord; //搜索匹配的keyword

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getChannelSid() {
        return channelSid;
    }

    public void setChannelSid(String channelSid) {
        this.channelSid = channelSid;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getAreaSid() {
        return areaSid;
    }

    public void setAreaSid(String areaSid) {
        this.areaSid = areaSid;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAddressDefault() {
        return addressDefault;
    }

    public void setAddressDefault(boolean addressDefault) {
        this.addressDefault = addressDefault;
    }

    public String getUserSid() {
        return userSid;
    }

    public void setUserSid(String userSid) {
        this.userSid = userSid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChoice() {
        return isChoice;
    }

    public void setChoice(boolean choice) {
        isChoice = choice;
    }

    public String getMatchWord() {
        return matchWord;
    }

    public void setMatchWord(String matchWord) {
        this.matchWord = matchWord;
    }
}
