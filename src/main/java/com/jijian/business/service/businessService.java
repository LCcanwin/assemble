package com.jijian.business.service;

import com.jijian.assemble.entity.Business;
import com.jijian.business.entity.businessEntity;

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
}
