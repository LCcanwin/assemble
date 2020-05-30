package com.jijian.client.controller;


import com.jijian.client.Dto.CustomerDTO;
import com.jijian.client.entity.CustomerEntity;
import com.jijian.client.service.CustomerService;
import com.jijian.common.Constant;
import com.jijian.common.ResultJson;
import com.jijian.utils.DateTimeUtil;
import com.jijian.utils.ExpireBean;
import com.jijian.utils.RedisUtils;
import com.jijian.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Api(description = "前台用户相关接口")
@Controller("customer")
@RequestMapping("/client/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RedisUtils redisUtils;



//    public ResultJson<CustomerDTO> login(){
//
//    }

//    @ApiOperation(value = "新增用户", notes="新增用户")
//    @ApiImplicitParam(name = "customerEntity", value = "用户实体", paramType = "body", required = true, dataType = "CustomerEntity")
//    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultJson<Boolean> addCustomer(@RequestBody CustomerEntity customerEntity){
//
//        CustomerDTO customerDTO=customerService.getByPhone(customerEntity.getPhone());
//        if(customerDTO!=null){
//            return ResultJson.getReturnJson(500,"该用户已经注册,请直接登录！", false);
//        }
//
//        if(customerService.addCustomer(customerEntity)>0){
//            return ResultJson.getReturnJson(200,"新增用户成功！", true);
//        }else{
//            return ResultJson.getReturnJson(500,"新增用户失败！", true);
//        }
//    }

    @ApiOperation(value = "换绑手机", notes = "换绑手机")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "新电话号码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/updatePhone", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> updatePhone(String id, String phone) {
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setId(Integer.valueOf(id));
        customerEntity.setPhone(phone);
        if (customerService.update(customerEntity) > 0) {
            return ResultJson.getReturnJson(200, "修改成功！", true);
        } else {
            return ResultJson.getReturnJson(500, "修改失败！", true);
        }
    }

    @ApiOperation(value = "密码登录", notes = "密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "电话", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/loginByPassword", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<CustomerDTO> loginByPassword(String phone, String password) {

//        if(redisUtils.hasKey(Constant.LOGIN_READY)){
//            List<String> loginPhones=new ArrayList<>();
//            redisUtils.set(Constant.LOGIN_READY,loginPhones);
//        }



        CustomerDTO validate = customerService.getByPhone(phone);
        if (validate == null) {
            return ResultJson.getReturnJson(500, "登录失败,该账户没有注册,请使用短信登录！", null);
        }
        if ("1".equals(validate.getPasswordFlag())) {
            return ResultJson.getReturnJson(500, "登录失败,该账户设置登录密码,请使用短信登录！", null);
        }

        CustomerDTO customerDTO = customerService.loginByPassword(phone, password);
        if (customerDTO != null) {

//
//
//            List<String> ready=(List<String>)redisUtils.get(Constant.LOGIN_READY);
//            if(ready.contains(customerDTO.getPhone())){
//                return ResultJson.getReturnJson(500, "登录失败,改用户已经登录!", null);
//            }else{
//                redisUtils.addToListRight(Constant.LOGIN_READY, expireEnum,customerDTO.getPhone());
//            }

            return ResultJson.getReturnJson(200, "登录成功！", customerDTO);
        } else {
            return ResultJson.getReturnJson(500, "登录失败,用户名或密码错误！", null);
        }
    }

    @ApiOperation(value = "验证码登录", notes = "验证码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "电话", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "code", value = "验证码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/loginByCode", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<CustomerDTO> loginByCode(String phone, String code) {
        String redisCode = String.valueOf(redisUtils.get(code));
        String phoneCode = String.valueOf(redisUtils.get(phone));
        if (redisCode != null && phoneCode != null) {
            if (phone.equals(phoneCode)&&code.equals(redisCode)) {
                CustomerDTO customer = customerService.getByPhone(phone);
                if (customer != null) {
                    return ResultJson.getReturnJson(200, "登录成功！", customer);
                } else {
                    //第一次登录 自动注册
                    CustomerEntity register = new CustomerEntity();
                    register.setNickName("趣拼装" + StringUtil.uuid().substring(0, 10));
                    register.setImg(Constant.IMAGE_DefAULT);
                    register.setPhone(phone);
                    register.setPasswordFlag("1");
                    register.setBirthday(new Date());
                    register.setFansNum(0);
                    register.setFocusNum(0);
                    register.setRedNum(0);
                    customerService.addCustomer(register);

                    CustomerDTO result = customerService.getByPhone(phone);

                    return ResultJson.getReturnJson(200, "第一次登录 自动注册", result);
                }
            } else {
                return ResultJson.getReturnJson(500, "登陆失败！手机、验证码不匹配", null);
            }
        } else {
            return ResultJson.getReturnJson(500, "验证失败！手机号或者验证码不正确", null);
        }

    }



    @ApiOperation(value = "更换头像", notes = "更换头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "file", value = "头像", paramType = "query", required = true, dataType = "file")
    })
    @RequestMapping(value = "/updateHead", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> updateHead(String id, MultipartFile file) {
        if(file==null){
            return ResultJson.getReturnJson(200, "上传失败，文件为空！", false);
        }

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
        try {
            file.transferTo(savefile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setId(Integer.valueOf(id));
        customerEntity.setImg(uploadpath+fileNewName);
        if (customerService.update(customerEntity) > 0) {
            return ResultJson.getReturnJson(200, "修改成功！", true);
        } else {
            return ResultJson.getReturnJson(500, "修改失败！", true);
        }
    }


    @ApiOperation(value = "设置密码", notes = "设置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "新密码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/setPassword", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> setPassword(String id, String password) {
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setId(Integer.valueOf(id));
        customerEntity.setPassword(password);
        customerEntity.setPasswordFlag("0");
        if (customerService.update(customerEntity) > 0) {
            return ResultJson.getReturnJson(200, "修改成功！", true);
        } else {
            return ResultJson.getReturnJson(500, "修改失败！", true);
        }
    }


    @ApiOperation(value = "设置生日、昵称", notes = "设置生日、昵称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "nickName", value = "昵称", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "birthday", value = "生日(yyyy-MM-dd)", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/updateNickNameAndBirthday", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> updateNickNameAndBirthday(String id, String nickName,String birthday) {

        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setId(Integer.valueOf(id));
        customerEntity.setNickName(nickName);
        customerEntity.setBirthday(DateTimeUtil.strToDate("yyyy-MM-dd",birthday));
        if (customerService.update(customerEntity) > 0) {
            return ResultJson.getReturnJson(200, "修改成功！", true);
        } else {
            return ResultJson.getReturnJson(500, "修改失败！", true);
        }
    }


    @ApiOperation(value = "获取用户详情", notes = "获取用户详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<CustomerDTO> get(String id) {
        CustomerDTO customerDTO=customerService.get(id);
        return ResultJson.getReturnJson(200, "查询成功！", customerDTO);
    }


    @ApiOperation(value = "修改密码", notes = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "oldPassword", value = "原始密码", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> updatePassword(String id,String oldPassword,String newPassword) {

        CustomerDTO entity=customerService.get(id);

        if(entity!=null && !entity.getPassword().equals(oldPassword)){
            return ResultJson.getReturnJson(500, "原密码不正确，请重新输入！", false);
        }
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setId(Integer.valueOf(id));
        customerEntity.setPassword(newPassword);
        if (customerService.update(customerEntity) > 0) {
            return ResultJson.getReturnJson(200, "修改成功！", true);
        } else {
            return ResultJson.getReturnJson(500, "修改失败！", false);
        }
    }


    @ApiOperation(value = "忘记密码", notes = "忘记密码")
    @ApiImplicitParams({

            @ApiImplicitParam(name = "phone", value = "电话号码", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "新密码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.PUT)
    @ResponseBody
    public ResultJson<Boolean> forgetPassword(String phone,String password) {

        CustomerDTO entity=customerService.getByPhone(phone);
        if(entity==null ){
            return ResultJson.getReturnJson(500, "该用户未注册，请先注册！", false);
        }
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setId(Integer.valueOf(entity.getId()));
        customerEntity.setPassword(password);
        if (customerService.update(customerEntity) > 0) {
            return ResultJson.getReturnJson(200, "新密码设置成功！", true);
        } else {
            return ResultJson.getReturnJson(500, "密码设置失败！", false);
        }
    }
}
