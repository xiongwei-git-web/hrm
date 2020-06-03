package com.controller;

import com.entity.RoleFun;
import com.service.RoleFunService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RoleFun)表控制层
 *
 * @author makejava
 * @since 2020-06-02 10:10:03
 */
@RestController
@RequestMapping("roleFun")
public class RoleFunController {
    /**
     * 服务对象
     */
    @Resource
    private RoleFunService roleFunService;




}