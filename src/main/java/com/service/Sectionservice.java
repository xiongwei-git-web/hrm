package com.service;


import com.entity.Section;

import java.util.List;

public interface Sectionservice {
    public List<Section> selectall(Integer pagenum,Integer pagesize);
    public List<Section> selectall();
    public List<Section> seectname(Section section,Integer pagenum,Integer pagesize);
    public List<Section> selectpage(Integer start, Integer pagesize);
    public Section selectone(Integer id);
    public boolean add(Section section);
    public boolean delete(Integer id);
    public boolean update(Section post);
    public boolean deletes(Integer [] ids) throws Exception;
}

