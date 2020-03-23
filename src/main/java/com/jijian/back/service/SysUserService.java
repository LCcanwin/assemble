package com.jijian.back.service;

import com.jijian.back.entity.SysUser;
import com.jijian.business.entity.businessEntity;


public interface SysUserService {
   SysUser login(String name,String password);

}
