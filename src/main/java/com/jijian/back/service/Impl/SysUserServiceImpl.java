package com.jijian.back.service.Impl;

import com.jijian.back.entity.SysUser;
import com.jijian.back.mapper.SysUserMapper;
import com.jijian.back.service.SysUserService;
import com.jijian.business.entity.businessEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser login(String name, String password) {
        return sysUserMapper.login(name,password);
    }
}
