package com.service;

import com.entity.Staff;
import java.util.List;

/**
 * (Staff)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 17:33:07
 */
public interface StaffService {
    public  Staff queryById(Integer sId);

    public List<Staff> selecatname(Staff staff,Integer pagenum,Integer pagesze);


    public List<Staff> queryAll(Integer pagenum,Integer pagesze);
    public boolean  deletes(Integer [] ids) throws Exception;

    public  int insert(Staff staff);


    public int update(Staff staff);


    public int deleteById(Integer sId);

}