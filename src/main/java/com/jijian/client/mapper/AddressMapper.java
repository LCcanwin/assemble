package com.jijian.client.mapper;



import com.jijian.client.Dto.AddressDTO;

import com.jijian.client.Dto.Province;
import com.jijian.client.Dto.RegionDTO;
import com.jijian.client.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface AddressMapper {
   List<AddressDTO> getListByCustomerId(String customerId);
   Integer add(Address address);
   Integer update(Address address);
   Integer delete(String id);
   //设置默认
   void setDefault(String id);
   //取消默认
   void canalDefault(String id);
   //取消全部默认
   void canalDefaultByCustomerId(@Param("customerId")String customerId);
   Integer findCountByCustomerId(String customerId);

   List<RegionDTO> findRegionByPid(@Param("pId") String pId);

   List<Province> findAllRegion();
}
