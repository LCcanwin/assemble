package com.jijian.client.controller;


import com.jijian.client.Dto.AddressDTO;
import com.jijian.client.Dto.OrderDTO;
import com.jijian.client.Dto.Province;
import com.jijian.client.Dto.RegionDTO;
import com.jijian.client.entity.Address;
import com.jijian.client.entity.Order;
import com.jijian.client.service.AddressService;
import com.jijian.client.service.OrderService;
import com.jijian.common.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(description = "订单相关接口")
@Controller("order")
@RequestMapping("/client/api/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "获取用户订单列表", notes = "获取用户订单列表")
    @ApiImplicitParam(name = "customerId", value = "用户id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/findOrderByCustomer", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<List<OrderDTO>> getListByCustomerId(String customerId) {
        List<OrderDTO> orderDTOList=orderService.findOrderByCustomer(customerId);
        return ResultJson.getReturnJson(200, "查询成功！", orderDTOList);
    }


    @ApiOperation(value = "新增订单(单独购买)", notes="新增订单(单独购买)")
    @ApiImplicitParam(name = "order", value = "订单实体", paramType = "body", required = true, dataType = "Order")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson<Boolean> add(@RequestBody Order order){
        if(orderService.add(order)>0){
            return ResultJson.getReturnJson(200,"下单成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"下单失败！", false);
        }
    }

    @ApiOperation(value = "新增订单(发起拼单)", notes="新增订单(发起拼单)")
    @ApiImplicitParam(name = "order", value = "订单实体", paramType = "body", required = true, dataType = "Order")
    @RequestMapping(value = "/addPink", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson<Boolean> addPink(@RequestBody Order order){
        orderService.addPink(order);
        return ResultJson.getReturnJson(200,"下单成功！", true);

    }
    @ApiOperation(value = "新增订单(参与拼单)", notes="新增订单(参与拼单)")
    @ApiImplicitParam(name = "order", value = "订单实体", paramType = "body", required = true, dataType = "Order")
    @RequestMapping(value = "/joinPink", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson<Boolean> joinPink(@RequestBody Order order){
        orderService.joinPink(order);
        return ResultJson.getReturnJson(200,"拼单成功！", true);

    }

    @ApiOperation(value = "修改订单", notes="修改订单")
    @ApiImplicitParam(name = "order", value = "地址实体", paramType = "body", required = true, dataType = "Order")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> update(@RequestBody Order order){
        if(orderService.update(order)>0){
            return ResultJson.getReturnJson(200,"修改成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"修改失败！", true);
        }
    }


    @ApiOperation(value = "获取订单详情", notes = "获取订单详情")
    @ApiImplicitParam(name = "id", value = "订单id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<OrderDTO> get(String id) {
        OrderDTO orderDTO = orderService.get(id);
        return ResultJson.getReturnJson(200, "查询成功！", orderDTO);
    }


    @ApiOperation(value = "付款（暂用）", notes = "付款（暂用）")
    @ApiImplicitParam(name = "id", value = "订单id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<Boolean> pay(String id) {
        if(orderService.pay(id)>0){
            return ResultJson.getReturnJson(200,"支付成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"支付失败！", false);
        }
    }

    @ApiOperation(value = "发货", notes = "发货")
    @ApiImplicitParam(name = "id", value = "订单id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/shipments", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<Boolean> shipments(String id) {
        if(orderService.shipments(id)>0){
            return ResultJson.getReturnJson(200,"发货成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"发货失败！", false);
        }
    }
    @ApiOperation(value = "收货", notes = "收货")
    @ApiImplicitParam(name = "id", value = "订单id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/reap", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<Boolean> reap(String id) {
        if(orderService.reap(id)>0){
            return ResultJson.getReturnJson(200,"收货成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"收货失败！", false);
        }
    }
    @ApiOperation(value = "评价", notes = "评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "订单id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "evaluate", value = "用户评价", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/evaluate", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<Boolean> evaluate(String id,String evaluate) {
        if(orderService.evaluate(id,evaluate)>0){
            return ResultJson.getReturnJson(200,"评价成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"评价失败！", false);
        }
    }

}
