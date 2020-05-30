package com.jijian.client.service.impl;

import com.jijian.assemble.dto.GoodsDTO;
import com.jijian.assemble.entity.Goods;
import com.jijian.assemble.mapper.GoodsMapper;
import com.jijian.client.Dto.*;
import com.jijian.client.entity.Address;
import com.jijian.client.entity.Order;
import com.jijian.client.entity.Pink;
import com.jijian.client.mapper.AddressMapper;
import com.jijian.client.mapper.CustomerMapper;
import com.jijian.client.mapper.OrderMapper;
import com.jijian.client.mapper.PinkMapper;
import com.jijian.client.service.AddressService;
import com.jijian.client.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private PinkMapper pinkMapper;


    @Override
    public List<OrderDTO> findOrderByCustomer(String customerId) {

        return orderMapper.findOrderByCustomer(customerId);
    }

    @Override
    public Integer add(Order order) {
        String orderNum=getNumByTime();
        order.setOrderNumber(orderNum);
        //单独购买
        order.setPinkFlag("1");
        order.setPinkId(0);
        return orderMapper.add(order);
    }

    @Override
    public Integer update(Order order) {
        return orderMapper.update(order);
    }

    @Override
    public OrderDTO get(String id) {
        OrderDTO orderDTO = orderMapper.get(id);
        if(orderDTO!=null){
            CustomerDTO customerDTO = customerMapper.get(String.valueOf(orderDTO.getUid()));
            GoodsDTO goods = goodsMapper.get(orderDTO.getGoodsId());
            orderDTO.setCustomer(customerDTO);
            orderDTO.setGoods(goods);

            if(orderDTO.getPinkFlag().equals("0")){
                PinkDTO pinkDTO = pinkMapper.get(orderDTO.getPinkId());
                orderDTO.setPink(pinkDTO);
            }

        }

        return orderDTO;
    }


    /**
     * 发起拼单
     * @param order
     */
    @Override
    @Transactional
    public void addPink(Order order) {

        String orderNum=getNumByTime();
        order.setOrderNumber(orderNum);
        Integer add = orderMapper.add(order);
        if(add>0){
            OrderDTO orderDTO = orderMapper.getByOrderNumber(orderNum);
            Pink pink = new Pink();
            String pinkNum=getNumByTime();
            pink.setPinkNum(pinkNum);
            pink.setHeadId(order.getUid());
            pink.setHeadOrderId(Integer.valueOf(orderDTO.getId()));
            pink.setGoodsId(order.getGoodsId());

            Calendar c = Calendar.getInstance();
            Date startTime = c.getTime();
            c.add(Calendar.DAY_OF_MONTH, 1);
            Date endTime= c.getTime();

            pink.setStartTime(startTime);
            pink.setEndTime(endTime);
            pink.setStatus(1);
            if(pinkMapper.add(pink)>0){
                    PinkDTO temp=pinkMapper.getByPinkNum(pinkNum);
                    //设置该订单未拼团订单
                    order.setId(Integer.valueOf(orderDTO.getId()));
                    order.setPinkId(Integer.valueOf(temp.getId()));
                    order.setPinkFlag("0");
                   orderMapper.update(order);
            }
        }

    }

    /**
     * 参与拼单
     * @param order
     */
    @Override
    @Transactional
    public void joinPink(Order order) {
        PinkDTO pinkDTO=pinkMapper.get(String.valueOf(order.getPinkId()));

        if(pinkDTO!=null){
            order.setPinkFlag("0");
            String orderNum=getNumByTime();
            order.setOrderNumber(orderNum);
            orderMapper.add(order);

            OrderDTO tmp=orderMapper.getByOrderNumber(orderNum);


            Pink pink=new Pink();
            pink.setId(Integer.valueOf(pinkDTO.getId()));
            pink.setJoinId(order.getUid());
            pink.setJoinOrderId(Integer.valueOf(tmp.getId()));
            //设置该拼单已经完成
            pink.setStatus(2);
            pinkMapper.update(pink);

        }

    }

    @Override
    public Integer pay(String id) {
        Order order=new Order();
        order.setId(Integer.valueOf(id));
        order.setStatus(1);
        return orderMapper.update(order);
    }

    @Override
    public Integer shipments(String id) {
        Order order=new Order();
        order.setId(Integer.valueOf(id));
        order.setStatus(2);
        return orderMapper.update(order);
    }

    @Override
    public Integer reap(String id) {
        Order order=new Order();
        order.setId(Integer.valueOf(id));
        order.setStatus(3);
        return orderMapper.update(order);
    }

    @Override
    public Integer evaluate(String id, String evaluate) {
        Order order=new Order();
        order.setId(Integer.valueOf(id));
        order.setStatus(4);
        order.setEvaluate(evaluate);
        return orderMapper.update(order);
    }

    //根据当前时间生成一个唯一字符串
    private  String getNumByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
    }

}
