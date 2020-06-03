package com.service;

import com.entity.Role;
import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2020-06-02 09:31:45
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    Role queryById(Integer rId);


    List<Role> queryAll();

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer rId);

}