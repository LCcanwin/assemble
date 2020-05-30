package com.jijian.client.service.impl;

import com.jijian.client.Dto.CustomerDTO;
import com.jijian.client.Dto.StyleDto;
import com.jijian.client.Dto.TypeDto;
import com.jijian.client.entity.CustomerEntity;
import com.jijian.client.mapper.CustomerMapper;
import com.jijian.client.mapper.TypeMapper;
import com.jijian.client.service.CustomerService;
import com.jijian.client.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;


    @Override
    public List<TypeDto> findList() {
        List<TypeDto> typeDtoList=typeMapper.findList();
        List<StyleDto> styleDtoList=typeMapper.findStyleList();
        for(TypeDto type:typeDtoList){
            for(TypeDto subType:type.getSubTypeList()){
                //有装修风格
                if("0".equals(subType.getStyleFlag())){
                    subType.setStyleList(styleDtoList);
                }
            }
        }
        return typeDtoList;
    }

    @Override
    public List<TypeDto> findListByPid(String parentId) {
        return typeMapper.findListByPid(parentId);
    }
}
