package com.dao;


import com.entity.Section;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Sectiondao {
    public List<Section> selectall();
    public  List<Section> selectname(Section section);
    public  List<Section> limeitpage(@Param("start") Integer start, @Param("pagesize") Integer pagesize);
    public  Section selectone(Integer id);
    public int add(Section section);
    public int update(Section section);
    public  int delete(Integer id);

}
