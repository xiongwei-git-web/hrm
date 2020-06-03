package com.shiro;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者：熊伟
 */
public class Error  implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
           e.printStackTrace();
           ModelAndView mv=null;
           if(e instanceof UnauthenticatedException){
               return  new ModelAndView("redirect:/no.jsp");
           }else if(e instanceof AuthorizationException){
               return  new ModelAndView("redirect:/login.jsp");
           }else {
               return  new ModelAndView("redirect:/error.jsp");
           }
  
    }
}
