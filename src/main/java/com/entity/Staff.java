package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

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

    private  Post  post;
    private  Section  section;
    private String sEducation;
    
    private String sUserid;
    
    private Integer sSectionid;
    
    private String sSite;

      private   @DateTimeFormat(pattern = "yyyy-MM-dd") Date sDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getsAge() {
        return sAge;
    }

    public void setsAge(String sAge) {
        this.sAge = sAge;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public Integer getsPostid() {
        return sPostid;
    }

    public void setsPostid(Integer sPostid) {
        this.sPostid = sPostid;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getsEducation() {
        return sEducation;
    }

    public void setsEducation(String sEducation) {
        this.sEducation = sEducation;
    }

    public String getsUserid() {
        return sUserid;
    }

    public void setsUserid(String sUserid) {
        this.sUserid = sUserid;
    }

    public Integer getsSectionid() {
        return sSectionid;
    }

    public void setsSectionid(Integer sSectionid) {
        this.sSectionid = sSectionid;
    }

    public String getsSite() {
        return sSite;
    }

    public void setsSite(String sSite) {
        this.sSite = sSite;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sAge='" + sAge + '\'' +
                ", sPhone='" + sPhone + '\'' +
                ", sEmail='" + sEmail + '\'' +
                ", sPostid=" + sPostid +
                ", post=" + post +
                ", section=" + section +
                ", sEducation='" + sEducation + '\'' +
                ", sUserid='" + sUserid + '\'' +
                ", sSectionid=" + sSectionid +
                ", sSite='" + sSite + '\'' +
                ", sDate=" + sDate +
                '}';
    }
}