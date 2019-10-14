package com.jijian.assemble.doc;

import com.jijian.assemble.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/14 21:52
 */
@Api(tags = "用户测试")
public interface UserControllerDoc {
    @ApiOperation("获取用户列表")
    public List<User> getUserlist();
}
