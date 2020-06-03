package com.dao;

import com.entity.Fun;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Fun)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-02 09:32:00
 */
public interface FunDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fId 主键
     * @return 实例对象
     */
    Fun queryById(Integer fId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Fun> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);



    List<Fun> queryAll();

    /**
     * 新增数据
     *
     * @param fun 实例对象
     * @return 影响行数
     */
    int insert(Fun fun);

    /**
     * 修改数据
     *
     * @param fun 实例对象
     * @return 影响行数
     */
    int update(Fun fun);

    /**
     * 通过主键删除数据
     *
     * @param fId 主键
     * @return 影响行数
     */
    int deleteById(Integer fId);

}