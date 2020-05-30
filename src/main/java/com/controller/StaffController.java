package com.controller;


import com.entity.Post;
import com.entity.Section;
import com.entity.Staff;
import com.github.pagehelper.PageInfo;
import com.service.Postservice;
import com.service.Sectionservice;
import com.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


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
    @Autowired
    private Postservice postservice;
    @Autowired
    private Sectionservice sectionservice;
    @RequestMapping("selectall")
    public  String selectall(Model model,@RequestParam(required = false,defaultValue = "1") Integer pagenum, @RequestParam(required = false,defaultValue = "5")Integer pagesize){
        PageInfo<Staff> pageInfo=new PageInfo<>(staffService.queryAll(pagenum,pagesize));
        List<Post> posts=postservice.selectall();
        List<Section>sectionlist=sectionservice.selectall();
        model.addAttribute("list",pageInfo);
        model.addAttribute("posts",posts);
        model.addAttribute("sections",sectionlist);
        return "staff";
    }
    @RequestMapping("add")
   public String add(Staff staff, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
      int i= staffService.insert(staff);
      if(i!=0){
          response.getWriter().print("<script>添加成功</script>");
          return "redirect:/staff/selectall";
      }else {
          response.getWriter().print("<script>添加失败</script>");
          return "redirect:/staff/selectall";
      }
   }
   @RequestMapping("update")
   public  String update(Staff staff,HttpServletResponse response) throws IOException {
       response.setContentType("text/html;charset=utf-8");
       int i= staffService.update(staff);
       if(i!=0){
           response.getWriter().print("<script>修改成功</script>");
           return "redirect:/staff/selectall";
       }else {
           response.getWriter().print("<script>修改失败</script>");
           return "redirect:/staff/selectall";
       }
   }
   @RequestMapping("delete")
   @ResponseBody
   public  String delete(Integer id,HttpServletResponse response){
       response.setContentType("text/html;charset=utf-8");
        int i=staffService.deleteById(id);
        if(i!=0){
            return "删除成功";
        }else {
            return "删除失败";
        }
   }
   @RequestMapping("deletes")
   public String deletes(Integer ids[]){
       try {
           staffService.deletes(ids);
           return "redirect:/staff/selectall";
       } catch (Exception e) {
           e.printStackTrace();
           return "redirect:/staff/selectall";
       }
   }
   @RequestMapping("selectname")
    public  String selectname(Staff staff,Model model,@RequestParam(required = false,defaultValue = "1") Integer pagenum, @RequestParam(required = false,defaultValue = "5")Integer pagesize){
       PageInfo<Staff> pageInfo=new PageInfo<>(staffService.selecatname(staff,pagenum,pagesize));
       List<Post> postlist=postservice.selectall();
       List<Section>sectionlist=sectionservice.selectall();
       model.addAttribute("list",pageInfo);
       model.addAttribute("posts",postlist);
       model.addAttribute("sections",sectionlist);
       return "staff";
    }
}