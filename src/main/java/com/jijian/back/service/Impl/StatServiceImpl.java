package com.jijian.back.service.Impl;

import com.jijian.back.service.StatService;
import com.jijian.business.mapper.businessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private businessMapper businessMapper;

    @Override
    public Integer businessCount(String type) {
        return businessMapper.businessCount(type);
    }
}
