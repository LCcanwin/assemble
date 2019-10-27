package com.jijian.assemble.mapper;


import com.jijian.assemble.dto.UserInfoDTO;
import com.jijian.assemble.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper{
    Integer register(@Param("phone") String phone, @Param("password") String password);
    Integer makeToken(@Param("token") String token,@Param("phone") String phone);
    List<User> selectUser();
    UserInfoDTO getUserInfo(String phone);
    String getPassword(String phone);
    Integer userCount(String phone);
}
