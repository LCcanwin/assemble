package com.jijian.back.mapper;

import com.jijian.back.entity.SysUser;
import com.jijian.business.entity.businessEntity;
import org.apache.ibatis.annotations.Param;


public interface SysUserMapper {

    SysUser login(@Param("name")String name,@Param("password") String password);
}
