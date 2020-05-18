package com.entity;

import java.util.Date;

/**
 * 作者：熊伟
 * 用户表
 */
public class Users {
    private String uId;//id
    private String uLogin;//账号
    private String uPass;//密码
    private String uName;//姓名
    private Date uDate;//创建时间
    private String uState;//账号状态

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuLogin() {
        return uLogin;
    }

    public void setuLogin(String uLogin) {
        this.uLogin = uLogin;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Date getuDate() {
        return uDate;
    }

    public void setuDate(Date uDate) {
        this.uDate = uDate;
    }

    public String getuState() {
        return uState;
    }

    public void setuState(String uState) {
        this.uState = uState;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uId='" + uId + '\'' +
                ", uLogin='" + uLogin + '\'' +
                ", uPass='" + uPass + '\'' +
                ", uName='" + uName + '\'' +
                ", uDate=" + uDate +
                ", uState='" + uState + '\'' +
                '}';
    }
}
