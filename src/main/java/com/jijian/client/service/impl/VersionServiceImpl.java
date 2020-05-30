package com.jijian.client.service.impl;

import com.jijian.client.Dto.StyleDto;
import com.jijian.client.Dto.TypeDto;
import com.jijian.client.Dto.VersionDTO;
import com.jijian.client.entity.Version;
import com.jijian.client.mapper.TypeMapper;
import com.jijian.client.mapper.VersionMapper;
import com.jijian.client.service.TypeService;
import com.jijian.client.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VersionServiceImpl implements VersionService {

    @Autowired
    private VersionMapper versionMapper;


    @Override
    public VersionDTO getLastVersion(Integer number) {
        return versionMapper.getLastVersion(number);
    }

    @Override
    public List<VersionDTO> findList() {
        return versionMapper.findList();
    }

    @Override
    public Integer add(Version version) {
        return versionMapper.add(version);
    }

    @Override
    public Integer update(Version version) {
        return versionMapper.update(version);
    }

    @Override
    public Integer delete(String id) {
        return versionMapper.delete(id);
    }
}
