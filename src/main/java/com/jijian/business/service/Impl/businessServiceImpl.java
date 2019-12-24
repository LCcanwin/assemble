package com.jijian.business.service.Impl;

import com.jijian.assemble.entity.Business;
import com.jijian.business.entity.businessEntity;
import com.jijian.business.mapper.businessMapper;
import com.jijian.business.service.businessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: chenchuan
 * Date: 2019/12/19 16:18
 * Content:
 */
@Service
public class businessServiceImpl implements businessService {
    @Autowired private businessMapper businessmapper;
    @Override
    public int addAttestation(businessEntity business) {
        return businessmapper.insertAttestation(business);
    }
}
