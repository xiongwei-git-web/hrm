package com.controller;



import com.entity.Users;
import com.github.pagehelper.PageInfo;
import com.service.Userservice;
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
    public void  login( String user, String pass,HttpSession session, HttpServletResponse response ,HttpServletRequest request) throws ServletException, IOException, ParseException {
        Users users=userservice.login(user,pass);
        if(users==null||"2".equals(users.getuState())) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script>alert('登入失败');window.location.href='/login.jsp'</script>");
            return;
        }
         session.setAttribute("user",users);
       request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }
    @RequestMapping("quit")
    public void quit(HttpSession session,HttpServletResponse response) throws IOException {
        session.removeAttribute("user");
       response.sendRedirect("/login.jsp");
    }
    @RequestMapping("seleatall")
    public String seleatall(Model model, @RequestParam(required = false,defaultValue = "1") Integer pagenum,  @RequestParam(required = false,defaultValue = "5")Integer pagesize){

        PageInfo<Users> pageInfo=new PageInfo<>(userservice.selectall(pagenum,pagesize));
        model.addAttribute("list",pageInfo);
        return "user";
    }
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
    @RequestMapping("selectname")
    public  String selectname(Users users,Model model,@RequestParam(required = false,defaultValue = "1") Integer pagenum,  @RequestParam(required = false,defaultValue = "5")Integer pagesize){
        PageInfo<Users> pageInfo=new PageInfo<>(userservice.selectname(users,pagenum,pagesize));
        model.addAttribute("list",pageInfo);
        return  "user";
    }
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
