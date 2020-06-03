package com.dao;

import com.entity.RoleFun;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (RoleFun)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-02 10:10:00
 */
public interface RoleFunDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    RoleFun queryById( );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleFun> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleFun 实例对象
     * @return 对象列表
     */
    List<RoleFun> queryAll(RoleFun roleFun);

    /**
     * 新增数据
     *
     * @param roleFun 实例对象
     * @return 影响行数
     */
    int insert(RoleFun roleFun);

    /**
     * 修改数据
     *
     * @param roleFun 实例对象
     * @return 影响行数
     */
    int update(RoleFun roleFun);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 影响行数
     */
    int deleteById( );

}