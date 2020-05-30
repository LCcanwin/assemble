package com.jijian.client.service;

import com.jijian.client.Dto.CustomerDTO;
import com.jijian.client.Dto.TypeDto;
import com.jijian.client.entity.CustomerEntity;

import java.util.List;

public interface TypeService {
   List<TypeDto> findList();

   List<TypeDto> findListByPid(String parentId);
}
