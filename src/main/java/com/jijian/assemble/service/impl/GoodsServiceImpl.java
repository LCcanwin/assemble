package com.jijian.assemble.service.impl;

import com.jijian.assemble.dto.GoodsDTO;
import com.jijian.assemble.entity.Goods;
import com.jijian.assemble.mapper.GoodsMapper;
import com.jijian.assemble.mapper.UserMapper;
import com.jijian.assemble.service.GoodsService;
import com.jijian.file.entity.FileEntity;
import com.jijian.file.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Resource
    private GoodsMapper goodsMapper;

    @Autowired
    private FileMapper fileMapper;

    @Override
    public Integer upGoods(String id, String upFlag) {
        return goodsMapper.upGoods(id,upFlag);
    }

    @Override
    public Integer addGoods(Goods goods) {

        return goodsMapper.addGoods(goods);
    }

    @Override
    public Integer update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public Integer delete(String id) {
        return goodsMapper.delete(id);
    }

    @Override
    public List<Goods> findList(Goods goods) {
        return goodsMapper.findList(goods);
    }

    @Override
    public List<Goods> findAllList() {
        return goodsMapper.findAllList();
    }

    @Override
    public List<GoodsDTO> findGoodsBySalesFlag(String salesFlag) {
        List<GoodsDTO> goodsDTOS= goodsMapper.findGoodsBySalesFlag(salesFlag);

        for(GoodsDTO goods:goodsDTOS){
            //设置商品主图片路径
            List<FileEntity> fileEntityList=fileMapper.getFileByGoodsIdAndBusinessIdAndFlag(String.valueOf(goods.getBusinesId()),goods.getId(),"0");
            if(fileEntityList.size()>0){
                goods.setImg(fileEntityList.get(0).getFileUrl());
            }
        }
        return goodsDTOS;
    }

    @Override
    public Goods getById(String id) {
        Goods goods=goodsMapper.getById(id);
        if(goods!=null){
            //商品图片
            List<FileEntity> fileEntityList=fileMapper.getFileByGoodsIdAndBusinessId(String.valueOf(goods.getBusinesId()),id);
            goods.setFileEntityList(fileEntityList);
        }


        return goods;
    }

    @Override
    public Map<String,List<Goods>> findByBusiness(String businessId) {

        Map<String,List<Goods>> result=new HashMap<>();
        List<Goods> allList= goodsMapper.findByBusiness(businessId);
        //出售中
        List<Goods> upList=new ArrayList<>();
        //已下架
        List<Goods> downList=new ArrayList<>();
        //已售完
        List<Goods> outList=new ArrayList<>();

        for(Goods goods:allList){
            //设置主图片路径
            List<FileEntity> fileEntityList=fileMapper.getFileByGoodsIdAndBusinessIdAndFlag(String.valueOf(goods.getBusinesId()),goods.getGoodsId(),"0");
            if(fileEntityList.size()>0){
                goods.setImg(fileEntityList.get(0).getFileUrl());
            }
            if(goods.getGoodsNumber()!=0&&goods.getUpFlag().equals("0")){
                upList.add(goods);
            }else if(goods.getGoodsNumber()!=0&&goods.getUpFlag().equals("1")){
                downList.add(goods);
            }else if(goods.getGoodsNumber()==0){
                outList.add(goods);
            }


        }
        result.put("upList",upList);
        result.put("downList",downList);
        result.put("outList",outList);


        return result;
    }
}
