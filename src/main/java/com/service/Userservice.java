package com.service;



import com.entity.Users;

import java.util.List;

public interface Userservice {

    public Users login(String user, String pass);
    public List<Users> selectall();
    public  Users  selectone(Integer id);
    public  List<Users>  selectname(String name);
    public  List<Users>  limetpage(Integer pagenub, Integer pagesize);
    public  boolean add(Users users);
    public boolean delete(Integer id);
}
