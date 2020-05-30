package com.service.impl;


import com.dao.Userdao;
import com.entity.Users;
import com.github.pagehelper.PageHelper;
import com.service.Userservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：熊伟
 */
@Service("usersservie    ")
public class usersservieimpl implements Userservice {
    @Autowired
    private Userdao userdao;

    public Users login(@Param("user") String  user,@Param("pass")String  pass){
      Users users=userdao.login( user,pass);
      return  users;
    }

    public List<Users> selectall(Integer pageNum,Integer pagesize){
        PageHelper.startPage(pageNum,pagesize);
        List<Users> list=new ArrayList<>();
        list=userdao.selectall();
        return list;
    }

    public  Users  selectone(Integer id){
      Users users=userdao.selectone(id);
        return users;
    }

    public  List<Users>  selectname(Users  users,Integer pageNum,Integer pagesize){
        List<Users> list=new ArrayList<>();
        PageHelper.startPage(pageNum,pagesize);
        list=userdao.selectname(users);
        return list;
    }


    public  boolean add(Users users){
        int i=0;
        i=userdao.add(users);
        if(i!=0){
            return true;
        }
        return false;
    }
  public boolean delete(Integer id){
        int i=0;
        i=userdao.delete(id);
      if(i!=0){
          return true;
      }
      return false;
  }

    @Override
    public boolean update(Users users) {
        int i=userdao.update(users);
        if(i!=0){
            return true;
        }
        return false;
    }

    @Transactional
  public boolean deletes(Integer [] ids) throws Exception {
        int i=0;
        int deletecount=0;
        for(i=0;i<ids.length;i++){
          int mun=userdao.delete(ids[i]);
          deletecount+=mun;
        }
        if(deletecount<ids.length){
            throw  new Exception("删除失败");
        }
        return true;
  }
}
