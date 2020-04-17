package com.jijian.business.service.Impl;

import com.github.pagehelper.PageHelper;
import com.jijian.assemble.entity.Business;
import com.jijian.business.common.AttestationRequest;
import com.jijian.business.entity.StoreEntity;
import com.jijian.business.entity.businessEntity;
import com.jijian.business.mapper.StoreMapper;
import com.jijian.business.mapper.businessMapper;
import com.jijian.business.service.businessService;
import com.jijian.file.entity.FileEntity;
import com.jijian.file.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 16:18
 * Content:
 */
@Service
public class businessServiceImpl implements businessService {
    @Autowired private businessMapper businessmapper;

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private FileMapper fileMapper;
    @Override
    public int addAttestation(businessEntity business) {
        return businessmapper.insertAttestation(business);
    }

    @Override
    public int addBusiness(businessEntity businessEntity) {
        return businessmapper.addBusiness(businessEntity);
    }

    @Override
    public List<businessEntity> findList(businessEntity businessEntity) {
        return businessmapper.findList(businessEntity);
    }

    @Override
    public businessEntity get(String id) {
        businessEntity businessEntity=businessmapper.get(id);

        //身份证正反面照片
        FileEntity file1=fileMapper.getFileByTypeAndBid(String.valueOf(businessEntity.getId()),"1");
        FileEntity file2=fileMapper.getFileByTypeAndBid(String.valueOf(businessEntity.getId()),"2");
        //营业执照
        FileEntity file3=fileMapper.getFileByTypeAndBid(String.valueOf(businessEntity.getId()),"3");

        List<StoreEntity> storeEntities=businessEntity.getStoreEntityList();
        if(storeEntities.size()>0&&file3!=null){
            storeEntities.get(0).setImg(file3.getFileNewName());
        }
        if(file1!=null){
            businessEntity.setImg(file1.getFileNewName());
        }
        if(file2!=null){
            businessEntity.setImg1(file2.getFileNewName());
        }
        return businessEntity;
    }

    @Override
    public Integer businessDeal(String id) {
        return businessmapper.businessDeal(id);
    }


    @Override
    @Transactional
    public void businessAttestation(AttestationRequest request) {
        businessEntity business=new businessEntity();
        business.setId(Integer.valueOf(request.getId()));
        business.setType(Integer.valueOf(request.getType()));
        business.setName(request.getName());
        business.setArea(request.getArea());
        businessmapper.businessAttestation(business);

        StoreEntity  storeEntity=new StoreEntity();
        storeEntity.setName(request.getStoreName());
        storeEntity.setBusinessId(Integer.valueOf(request.getId()));
        storeEntity.setDeleted(0);
        storeMapper.addStore(storeEntity);

    }
}
