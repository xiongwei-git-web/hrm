package com.dao;


import com.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface Userdao {
    public List<Users> selectall();
    public Users login(@Param("user") String user, @Param("pass") String pass);
    public  Users selectone(Integer id) ;
    public  int  add(Users users);
    public  int  update(Users users);
    public  int  delete(Integer id);
    public List<Users> selectname(Users users);
    public Users querybyusername(String usernaem);
    public Set<String> queryrolenameByUsername(String username);
    public Set<String> queryfunameByUsername(String username);
    public  List <Users> limetpage(@Param("start") Integer start, @Param("pagesize") Integer pagesize);
}
