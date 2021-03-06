package com.jijian.assemble.service.impl;

import com.jijian.assemble.dto.UserInfoDTO;
import com.jijian.assemble.mapper.UserMapper;
import com.jijian.assemble.service.LoginService;
import com.jijian.assemble.utils.MD5Util;
import com.jijian.assemble.utils.TokenUtil;
import com.jijian.business.entity.businessEntity;
import com.jijian.business.mapper.businessMapper;
import com.jijian.business.service.businessService;
import com.jijian.utils.HttpClientUtil;
import com.jijian.utils.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/21 22:37
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private com.jijian.business.mapper.businessMapper businessMapper;

    @Override
    public Integer getVerifyCode(String phone, Integer code) {
        HttpClientUtil client = HttpClientUtil.getInstance();
        //短信内容
        String smsText = "验证码：" + code;
        //UTF发送
        return client.sendMsgUtf8(SendMessage.Uid, SendMessage.Key, smsText, phone);
    }

    /**
     * 注册功能
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    @Transactional
    public UserInfoDTO register(String phone, String password,String type,String area) {
        String md5Password = MD5Util.getMD5(password);
        int count = userMapper.register(phone, md5Password);

        //生成token
        String token = TokenUtil.makeToken();
        userMapper.makeToken(token, phone);
        UserInfoDTO userInfoDTO = userMapper.getUserInfo(phone);


        //注册用户的时同时注册商家信息
        businessEntity businessEntity=new businessEntity();
        businessEntity.setId(userInfoDTO.getUserId());
        businessEntity.setNumber(phone);
        businessEntity.setPassword(password);
        //未认证
        businessEntity.setAttestationFlag(1);
        //未审核
        businessEntity.setStatus(1);
//        businessEntity.setType(Integer.valueOf(type));
        businessEntity.setArea(area);
        businessEntity.setDeleted(0);
        businessMapper.addBusiness(businessEntity);



        return userInfoDTO;
    }

    @Override
    public UserInfoDTO loginByCode(String phone) {
        return userMapper.getUserInfo(phone);
    }

    @Override
    public UserInfoDTO loginByPassword(String phone, String password) {
        String md5Password = MD5Util.getMD5(password);
        String resultPassword = userMapper.getPassword(phone);
        if (resultPassword!=null&&resultPassword.equals(md5Password)) {
            return userMapper.getUserInfo(phone);
        } else {
            return null;
        }
    }

    @Override
    public Boolean isRegister(String phone) {
        Integer count = userMapper.userCount(phone);
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    @Transactional
    public Integer updatePassword(String phone, String password) {
        String md5Password = MD5Util.getMD5(password);
        //修改business密码
        businessMapper.updatePassword(phone,password);
        //修改user密码
        return userMapper.updatePassword(phone,md5Password);
    }
}
