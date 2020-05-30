package com.service.impl;

import com.dao.Sectiondao;

import com.entity.Section;
import com.github.pagehelper.PageHelper;
import com.service.Sectionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

/**
 * 作者：熊伟
 */
@Service("sectionservice")
public class Sectionserviceimpl implements Sectionservice {
    @Autowired
    private Sectiondao sectiondao;

    @Override
    public List<Section> selectall(Integer pagenum,Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Section> list=sectiondao.selectall();
        return list;
    }

    @Override
    public List<Section> selectall() {
        List<Section> list=sectiondao.selectall();
        return list;
    }

    @Override
    public List<Section> seectname(Section section, Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Section> list=sectiondao.selectname(section);
        return list;

    }


    @Override
    public List<Section> selectpage(Integer pagenub, Integer pagesize) {
        int start=(pagenub-1)*pagesize;
        List<Section> list=sectiondao.limeitpage(start,pagesize);
        return list;
    }

    @Override
    public Section selectone(Integer id) {
        Section section1=sectiondao.selectone(id);
        return section1;
    }

    @Override
    public boolean add(Section section) {
        int i=0;
        i=sectiondao.add(section);
        if(i!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        int i=0;
        i=sectiondao.delete(id);
        if(i!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Section section) {
        int i=0;
        i=sectiondao.update(section);
        if(i!=0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deletes(Integer[] ids) throws Exception {
        int deletecount=0;
        for(int i=0;i<ids.length;i++){
            deletecount+=sectiondao.delete(ids[i]);
        }
        if(deletecount<ids.length){
            throw  new Exception("删除失败");
        }
        return true;
    }
}
