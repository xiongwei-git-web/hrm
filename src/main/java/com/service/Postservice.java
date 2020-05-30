package com.service;



import com.entity.Post;

import java.util.List;

public interface Postservice {
    public List<Post> selectall(Integer pagenub,Integer pagesize);
    public List<Post> selectall();
    public List<Post> seectname(Post post,Integer pagenub,Integer pagesize);
    public List<Post> selectpage(Integer pagenub, Integer pagesize);
    public Post selectone(Integer id);
    public boolean add(Post post);
    public boolean delete(Integer id);
    public boolean update(Post post);
    public boolean deletes(Integer ids[]) throws Exception;
}
