package com.controller;

import com.entity.RoleUsers;
import com.service.RoleUsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RoleUsers)表控制层
 *
 * @author makejava
 * @since 2020-06-02 10:10:15
 */
@RestController
@RequestMapping("roleUsers")
public class RoleUsersController {
    /**
     * 服务对象
     */
    @Resource
    private RoleUsersService roleUsersService;



}