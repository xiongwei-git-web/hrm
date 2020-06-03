package com.entity;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-06-02 09:31:45
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 324514863408393958L;
    
    private Integer rId;
    
    private String rName;
    
    private String rRemark;


    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public String getRRemark() {
        return rRemark;
    }

    public void setRRemark(String rRemark) {
        this.rRemark = rRemark;
    }

}