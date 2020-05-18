package com.entity;

/**
 * 作者：熊伟
 * 部门表
 */
public class Section {
    private  Integer   sId;
    private  String    sName;
    private  String   sShow;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsShow() {
        return sShow;
    }

    public void setsShow(String sShow) {
        this.sShow = sShow;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sShow='" + sShow + '\'' +
                '}';
    }
}
