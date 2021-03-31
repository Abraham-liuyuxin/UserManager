package com.starnet.usermanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @RequestMapping("/signin")
    public Map<String,String> signin(@RequestParam Map<String,String> js){
        System.out.println("sign in");
        return null;
    }
}

