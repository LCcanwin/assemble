package com.jijian.file.mapper;

//import com.jijian.base.BaseMapper;
import com.jijian.file.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
