package com.controller;

import com.entity.Section;
import com.entity.Users;
import com.github.pagehelper.PageInfo;
import com.service.Sectionservice;
import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
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
@Controller
@RequestMapping("section")
public class SectionController {
    @Autowired
    private  Sectionservice sectionservice;
  @RequestMapping("selectall")
    public String selectall(Model model, @RequestParam(required = false,defaultValue = "1") Integer pagenum, @RequestParam(required = false,defaultValue = "5")Integer pagesize){
      PageInfo<Section> pageInfo=new PageInfo<>(sectionservice.selectall(pagenum,pagesize));
      model.addAttribute("list",pageInfo);
      return "section";
    }
    @RequestMapping("add")
    public String add(Section section, HttpServletResponse response) throws IOException {
      response.setContentType("text/html;charset=utf-8");
        boolean boo=sectionservice.add(section);
        if(boo){
            response.getWriter().print("<script>alert('添加成功')</script>");
            return "redirect:/section/selectall";
        }else {
            response.getWriter().print("<script>alert('添加失败')</script>");
            return "redirect:/section/selectall";
        }

    }
    @RequestMapping("deletes")
    public String deletes(Integer[] ids,HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        System.out.println(ids);
        try {
            sectionservice.deletes(ids);
            response.getWriter().print("<script>alert('批量删除成功')</script>");
            return "redirect:/section/selectall";
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("<script>alert('批量删除失败')</script>");
            return "redirect:/section/selectall";
        }

    }
    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer id,HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
      boolean boo=sectionservice.delete(id);
      if(boo){
          return "删除成功";
      }
      return "删除失败";
    }
    @RequestMapping("updaet")
    public  String update(Section section,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
      boolean boo=sectionservice.update(section);
        if(boo){
            response.getWriter().print("<script>alert('添加成功')</script>");
            return "redirect:/section/selectall";
        }else {
            response.getWriter().print("<script>alert('添加失败')</script>");
            return "redirect:/section/selectall";
        }
    }
    @RequestMapping("selectname")
    public String  selectname(Section section,Model model,@RequestParam(required = false,defaultValue = "1") Integer pagenum, @RequestParam(required = false,defaultValue = "5")Integer pagesize){
        PageInfo<Section> pageInfo=new PageInfo<>(sectionservice.seectname(section,pagenum,pagesize));
        model.addAttribute("list",pageInfo);
        return "section";
    }
}
