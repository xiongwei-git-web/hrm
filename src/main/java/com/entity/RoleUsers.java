package com.entity;

import java.io.Serializable;

/**
 * (RoleUsers)实体类
 *
 * @author makejava
 * @since 2020-06-02 10:10:14
 */
public class RoleUsers implements Serializable {
    private static final long serialVersionUID = 467453716157747458L;
    
    private Integer rId;
    
    private Integer uId;


    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

}