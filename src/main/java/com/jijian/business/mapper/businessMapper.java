package com.jijian.business.mapper;

import com.jijian.assemble.entity.Business;
import com.jijian.business.entity.businessEntity;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 16:05
 * Content:
 */
public interface businessMapper {
    /**
     *添加商家认证信息
     * **/
    int  insertAttestation (businessEntity business);

    /**
     * 商家认证
     * @param business
     * @return
     */
    int businessAttestation(businessEntity business);

    /**
     * 商家新增
     * @param businessEntity
     * @return
     */
    int addBusiness(businessEntity businessEntity);

    /**
     * 查询商家列表
     * @param businessEntity
     * @return
     */
    List<businessEntity> findList(businessEntity businessEntity);

    /**
     * 获取商家详情
     * @param id
     * @return
     */
    businessEntity get(String id);

    /**
     * 商家审核
     * @param id
     * @return
     */
    Integer businessDeal(String id);

    /**
     * 按类型统计商家数量
     * @param type
     * @return
     */
    Integer businessCount(@Param("type") String  type);

    Integer updatePassword(@Param("phone") String  phone,@Param("password") String  password);
}
