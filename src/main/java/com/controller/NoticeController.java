package com.controller;

import com.entity.Notice;
import com.github.pagehelper.PageInfo;
import com.service.NoticeService;
import org.apache.taglibs.standard.extra.spath.Step;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * (Notice)表控制层
 *
 * @author makejava
 * @since 2020-05-27 14:25:15
 */

@RequestMapping("notice")
@Controller
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    @RequestMapping("selectall")
   public  String  selectall(Model model,@RequestParam(required = false,defaultValue = "1") Integer pagenum, @RequestParam(required = false,defaultValue = "5")Integer pagesize){
        PageInfo<Notice> pageInfo=new PageInfo<>(noticeService.selectall(pagenum,pagesize));
        model.addAttribute("list",pageInfo);
        return "notice";
   }
   @RequestMapping("add")
   public  String  add(Notice notice, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Notice not=noticeService.insert(notice);
        if(not!=null){
            response.getWriter().print("<script>alert('添加成功')</script>");
            return "redirect:/notice/selectall";
        }else {
            response.getWriter().print("<script>alert('添加失败')</script>");
            return "redirect:/notice/selectall";
        }
   }
   @RequestMapping("update")
   public  String update(Notice notice,HttpServletResponse response) throws IOException {
       response.setContentType("text/html;charset=utf-8");
       Notice not=noticeService.update(notice);
       if(not!=null){
           response.getWriter().print("<script>alert('修改成功')</script>");
           return "redirect:/notice/selectall";
       }else {
           response.getWriter().print("<script>alert('修改失败')</script>");
           return "redirect:/notice/selectall";
       }
   }
   @RequestMapping("delete")
   @ResponseBody
    public String delete( Integer id,HttpServletResponse response){
       response.setContentType("text/html;charset=utf-8");
          boolean boo= noticeService.deleteById(id);
          if(boo){
              return "删除成功";

          }else {
              return "删除失败";
          }
    }
    @RequestMapping("selename")
    public  String selename(Notice notice,Model model,@RequestParam(required = false,defaultValue = "1") Integer pagenum, @RequestParam(required = false,defaultValue = "5")Integer pagesize){
        PageInfo<Notice> pageInfo=new PageInfo<>(noticeService.queryAll(notice,pagenum,pagesize));
        model.addAttribute("list",pageInfo);
        return "notice";
    }
    @RequestMapping("deletes")
    public  String deletes(Integer[] ids){
        try {
            noticeService.deletes(ids);
            return "redirect:/notice/selectall";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/notice/selectall";
        }
    }
}