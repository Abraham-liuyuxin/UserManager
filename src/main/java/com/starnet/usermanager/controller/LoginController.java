package com.starnet.usermanager.controller;

import com.starnet.usermanager.service.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Resource
    public LoginService loginService;

    @RequestMapping("/signin")
    public Map<String,String> signin(@RequestBody Map<String,String> js){
        System.out.println("sign in" + js);
        Boolean logged = loginService.isPwdCorrected(js);
        Map auth = new HashMap();
        if(logged){
            auth.put("auth", "1");
        }
        return auth;
    }

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "json";
    }


}














