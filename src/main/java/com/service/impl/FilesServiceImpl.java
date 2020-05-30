package com.service.impl;

import com.entity.Files;
import com.dao.FilesDao;
import com.github.pagehelper.PageHelper;
import com.service.FilesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Files)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 16:20:56
 */
@Service("filesService")
public class FilesServiceImpl implements FilesService {
    @Resource
    private FilesDao filesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fId 主键
     * @return 实例对象
     */
    @Override
    public Files queryById(Integer fId) {
        return this.filesDao.queryById(fId);
    }


    @Override
    public List<Files> queryAll(Integer pagenum,Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Files>list=filesDao.queryAll();
        return list;
    }

    /**
     * 新增数据
     *
     * @param files 实例对象
     * @return 实例对象
     */
    @Override
    public Files insert(Files files) {
        this.filesDao.insert(files);
        return files;
    }

    /**
     * 修改数据
     *
     * @param files 实例对象
     * @return 实例对象
     */
    @Override
    public Files update(Files files) {
        this.filesDao.update(files);
        return this.queryById(files.getfId());
    }

    /**
     * 通过主键删除数据
     *
     * @param fId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer fId) {
        return this.filesDao.deleteById(fId) > 0;
    }
}