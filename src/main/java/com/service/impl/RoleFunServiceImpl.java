package com.service.impl;

import com.entity.RoleFun;
import com.dao.RoleFunDao;
import com.service.RoleFunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleFun)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 10:10:02
 */
@Service("roleFunService")
public class RoleFunServiceImpl implements RoleFunService {
    @Resource
    private RoleFunDao roleFunDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    @Override
    public RoleFun queryById( ) {
        return this.roleFunDao.queryById();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RoleFun> queryAllByLimit(int offset, int limit) {
        return this.roleFunDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param roleFun 实例对象
     * @return 实例对象
     */
    @Override
    public RoleFun insert(RoleFun roleFun) {
        this.roleFunDao.insert(roleFun);
        return roleFun;
    }

    /**
     * 修改数据
     *
     * @param roleFun 实例对象
     * @return 实例对象
     */


    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.roleFunDao.deleteById() > 0;
    }
}