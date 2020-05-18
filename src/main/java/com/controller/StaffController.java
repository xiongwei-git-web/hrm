package com.controller;

import com.entity.Staff;
import com.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.Contended;

import javax.annotation.Resource;

/**
 * (Staff)表控制层
 *
 * @author makejava
 * @since 2020-05-14 17:33:08
 */
@Controller
@RequestMapping("staff")
public class StaffController {
    /**
     * 服务对象
     */
    @Autowired
    private StaffService staffService;


}