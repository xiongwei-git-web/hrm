package com.controller;

import com.entity.Fun;
import com.service.FunService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Fun)表控制层
 *
 * @author makejava
 * @since 2020-06-02 09:32:00
 */
@RestController
@RequestMapping("fun")
public class FunController {
    /**
     * 服务对象
     */
    @Resource
    private FunService funService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Fun selectOne(Integer id) {
        return this.funService.queryById(id);
    }

}