package com.starnet.usermanager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface LoginMapper {

    @Select("select ucode from user_login where uname = (#{js.uname})")
    public Map<String, String> getCodeByUname(@Param("js") Map<String,String> map);

}
