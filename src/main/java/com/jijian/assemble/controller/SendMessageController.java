package com.jijian.assemble.controller;

import com.jijian.assemble.utils.HttpClientUtil;
import com.jijian.assemble.utils.SendMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description 发送短信验证码
 * @Author chenchuan
 * @Date 2019/10/20
 */
@RestController
@RequestMapping("/SendMessage/api")
public class SendMessageController {
    @RequestMapping(value = "/sendmessage" ,method = RequestMethod.GET)
    @ResponseBody
    public String sendmessage (String smsMob){
        HttpClientUtil client = HttpClientUtil.getInstance();
        //短信内容
         String smsText = "验证码："+ (int)((Math.random()*9+1)*100000);
        //UTF发送
        int result = client.sendMsgUtf8(SendMessage.Uid, SendMessage.Key,smsText ,smsMob);
        return  "发送成功";
    }
}
