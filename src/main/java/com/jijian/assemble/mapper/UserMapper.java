package com.jijian.assemble.mapper;


import com.jijian.assemble.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{
    List<User> selectUser();
}
