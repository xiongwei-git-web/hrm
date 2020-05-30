package com.service.impl;

import com.dao.Postdao;

import com.entity.Post;
import com.github.pagehelper.PageHelper;
import com.service.Postservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * 作者：熊伟
 */
@Service("Postservice")
public class Postserviceimpl implements Postservice {
    @Autowired
    private Postdao postdao;
    @Override
    public List<Post> selectall(Integer pagenub,Integer pagesize) {
        PageHelper.startPage(pagenub,pagesize);
        List<Post> list=postdao.selectall();
        return list;
    }

    @Override
    public List<Post> selectall() {
        List<Post> list=postdao.selectall();
        return list;
    }

    @Override
    public List<Post> seectname(Post post,Integer pagenub,Integer pagesize) {
        PageHelper.startPage(pagenub,pagesize);
        List<Post> list =postdao.seectname(post);

        return list;
    }

    @Override
    public List<Post> selectpage(Integer pagenub, Integer pagesize) {
        int start=(pagenub-1)*pagesize;
        List<Post> list=postdao.selectpage(start,pagesize);

        return list;
    }

    @Override
    public Post selectone(Integer id) {
        Post  post=postdao.selectone(1);

        return post;
    }

    @Override
    public boolean add(Post post) {
        int i=0;
        i=postdao.add(post);

        if(i!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        int i=0;
        i=postdao.delete(id);

        if(i!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Post post) {
        int i=0;
        i=postdao.update(post);

        if(i!=0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deletes(Integer[] ids) throws Exception {
        int i=0;
        int deletecount=0;
        for(i=0;i<ids.length;i++){
            int mun=postdao.delete(ids[i]);
            deletecount+=mun;
        }
        if(deletecount<ids.length){
            throw  new Exception("删除失败");
        }
        return true;
    }
}
