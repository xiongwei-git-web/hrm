package com.entity;

import java.io.Serializable;

/**
 * (RoleFun)实体类
 *
 * @author makejava
 * @since 2020-06-02 10:09:59
 */
public class RoleFun implements Serializable {
    private static final long serialVersionUID = 373509857722896658L;
    
    private Integer rId;
    
    private Integer fId;
    
    private Integer rfId;


    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public Integer getRfId() {
        return rfId;
    }

    public void setRfId(Integer rfId) {
        this.rfId = rfId;
    }

}