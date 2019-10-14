package com.jijian.assemble.service.impl;

import com.jijian.assemble.entity.User;
import com.jijian.assemble.mapper.UserMapper;
import com.jijian.assemble.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> searchUser1() {

        return   userMapper.selectUser();
    }

}
