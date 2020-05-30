package com.service.impl;

import com.entity.Notice;
import com.dao.NoticeDao;
import com.entity.Post;
import com.github.pagehelper.PageHelper;
import com.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author makejava
 * @since 2020-05-27 14:25:15
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param nId 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer nId) {
        return this.noticeDao.queryById(nId);
    }

    @Override
    public List<Notice> queryAll(Notice notice,Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Notice> list=noticeDao.queryAll(notice);
        return list;
    }

    @Override
    public List<Notice> selectall(Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Notice> list =noticeDao.selectall();
        return list;
    }


    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insert(Notice notice) {
        this.noticeDao.insert(notice);
        return notice;
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeDao.update(notice);
        return this.queryById(notice.getnId());
    }

    /**
     * 通过主键删除数据
     *
     * @param nId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer nId) {
        return this.noticeDao.deleteById(nId) > 0;
    }

    @Override
    @Transactional
    public boolean deletes(Integer[] ids) throws Exception {
        int count=0;
        for(int i=0;i<ids.length;i++){
            count+=noticeDao.deleteById(ids[i]);

        }
        if(count<ids.length){
            throw  new Exception("删除失败");
        }
        return true;
    }
}