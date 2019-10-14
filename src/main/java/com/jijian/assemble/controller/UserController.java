package com.jijian.assemble.controller;

import com.jijian.assemble.doc.UserControllerDoc;
import com.jijian.assemble.entity.User;
import com.jijian.assemble.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController implements UserControllerDoc {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/searchlist" ,method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserlist() {
        logger.info("查询用户信息");
        List<User> listU = userService.searchUser1();
//        listU.forEach(users -> System.out.println(users));
        listU.forEach(System.out::println);
        return listU;
    }

}
