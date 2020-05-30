package com.jijian.client.service;

import com.jijian.client.Dto.AddressDTO;

import com.jijian.client.Dto.CustomerDTO;
import com.jijian.client.Dto.Province;
import com.jijian.client.Dto.RegionDTO;
import com.jijian.client.entity.Address;
import com.jijian.client.entity.CustomerEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getListByCustomerId(String customerId);
    Integer add(Address address);
    Integer update(Address address);
    Integer delete(String id);
    void setDefault(@Param("id") String id, @Param("customerId")String customerId);
    Integer findCountByCustomerId(String customerId);

    void canalDefault(String id);

    List<RegionDTO> findRegionByPid(String pId);
    List<Province> findAllRegion();




}
