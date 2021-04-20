package com.starnet.usermanager.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starnet.usermanager.utils.GetRequestJsonUtils;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//不启用验证码
class LoginFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        //验证码
        //String verify_code = (String) request.getSession().getAttribute("verify_code");
        String usernameVerification = null, passwordVerification = null;
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)) {
            try {
                //用fastjson处理获取用户名和密码
                String dataJson = GetRequestJsonUtils.getRequestJsonString(request);
                System.out.println("-------------------------------");
                System.out.println(dataJson);
                System.out.println("-------------------------------");
                JSONObject loginData = JSON.parseObject(dataJson);
                usernameVerification = (String) loginData.get(getUsernameParameter());
                passwordVerification = (String) loginData.get(getPasswordParameter());
            } catch (IOException | NullPointerException e) {
            } finally {
                //String code = loginData.get("code");
                //checkCode(response, code, verify_code);
            }
            String username = usernameVerification;
            String password = passwordVerification;
            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            username = username.trim();
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        } else {
            //checkCode(response, request.getParameter("code"), verify_code);
            return super.attemptAuthentication(request, response);
        }
    }

    public void checkCode(HttpServletResponse resp, String code, String verify_code) {
        if (code == null || verify_code == null || "".equals(code) || !verify_code.toLowerCase().equals(code.toLowerCase())) {
            //验证码不正确
            throw new AuthenticationServiceException("验证码不正确");
        }
    }
    
}