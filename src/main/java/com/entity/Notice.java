package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2020-05-27 14:25:15
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = 946903904390244901L;
    
    private Integer nId;
    
    private String nName;
    
    private String nShow;
    
    private @DateTimeFormat(pattern = "yyyy-MM-dd")Date nDate;
    
    private String nPerpson;




    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public String getnShow() {
        return nShow;
    }

    public void setnShow(String nShow) {
        this.nShow = nShow;
    }

    public Date getnDate() {
        return nDate;
    }

    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }

    public String getnPerpson() {
        return nPerpson;
    }

    public void setnPerpson(String nPerpson) {
        this.nPerpson = nPerpson;
    }
}