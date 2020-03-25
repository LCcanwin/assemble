package com.jijian.back.service;

import com.jijian.business.mapper.businessMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;

public interface StatService {

  Integer businessCount(String type);
}
