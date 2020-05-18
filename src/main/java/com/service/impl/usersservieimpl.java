package com.service.impl;


import com.dao.Userdao;
import com.entity.Users;
import com.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：熊伟
 */
@Service("usersservie")
public class usersservieimpl implements Userservice {
    @Autowired
    Userdao userdao;

    public Users login(String  user, String  pass){
      Users users=userdao.login("user","pass");
      System.out.println(user.toString());

      return  users;
    }

    public List<Users> selectall(){
        List<Users> list=new ArrayList<>();
        list=userdao.selectall();
        return list;
    }

    public  Users  selectone(Integer id){
      Users users=userdao.selectone(id);
        return users;
    }

    public  List<Users>  selectname(String  name){
        List<Users> list=new ArrayList<>();
        list=userdao.selectname("%"+name+"%");
        return list;
    }

    public  List<Users>  limetpage(Integer pagenub,Integer pagesize){
        List<Users> list=new ArrayList<>();
        Integer start=(pagesize-1)*pagenub;
        list=userdao.limetpage(start,pagesize);
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
}
