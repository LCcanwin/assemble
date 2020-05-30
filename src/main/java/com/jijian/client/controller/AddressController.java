package com.jijian.client.controller;


import com.jijian.client.Dto.AddressDTO;

import com.jijian.client.Dto.Province;
import com.jijian.client.Dto.RegionDTO;
import com.jijian.client.Dto.TypeDto;
import com.jijian.client.entity.Address;
import com.jijian.client.service.AddressService;
import com.jijian.client.service.TypeService;
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

@Api(description = "地址相关接口")
@Controller("address")
@RequestMapping("/client/api/address")
public class AddressController {


    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "获取地址列表", notes = "获取地址列表")
    @ApiImplicitParam(name = "customerId", value = "用户id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/getListByCustomerId", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<List<AddressDTO>> getListByCustomerId(String customerId) {
        List<AddressDTO> addressList=addressService.getListByCustomerId(customerId);
        return ResultJson.getReturnJson(200, "查询成功！", addressList);
    }


    @ApiOperation(value = "新增地址", notes="新增地址")
    @ApiImplicitParam(name = "address", value = "地址实体", paramType = "body", required = true, dataType = "Address")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson<Boolean> add(@RequestBody Address address){
        if(addressService.findCountByCustomerId(String.valueOf(address.getCustomerId()))>10){
            return ResultJson.getReturnJson(500,"新增地址失败！,最多只能有10个收货地址！", false);
        }
        if(addressService.add(address)>0){
            return ResultJson.getReturnJson(200,"新增地址成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"新增地址失败！", false);
        }
    }

    @ApiOperation(value = "修改地址", notes="修改地址")
    @ApiImplicitParam(name = "address", value = "地址实体", paramType = "body", required = true, dataType = "Address")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> update(@RequestBody Address address){
        if(addressService.update(address)>0){
            return ResultJson.getReturnJson(200,"修改地址成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"修改地址失败！", true);
        }
    }

    @ApiOperation(value = "删除地址", notes="删除地址")
    @ApiImplicitParam(name = "id", value = "地址id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultJson<Boolean> delete(String id){
        if(addressService.delete(id)>0){
            return ResultJson.getReturnJson(200,"删除成功！", true);
        }else{
            return ResultJson.getReturnJson(500,"删除失败！", true);
        }
    }

    @ApiOperation(value = "设置默认地址", notes="设置默认地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地址id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "customerId", value = "用户id", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/setDefault", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> setDefault(String id,String customerId){
            addressService.setDefault(id,customerId);
            return ResultJson.getReturnJson(200,"设置成功！", true);
    }

    @ApiOperation(value = "取消默认地址", notes="取消默认地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地址id", paramType = "query", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/canalDefault", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> canalDefault(String id){
            addressService.canalDefault(id);
            return ResultJson.getReturnJson(200,"取消成功！", true);
    }


    @ApiOperation(value = "获取区域列表", notes = "获取区域列表")
    @ApiImplicitParam(name = "pId", value = "区域父Id", paramType = "query", required = false, dataType = "String")
    @RequestMapping(value = "/findRegionByPid", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<List<RegionDTO>> findRegionByPid(String pId) {
        List<RegionDTO> regionDTOS=addressService.findRegionByPid(pId);
        return ResultJson.getReturnJson(200, "查询成功！", regionDTOS);
    }
    @ApiOperation(value = "获取区域列表(所有)", notes = "获取区域列表(所有)")
    @RequestMapping(value = "/findAllRegion", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<List<Province>> findAllRegion() {
        List<Province> areaList=addressService.findAllRegion();
        return ResultJson.getReturnJson(200, "查询成功！", areaList);
    }

}
