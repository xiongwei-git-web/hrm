package com.dao;

import com.entity.Notice;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Notice)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 14:25:15
 */
public interface NoticeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param nId 主键
     * @return 实例对象
     */
    Notice queryById(Integer nId);


    List<Notice> selectall();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param notice 实例对象
     * @return 对象列表
     */
    List<Notice> queryAll(Notice notice);

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    int insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    int update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param nId 主键
     * @return 影响行数
     */
    int deleteById(Integer nId);

}