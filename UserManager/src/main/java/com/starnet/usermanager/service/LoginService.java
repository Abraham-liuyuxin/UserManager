package com.starnet.usermanager.service;

import com.starnet.usermanager.mapper.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Resource
    public LoginMapper loginMapper;

    public boolean isPwdCorrected(Map<String,String> map){
        String uname = map.get("uname");
        String ucode = map.get("ucode");
        Map<String,String> name = new HashMap();
        name.put("uname", uname);
        System.out.println(name);
        Map<String, String> code = loginMapper.getCodeByUname(name);
        String pwd = code.get("ucode");
        if(ucode.equals(pwd)) {
            return true;
        }
        return false;
    }
}
