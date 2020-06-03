package com.controller;

import com.alibaba.druid.mock.MockDriver;
import com.entity.Post;
import com.github.pagehelper.PageInfo;
import com.service.Postservice;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：熊伟
 */
@RequestMapping("post")
@Controller
public class PostController {
    @Autowired
    private Postservice postservice;

    @RequestMapping("selectall")
    public String  selectall(Model model, @RequestParam(required = false,defaultValue = "1") Integer pagenum, @RequestParam(required = false,defaultValue = "5")Integer pagesize){
        PageInfo<Post> pageInfo=new PageInfo<>(postservice.selectall(pagenum,pagesize)) ;
        model.addAttribute("list",pageInfo);
        return "post";
    }
    @RequiresPermissions("post:add")
    @RequestMapping("add")
    public String add(Post post, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        boolean boo=postservice.add(post);

        if(boo){
            response.getWriter().print("<script>alert('添加成功')</script>");
            return "redirect:/post/selectall";

        }else {
            response.getWriter().print("<script>alert('添加失败')</script>");
            return "redirect:/post/selectall";
        }

    }
    @RequiresPermissions("post:update")
    @RequestMapping("update")
    public String update(Post post,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        boolean boo=postservice.update(post);

        if(boo){
            response.getWriter().print("<script>alert('修改成功')</script>");
            return "redirect:/post/selectall";

        }else {
            response.getWriter().print("<script>alert('修改失败')</script>");
            return "redirect:/post/selectall";
        }
    }
    @RequiresPermissions("post:delete")
    @RequestMapping("delete")
    @ResponseBody
    public  String delete(Integer id,HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        boolean boo = postservice.delete(id);

        if (boo) {

            return "删除成功";

        } else {

            return "删除失败";
        }
    }
    @RequiresPermissions("post:deletes")
    @RequestMapping("deletes")
    public  String deletes(Integer[] ids){
        try {
            postservice.deletes(ids);
            return "redirect:/post/selectall";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/post/selectall";
        }
    }
    @RequiresPermissions("post:select")
    @RequestMapping("selectname")
    public  String  selectname(Post post,Model model, @RequestParam(required = false,defaultValue = "1") Integer pagenum, @RequestParam(required = false,defaultValue = "5")Integer pagesize){
        PageInfo<Post> pageInfo=new PageInfo<>(postservice.seectname(post,pagenum,pagesize)) ;
        model.addAttribute("list",pageInfo);
        return "post";
    }
}
