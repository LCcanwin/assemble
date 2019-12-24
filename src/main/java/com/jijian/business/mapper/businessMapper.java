package com.jijian.business.mapper;

import com.jijian.assemble.entity.Business;
import com.jijian.business.entity.businessEntity;

/**
 * Author: chenchuan
 * Date: 2019/12/19 16:05
 * Content:
 */
public interface businessMapper {
    /**
     *添加商家认证信息
     * **/
    int  insertAttestation (businessEntity business);
}
