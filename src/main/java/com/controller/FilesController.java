package com.controller;

import com.entity.Files;
import com.entity.Users;
import com.github.pagehelper.PageInfo;
import com.service.FilesService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

/**
 * (Files)表控制层
 *
 * @author makejava
 * @since 2020-05-30 16:20:57
 */
@Controller
@RequestMapping("files")
public class FilesController {
    /**
     * 服务对象
     */
    @Resource
    private FilesService filesService;
    @RequestMapping("selectall")
    public  String selectall(Model model,@RequestParam(required = false,defaultValue = "1") Integer pagenum, @RequestParam(required = false,defaultValue = "5")Integer pagesize){
        PageInfo<Files> pageInfo=new PageInfo<>(filesService.queryAll(pagenum,pagesize));
        model.addAttribute("list",pageInfo);
        return "files";
    }
    @RequestMapping("add")
    public String add(HttpServletRequest request, MultipartFile file, Files files, HttpSession session){
        if(file==null || file.getSize()==0){
            return "redirect:/files/selectall";
        }
        try {
            String documentdir="document";
        String dir=request.getServletContext().getRealPath("document");
        String filename= UUID.randomUUID().toString();
        String fileffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filepath=dir+"/"+filename+fileffix;
            file.transferTo(new File(filepath));
            Users users= (Users) session.getAttribute("user");
            files.setfPerpson(users.getuName());
            files.setfFfiux(fileffix);
            files.setfSize((int) file.getSize());
            files.setfDate(new Date());
            files.setfLocat(documentdir+"/"+filename+fileffix);
            filesService.insert(files);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/files/selectall";
    }
    @RequestMapping("download")
    public  void   download(HttpServletResponse response,HttpServletRequest request,Integer id){
      Files file=filesService.queryById(id);
      if(file==null){
          return ;
      }
        InputStream inputStream=null;
        try {
            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(file.getfName()+file.getfFfiux(),"UTF-8"));
            String dir=request.getServletContext().getRealPath("");
            inputStream=new FileInputStream(dir+"/"+file.getfLocat());
            OutputStream out=response.getOutputStream();
            int len=0;
            byte[] bytes=new byte[1204];
            while((len=inputStream.read(bytes))>0){
                    out.write(bytes,0,len);
            }
            out.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}