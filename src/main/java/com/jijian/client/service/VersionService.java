package com.jijian.client.service;

import com.jijian.client.Dto.TypeDto;
import com.jijian.client.Dto.VersionDTO;
import com.jijian.client.entity.Version;

import java.util.List;

public interface VersionService {
   VersionDTO getLastVersion(Integer number);

   List<VersionDTO> findList();
   Integer add(Version version);
   Integer update(Version version);
   Integer delete(String id);
}
