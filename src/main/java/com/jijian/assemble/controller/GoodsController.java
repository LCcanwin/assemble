package com.jijian.assemble.controller;


import com.jijian.assemble.dto.GoodsDTO;
import com.jijian.assemble.dto.UserInfoDTO;
import com.jijian.assemble.entity.Goods;
import com.jijian.assemble.entity.User;
import com.jijian.assemble.service.GoodsService;
import com.jijian.common.Constant;
import com.jijian.common.ResultJson;
import com.jijian.file.entity.FileEntity;
import com.jijian.file.service.FileService;
import com.jijian.utils.FileUtils;
import com.jijian.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/goods/api")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private FileService fileService;





    /**
     * 商品图片文件上传
      * @param file
     * @param fileType 图片类型
     * @param bId  商家id
     * @param goodsId 商品id
     * @param  flag 是否为主图片
     * @param request
     * @return
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    public ResultJson fileUpload(MultipartFile file , String fileType , String bId, String goodsId,String flag,HttpServletRequest request){

        bId=bId.substring(0,bId.indexOf("\r"));
        fileType=fileType.substring(0,fileType.indexOf("\r"));
        goodsId=goodsId.substring(0,goodsId.indexOf("\r"));
        flag=flag.substring(0,flag.indexOf("\r"));


        // 获取上传文件名
        String uploadPathName = file.getOriginalFilename();
        // 获取上传文件的后缀
        String fileSuffix = uploadPathName.substring(uploadPathName.lastIndexOf(".") + 1, uploadPathName.length());
        // 上传目录地址
//         String uploadpath="D:/manage/image/";//windows路径
        String uploadpath= Constant.IMAGE_PATH;//windows路径
//        String uploadpath="/data/image";
        // 上传文件名
        String fileNewName = new Date().getTime() + new Random().nextInt(100) + "." + fileSuffix;
        File savefile = new File(uploadpath+fileNewName);
        if (!savefile.getParentFile().exists()) {
            savefile.getParentFile().mkdirs();
        }
        FileEntity fileEntity = new FileEntity();

        try {
            file.transferTo(savefile);
            fileEntity.setFileName(uploadPathName);
            fileEntity.setFileNewName(fileNewName);
            fileEntity.setDeleted(0);
            fileEntity.setFileType(fileType);
            fileEntity.setBId(bId);
            fileEntity.setGoodsId(goodsId);
            fileEntity.setFlag(flag);
//            fileEntity.setFileUrl("/image/url/"+fileNewName);
            fileEntity.setFileUrl(uploadpath+fileNewName);
            if(fileService.insert(fileEntity)>0){
                return ResultJson.getReturnJson(200,"上传成功!",fileEntity);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultJson.getReturnJson("上传失败!");
    }



    /**
     * 获取所有商品信息
     * @return
     */
    @RequestMapping(value = "/goodsList" ,method = RequestMethod.GET)
    public List<Goods> getGoodsList() {
        List<Goods> listU = goodsService.findAllList();
        return listU;
    }

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public Goods getGoods(@PathVariable("id") String id) {
        Goods goods = goodsService.getById(id);
        return goods;
    }



    /**
     * 获取商家自己的商品
     * @param businessId
     * @return
     */
    @RequestMapping(value = "/findByBusiness/{businessId}" ,method = RequestMethod.GET)
    public Map<String,List<Goods>> findByBusiness(@PathVariable("businessId") String businessId) {
        Map<String,List<Goods>> result = goodsService.findByBusiness(businessId);
        return result;
    }

    /**
     * 新增商品
     * @param goods
     * @return
     */
    @RequestMapping(value = "/addGoods" ,method = RequestMethod.POST)
    public ResultJson addGoods(@RequestBody Goods goods) {

            Integer i = goodsService.addGoods(goods);
            if(i>0){
                return ResultJson.getReturnJson("新增成功！", true);
            }else{
                return ResultJson.getReturnJson("新增失败！", false);
            }

    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.DELETE)
    public ResultJson<GoodsDTO> delete(@PathVariable("id")String id) {
        Integer i = goodsService.delete(id);
        if(i>0){
            return ResultJson.getReturnJson("删除成功！", null);
        }else{
            return ResultJson.getReturnJson("删除失败！", null);
        }
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @RequestMapping(value = "/updateGoods/{id}" ,method = RequestMethod.PUT)
    public ResultJson<GoodsDTO> updateGoods(@RequestBody Goods goods) {
        Integer i = goodsService.update(goods);
        if(i>0){
            return ResultJson.getReturnJson("修改成功！", null);
        }else{
            return ResultJson.getReturnJson("修改失败！", null);
        }
    }

    /**
     * 商品上下架
     * @param id
     * @param upFlag
     * @return
     */
    @RequestMapping(value = "/upGoods" ,method = RequestMethod.PUT)
    public ResultJson<GoodsDTO> upGoods(String id,String upFlag) {
        Integer i = goodsService.upGoods(id,upFlag);
        if(i>0){
            return ResultJson.getReturnJson("操作成功！", null);
        }else{
            return ResultJson.getReturnJson("操作失败！", null);
        }
    }
}
