package com.service;

import com.entity.RoleFun;
import java.util.List;

/**
 * (RoleFun)表服务接口
 *
 * @author makejava
 * @since 2020-06-02 10:10:01
 */
public interface RoleFunService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    RoleFun queryById( );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleFun> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param roleFun 实例对象
     * @return 实例对象
     */
    RoleFun insert(RoleFun roleFun);

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
    boolean deleteById( );

}