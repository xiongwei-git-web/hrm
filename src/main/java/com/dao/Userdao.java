package com.dao;


import com.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Userdao {
    public List<Users> selectall();
    public Users login(@Param("user") String user, @Param("pass") String pass);
    public  Users selectone(Integer id) ;
    public  int  add(Users users);
    public  int  update(Users users);
    public  int  delete(Integer id);
    public List<Users> selectname(Users users);
    public  List <Users> limetpage(@Param("start") Integer start, @Param("pagesize") Integer pagesize);
}
