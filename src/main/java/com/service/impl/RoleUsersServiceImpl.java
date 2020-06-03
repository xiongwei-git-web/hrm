package com.service.impl;

import com.entity.RoleUsers;
import com.dao.RoleUsersDao;
import com.service.RoleUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleUsers)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 10:10:15
 */
@Service("roleUsersService")
public class RoleUsersServiceImpl implements RoleUsersService {
    @Resource
    private RoleUsersDao roleUsersDao;






}