package com.jijian.client.service.impl;

import com.jijian.assemble.dto.GoodsDTO;
import com.jijian.assemble.utils.MD5Util;
import com.jijian.client.Dto.CustomerDTO;
import com.jijian.client.entity.CustomerEntity;
import com.jijian.client.mapper.CustomerMapper;
import com.jijian.client.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Integer addCustomer(CustomerEntity customerEntity) {
        //MD5 加密
//        String md5Password = MD5Util.getMD5(customerEntity.getPassword());
////        customerEntity.setPassword(md5Password);
        return customerMapper.addCustomer(customerEntity);
    }

    @Override
    public CustomerDTO loginByPassword(String phone, String password) {
        return customerMapper.loginByPassword(phone,password);
    }

    @Override
    public Integer updatePhone(String id, String phone) {
        return customerMapper.updatePhone(id,phone);
    }

    @Override
    public Integer update(CustomerEntity customerEntity) {
        return customerMapper.update(customerEntity);
    }

    @Override
    public CustomerDTO getByPhone(String phone) {
        return customerMapper.getByPhone(phone);
    }

    @Override
    public CustomerDTO get(String id) {
        return customerMapper.get(id);
    }
}
