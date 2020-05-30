package com.dao;

import com.entity.Staff;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Staff)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-14 17:33:06
 */
public interface StaffDao {

    Staff queryById(Integer sId);

  List<Staff> selecatname(Staff staff);


    List<Staff> queryAll();


    int insert(Staff staff);


    int update(Staff staff);


    int deleteById(Integer sId);

}