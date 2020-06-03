package com.controller;



import com.entity.Users;
import com.github.pagehelper.PageInfo;
import com.service.Userservice;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;


/**
 * 作者：熊伟
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private Userservice userservice;

    @RequestMapping("login")
    public String  login(@Param("user") String user, @Param("pass") String pass) throws ServletException, IOException, ParseException {
        UsernamePasswordToken token=new UsernamePasswordToken(user,pass);
        Subject subject= SecurityUtils.getSubject();
        try {
                subject.login(token);
                return "index";
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "redirect:/login.jsp";
        }

    }

    @RequestMapping("seleatall")
    public String seleatall(Model model, @RequestParam(required = false,defaultValue = "1") Integer pagenum,  @RequestParam(required = false,defaultValue = "5")Integer pagesize){

        PageInfo<Users> pageInfo=new PageInfo<>(userservice.selectall(pagenum,pagesize));
        model.addAttribute("list",pageInfo);
        return "user";
    }
    @RequiresPermissions("users:delete")
    @ResponseBody
    @RequestMapping("delete")
    public String delete(Integer id,HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        boolean boo=userservice.delete(id);
        if(boo){
            return "删除成功";
        }
        return "删除失败";
    }
    @RequiresPermissions("users:add")
    @RequestMapping("add")
    public  String  add(Users users,HttpServletResponse response) throws IOException, ParseException {
        response.setContentType("text/html;charset=utf-8");
      
        System.out.println(users);
        boolean boo=userservice.add(users);

         if(boo){
             response.getWriter().print("<script>alert('添加成功')</script>");
             return "redirect:/user/seleatall";

         }else {
             response.getWriter().print("<script>alert('添加失败')</script>");
             return "redirect:/user/seleatall";
         }

    }
    @RequiresPermissions("users:deletes")
    @RequestMapping("deletes")
    public String deletes(Integer [] ids ){
        try {
            userservice.deletes(ids);
            return "redirect:/user/seleatall";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/user/seleatall";
        }
    }
    @RequiresPermissions("users:select")
    @RequestMapping("selectname")
    public  String selectname(Users users,Model model,@RequestParam(required = false,defaultValue = "1") Integer pagenum,  @RequestParam(required = false,defaultValue = "5")Integer pagesize){
        PageInfo<Users> pageInfo=new PageInfo<>(userservice.selectname(users,pagenum,pagesize));
        model.addAttribute("list",pageInfo);
        return  "user";
    }
    @RequiresPermissions("users:update")
    @RequestMapping("update")
    public  String   update(Users users,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        boolean boo=userservice.update(users);
        if(boo){
            response.getWriter().print("<script>alert('修改成功')</script>");
            return "redirect:/user/seleatall";

        }else {
            response.getWriter().print("<script>alert('修改失败')</script>");
            return "redirect:/user/seleatall";
        }

    }
}
