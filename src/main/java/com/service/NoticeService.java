package com.service;

import com.entity.Notice;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @author makejava
 * @since 2020-05-27 14:25:15
 */
public interface NoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param nId 主键
     * @return 实例对象
     */
    Notice queryById(Integer nId);

   List<Notice> queryAll(Notice notice,Integer pagenum, Integer pagesize);
    List<Notice> selectall(Integer pagenum,Integer pagesize);

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param nId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer nId);
    boolean deletes(Integer[] ids) throws Exception;

}