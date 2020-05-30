package com.jijian.client.service.impl;

import com.jijian.client.Dto.AddressDTO;



import com.jijian.client.Dto.Province;
import com.jijian.client.Dto.RegionDTO;
import com.jijian.client.entity.Address;

import com.jijian.client.mapper.AddressMapper;
import com.jijian.client.service.AddressService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressDTO> getListByCustomerId(String customerId) {
        return addressMapper.getListByCustomerId(customerId);
    }

    @Override
    public Integer add(Address address) {
        if(address.getFlag()!=null&&address.getFlag().equals("0")){
            //如果新增的为默认地址，其他地址设置为非默认
            addressMapper.canalDefaultByCustomerId(String.valueOf(address.getCustomerId()));
        }
        return addressMapper.add(address);
    }

    @Override
    public Integer update(Address address) {
        return addressMapper.update(address);
    }

    @Override
    public Integer delete(String id) {
        return addressMapper.delete(id);
    }

    @Override
    @Transactional
    public void setDefault(String id, String customerId) {
        addressMapper.canalDefaultByCustomerId(customerId);
        addressMapper.setDefault(id);
    }

    @Override
    public Integer findCountByCustomerId(String customerId) {
        return addressMapper.findCountByCustomerId(customerId);
    }

    @Override
    public void canalDefault(String id) {
        addressMapper.canalDefault(id);
    }

    @Override
    public List<RegionDTO> findRegionByPid(String pId) {
        return addressMapper.findRegionByPid(pId);
    }

    @Override
    public List<Province> findAllRegion() {

//        List<Area> areaList=new ArrayList<>();
//        //省
//        List<RegionDTO> provinces=addressMapper.findRegionByPid("");
//        for(RegionDTO province:provinces){
//            Area area=new Area();
//            area.setProvince(province);
//            //市
//            List<RegionDTO> cities=addressMapper.findRegionByPid(province.getId());
//            area.setCities(cities);
//            areaList.add(area);
//        }

        return addressMapper.findAllRegion();
    }
}
