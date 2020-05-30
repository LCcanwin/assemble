package com.jijian.client.service.impl;

import com.jijian.assemble.dto.GoodsDTO;
import com.jijian.assemble.mapper.GoodsMapper;
import com.jijian.client.Dto.CustomerDTO;
import com.jijian.client.Dto.OrderDTO;
import com.jijian.client.Dto.PinkDTO;
import com.jijian.client.entity.Order;
import com.jijian.client.entity.Pink;
import com.jijian.client.mapper.CustomerMapper;
import com.jijian.client.mapper.OrderMapper;
import com.jijian.client.mapper.PinkMapper;
import com.jijian.client.service.OrderService;
import com.jijian.client.service.PinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
public class PinkServiceImpl implements PinkService {


    @Autowired
    private PinkMapper pinkMapper;

    @Override
    public List<PinkDTO> findPinkByCustomer(String customerId) {
        return pinkMapper.findPinkByCustomer(customerId);
    }

    @Override
    public Integer add(Pink pink) {
        return pinkMapper.add(pink);
    }

    @Override
    public PinkDTO get(String id) {
        return pinkMapper.get(id);
    }

    @Override
    public List<PinkDTO> findPinkByGoodsId(String goodsId) {
        return pinkMapper.findPinkByGoodsId(goodsId);
    }
}
