package com.dao;

import com.entity.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-02 09:31:45
 */
public interface RoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    Role queryById(Integer rId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Role> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);



    List<Role> queryAll();

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 影响行数
     */
    int deleteById(Integer rId);

}