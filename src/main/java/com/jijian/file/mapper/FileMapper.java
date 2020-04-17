package com.jijian.file.mapper;

//import com.jijian.base.BaseMapper;
import com.jijian.file.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:18
 * Content:
 */
@Mapper
public interface FileMapper  {
    int insert(FileEntity fileEntity);

    int updatefile (FileEntity fileEntity);

    /**
     * 通过文件类型和商家ID获取文件
     * @param bid 商家ID
     * @param type 文件类型 1.身份证正面  2.身份证反面 ， 3. 营业执照  4.商品图片
     * @return
     */
    FileEntity getFileByTypeAndBid(@Param("bid")String bid, @Param("type")String type);

    List<FileEntity>  getFileByGoodsIdAndBusinessId(@Param("bid")String bid, @Param("goodsId")String goodsId);

    /**
     * 通过文件类型和商家ID获取商品主副图片
     * @param bid
     * @param goodsId
     * @param flag 0 主图片  1副图片
     * @return
     */
    List<FileEntity>  getFileByGoodsIdAndBusinessIdAndFlag(@Param("bid")String bid, @Param("goodsId")String goodsId, @Param("flag")String flag);
}
