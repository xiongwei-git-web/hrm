package com.entity;

import java.io.Serializable;

/**
 * (Fun)实体类
 *
 * @author makejava
 * @since 2020-06-02 09:32:00
 */
public class Fun implements Serializable {
    private static final long serialVersionUID = 718283687294905424L;
    
    private Integer fId;
    
    private String fName;
    
    private String fShow;


    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFShow() {
        return fShow;
    }

    public void setFShow(String fShow) {
        this.fShow = fShow;
    }

}