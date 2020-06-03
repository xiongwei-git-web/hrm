package com.service;

import com.entity.Fun;
import java.util.List;

/**
 * (Fun)表服务接口
 *
 * @author makejava
 * @since 2020-06-02 09:32:00
 */
public interface FunService {

    /**
     * 通过ID查询单条数据
     *
     * @param fId 主键
     * @return 实例对象
     */
    Fun queryById(Integer fId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Fun> queryAll();

    /**
     * 新增数据
     *
     * @param fun 实例对象
     * @return 实例对象
     */
    Fun insert(Fun fun);

    /**
     * 修改数据
     *
     * @param fun 实例对象
     * @return 实例对象
     */
    Fun update(Fun fun);

    /**
     * 通过主键删除数据
     *
     * @param fId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer fId);

}