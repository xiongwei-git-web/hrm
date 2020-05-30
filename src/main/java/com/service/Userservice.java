package com.service;



import com.entity.Users;

import java.util.List;

public interface Userservice {

    public Users login(String user, String pass);
    public List<Users> selectall(Integer pagenub,Integer pagesize);
    public  Users  selectone(Integer id);
    public  List<Users>  selectname(Users users,Integer pageNum,Integer pagesize);
    public  boolean add(Users users);
    public boolean delete(Integer id);
    public  boolean  update(Users users);
    public boolean deletes(Integer [] ids) throws Exception;

}
