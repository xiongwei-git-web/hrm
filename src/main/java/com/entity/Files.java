package com.entity;

import java.io.Serializable;

/**
 * (Files)实体类
 *
 * @author makejava
 * @since 2020-05-30 16:20:52
 */
public class Files implements Serializable {
    private static final long serialVersionUID = -30305661906924184L;
    
    private Integer fId;
    
    private String fName;
    
    private Object fDate;
    
    private String fPerpson;
    
    private String fShow;
    
    private String fLocat;
    /**
     * 文件大小
     */
    
    private Integer fSize;

    private String fFfiux;


    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Object getfDate() {
        return fDate;
    }

    public void setfDate(Object fDate) {
        this.fDate = fDate;
    }

    public String getfPerpson() {
        return fPerpson;
    }

    public void setfPerpson(String fPerpson) {
        this.fPerpson = fPerpson;
    }

    public String getfShow() {
        return fShow;
    }

    public void setfShow(String fShow) {
        this.fShow = fShow;
    }

    public String getfLocat() {
        return fLocat;
    }

    public void setfLocat(String fLocat) {
        this.fLocat = fLocat;
    }

    public Integer getfSize() {
        return fSize;
    }

    public void setfSize(Integer fSize) {
        this.fSize = fSize;
    }

    public String getfFfiux() {
        return fFfiux;
    }

    public void setfFfiux(String fFfiux) {
        this.fFfiux = fFfiux;
    }
}