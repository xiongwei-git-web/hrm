package com.service.impl;

import com.entity.Role;
import com.dao.RoleDao;
import com.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 09:31:45
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer rId) {
        return this.roleDao.queryById(rId);
    }


    @Override
    public List<Role> queryAll() {
        return this.roleDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getRId());
    }

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer rId) {
        return this.roleDao.deleteById(rId) > 0;
    }
}