package com.shiro;

import com.dao.Userdao;
import com.entity.Users;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.Set;


/**
 * 作者：熊伟
 */
public class Myshiro extends AuthorizingRealm {
    @Autowired
    Userdao userdao;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=principalCollection.toString();
        Set<String> roles=userdao.queryrolenameByUsername(username);
        Set<String> fun =userdao.queryfunameByUsername(username);
        SimpleAuthorizationInfo  authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(fun);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
         String uLogin=token.getPrincipal().toString();
        Users user=userdao.querybyusername(uLogin);

        if(user==null||"2".equals(user.getuState())){
            throw  new UnknownAccountException("用户不存在或状态不允许");
        }else {
            SimpleAuthenticationInfo authorizationInfo=new SimpleAuthenticationInfo(uLogin,user.getuPass(),this.getName());
            Session session=  SecurityUtils.getSubject().getSession();
                session.setAttribute("user",user);
            return authorizationInfo;
        }
    }
}