package com.service.impl;

import com.entity.Staff;
import com.dao.StaffDao;
import com.github.pagehelper.PageHelper;
import com.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * (Staff)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 17:33:07
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private  StaffDao staffDao;
    @Override
    public Staff queryById(Integer sId) {

        return staffDao.queryById(sId);
    }

    @Override
    public List<Staff> selecatname(Staff staff,Integer pagenum,Integer pagesze) {
        PageHelper.startPage(pagenum,pagesze);
        List<Staff> list= staffDao.selecatname(staff);
        return list;
    }

    @Override
    public List<Staff> queryAll(Integer pagenum,Integer pagesze) {
        PageHelper.startPage(pagenum,pagesze);
        List<Staff> list= staffDao.queryAll();
        return list;
    }

    @Override
    @Transactional
    public boolean deletes(Integer[] ids) throws Exception {

        int i=0;
        int deletecount=0;
        for(i=0;i<ids.length;i++){
            int mun=staffDao.deleteById(ids[i]);
            deletecount+=mun;
        }
        if(deletecount<ids.length){
            throw  new Exception("删除失败");
        }
        return true;
    }

    @Override
    public int insert(Staff staff) {

        return staffDao.insert(staff);
    }

    @Override
    public int update(Staff staff) {
        return staffDao.update(staff);
    }

    @Override
    public int deleteById(Integer sId) {
        return staffDao.deleteById(sId);
    }

}