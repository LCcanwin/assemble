package com.jijian.client.controller;


import com.jijian.client.entity.CustomerEntity;
import com.jijian.client.service.CustomerService;
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

@Api(description = "前台用户相关接口")
@Controller("customer")
@RequestMapping("/client/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "新增用户", notes="新增用户")
    @ApiImplicitParam(name = "customerEntity", value = "用户实体", paramType = "body", required = true, dataType = "CustomerEntity")
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson<Boolean> addCustomer(@RequestBody CustomerEntity customerEntity){
        if(customerService.addCustomer(customerEntity)>0){
            return ResultJson.getReturnJson(200,"新增用户成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"新增用户失败！", true);
        }
    }

    @ApiOperation(value = "换绑手机", notes="换绑手机")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "新电话号码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/updatePhone", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson<Boolean> updatePhone(String id,String phone){
        if(customerService.updatePhone(id,phone)>0){
            return ResultJson.getReturnJson(200,"修改成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"修改失败！", true);
        }
    }
}
