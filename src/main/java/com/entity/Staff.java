package com.entity;

import java.io.Serializable;

/**
 * (Staff)实体类
 *
 * @author makejava
 * @since 2020-05-14 17:33:05
 */
public class Staff implements Serializable {
    private static final long serialVersionUID = 968150711478212941L;
    
    private Integer sId;
    
    private String sName;
    
    private String sAge;
    
    private String sPhone;
    
    private String sEmail;
    
    private Integer sPostid;
    
    private String sEducation;
    
    private String sUserid;
    
    private Integer sSectionid;
    
    private String sSite;
    
    private Object sDate;


    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSAge() {
        return sAge;
    }

    public void setSAge(String sAge) {
        this.sAge = sAge;
    }

    public String getSPhone() {
        return sPhone;
    }

    public void setSPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getSEmail() {
        return sEmail;
    }

    public void setSEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public Integer getSPostid() {
        return sPostid;
    }

    public void setSPostid(Integer sPostid) {
        this.sPostid = sPostid;
    }

    public String getSEducation() {
        return sEducation;
    }

    public void setSEducation(String sEducation) {
        this.sEducation = sEducation;
    }

    public String getSUserid() {
        return sUserid;
    }

    public void setSUserid(String sUserid) {
        this.sUserid = sUserid;
    }

    public Integer getSSectionid() {
        return sSectionid;
    }

    public void setSSectionid(Integer sSectionid) {
        this.sSectionid = sSectionid;
    }

    public String getSSite() {
        return sSite;
    }

    public void setSSite(String sSite) {
        this.sSite = sSite;
    }

    public Object getSDate() {
        return sDate;
    }

    public void setSDate(Object sDate) {
        this.sDate = sDate;
    }

}