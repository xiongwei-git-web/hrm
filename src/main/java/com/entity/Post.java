package com.entity;

/**
 * 作者：熊伟
 * 职位表
 */
public class Post {
    private  Integer pId;
    private  String pName;
    private  String  pShow;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpShow() {
        return pShow;
    }

    public void setpShow(String pShow) {
        this.pShow = pShow;
    }

    @Override
    public String toString() {
        return "post{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pShow='" + pShow + '\'' +
                '}';
    }
}
