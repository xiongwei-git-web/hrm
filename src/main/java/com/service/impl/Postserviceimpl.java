package com.service.impl;

import com.dao.Postdao;

import com.entity.Post;
import com.service.Postservice;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 作者：熊伟
 */
@Service("Postservice")
public class Postserviceimpl implements Postservice {
    Postdao postdao;
    @Override
    public List<Post> selectall() {
        List<Post> list=postdao.selectall();

        return list;
    }

    @Override
    public List<Post> seectname(Post post) {
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
}
