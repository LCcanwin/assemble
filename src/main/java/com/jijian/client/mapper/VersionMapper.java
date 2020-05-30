package com.jijian.client.mapper;




import com.jijian.client.Dto.VersionDTO;
import com.jijian.client.entity.Version;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface VersionMapper {
   List<VersionDTO> findList();
   Integer add(Version version);
   Integer update(Version version);
   Integer delete(String id);
   //获取最近版本
   VersionDTO getLastVersion(Integer number);
}
