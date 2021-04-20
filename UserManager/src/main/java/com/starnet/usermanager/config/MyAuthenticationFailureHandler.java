package com.starnet.usermanager.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter out = httpServletResponse.getWriter();
        JSONObject jo = new JSONObject();
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException){
            jo.put("Msg", "用户名或密码错误,请重新输入");
        }else if(e instanceof DisabledException){
            jo.put("Msg", "账户被禁用，请联系管理员");
        }else if (e instanceof LockedException){
            jo.put("Msg", "账户被锁定，请联系管理员");
        }else if(e instanceof AccountExpiredException){
            jo.put("Msg", "账户过期，请联系管理员");
        }else if(e instanceof CredentialsExpiredException){
            jo.put("Msg", "密码过期，请联系管理员");
        }
        out.write(jo.toString());
        out.flush();
        out.close();
    }
}
