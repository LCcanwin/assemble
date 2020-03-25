package com.jijian.business.service;

import com.jijian.assemble.entity.Business;
import com.jijian.business.common.AttestationRequest;
import com.jijian.business.entity.businessEntity;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 16:17
 * Content:
 */
public interface businessService {



    /**
     *添加商家认证信息
     * **/
    int  addAttestation (businessEntity business);

    /**
     * 商家注册
      * @param businessEntity
     * @return
     */
    int addBusiness(businessEntity  businessEntity);

    List<businessEntity> findList(businessEntity businessEntity);
    businessEntity get(String id);

    Integer businessDeal(String id);


    /**
     * 商家认证
     * @param request
     */
    void businessAttestation(AttestationRequest request);
}
