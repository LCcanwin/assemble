package com.jijian.business.controller;

import com.jijian.assemble.entity.Business;
import com.jijian.business.common.AttestationRequest;
import com.jijian.business.entity.businessEntity;
import com.jijian.business.service.businessService;
import com.jijian.common.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: chenchuan
 * Date: 2019/12/19 16:20
 * Content:
 */
@RestController
public class businessController {
    @Autowired private businessService businessService;

    @RequestMapping("/addBusiness")
    @ResponseBody
    public ResultJson insertBusiness(@RequestBody businessEntity business){
          business.setDeleted(0);
          int status = businessService.addAttestation(business);
          if(status>0){
              return  ResultJson.getReturnJson(200,"添加成功!",business.getId());
          } else {
              return  ResultJson.getReturnJson(400,"添加失败!",null);
          }
    }

    @RequestMapping(value = "/businessAttestation",method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson businessAttestation(@RequestBody AttestationRequest request){
        businessService.businessAttestation(request);
        return  ResultJson.getReturnJson(200,"认证成功!",null);
    }
}

