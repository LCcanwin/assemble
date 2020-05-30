package com.jijian.client.mapper;

import com.jijian.client.Dto.CustomerDTO;
import com.jijian.client.Dto.StyleDto;
import com.jijian.client.Dto.TypeDto;
import com.jijian.client.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TypeMapper {
   List<TypeDto> findList();
   List<StyleDto> findStyleList();

   List<TypeDto> findListByPid(@Param("parentId") String parentId);
}
