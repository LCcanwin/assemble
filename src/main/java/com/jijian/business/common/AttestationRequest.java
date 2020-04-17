package com.jijian.business.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 商家认证请求实体
 */

@Getter
@Setter
public class AttestationRequest {
    private String bId;
    private String id;
    private String name; //商家名称
    private String type; //商家类型 0个人 1个体商家
    private String area;
    private String storeName; //店铺名称

}
