package com.jijian.assemble.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Data;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/14 21:09
 */
@Data
@Table(name = "goods")
public class Goods extends BaseEntity {
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;

    @Column(name = "img",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String img;

    @Column(name = "type",type = MySqlTypeConstant.INT,length = 64)
    private int type;
    //会员价
    @Column(name = "discount",type = MySqlTypeConstant.DOUBLE,length = 64)
    private double discount;
    //拼单价
    @Column(name = "unit_price",type = MySqlTypeConstant.DOUBLE,length = 64)
    private double unitPrice;
    //单买价
    @Column(name = "price",type = MySqlTypeConstant.DECIMAL,length = 64)
    private double price;

    @Column(name = "busines_id",type = MySqlTypeConstant.INT,length = 11)
    private int businesId;

    @Column(name = "goods_number",type = MySqlTypeConstant.INT,length = 11)
    private int goodsNumber;
    //商品规格
    @Column(name = "specification",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String specification;
    //是否预售  0是 1否
    @Column(name = "readyFlag",type = MySqlTypeConstant.CHAR,length = 64)
    private String readyFlag;
    //承诺发货时间
    @Column(name = "deliveryDate",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String deliveryDate;
    //7天无理由退换 0是 1否
    @Column(name = "returnsFlag",type = MySqlTypeConstant.CHAR,length = 1)
    private String returnsFlag;
    //假一罚十   0是 1否
    @Column(name = "flag",type = MySqlTypeConstant.CHAR,length = 1)
    private String flag;

    //是否上架 0已上架 1未上架
    @Column(name = "flag",type = MySqlTypeConstant.CHAR,length = 1)
    private String upFlag;




}
