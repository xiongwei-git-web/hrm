package com.dao;


import com.entity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Postdao {
    public List<Post> selectall();
    public List<Post> seectname(Post post);
    public List<Post> selectpage(@Param("start") Integer start, @Param("pagesize") Integer pagesize);
    public Post selectone(Integer id);
    public int add(Post post);
    public int delete(Integer id);
    public int update(Post post);

}
