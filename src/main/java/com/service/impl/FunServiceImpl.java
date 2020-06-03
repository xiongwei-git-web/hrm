package com.service.impl;

import com.entity.Fun;
import com.dao.FunDao;
import com.service.FunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Fun)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 09:32:00
 */
@Service("funService")
public class FunServiceImpl implements FunService {
    @Resource
    private FunDao funDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fId 主键
     * @return 实例对象
     */
    @Override
    public Fun queryById(Integer fId) {
        return this.funDao.queryById(fId);
    }


    @Override
    public List<Fun> queryAll() {
        return this.funDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param fun 实例对象
     * @return 实例对象
     */
    @Override
    public Fun insert(Fun fun) {
        this.funDao.insert(fun);
        return fun;
    }

    /**
     * 修改数据
     *
     * @param fun 实例对象
     * @return 实例对象
     */
    @Override
    public Fun update(Fun fun) {
        this.funDao.update(fun);
        return this.queryById(fun.getFId());
    }

    /**
     * 通过主键删除数据
     *
     * @param fId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer fId) {
        return this.funDao.deleteById(fId) > 0;
    }
}