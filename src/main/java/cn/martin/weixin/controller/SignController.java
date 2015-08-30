package cn.martin.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lcssos on 2015/8/27.
 */
@RestController
public class SignController {

    Logger logger = LoggerFactory.getLogger(SignController.class);

    @Value("#{configProperties['wx.token']}")
    private String token;

    /**
     * 服务器有效性认证
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/checkSignature",method = RequestMethod.GET)
    public String checkSignature(@RequestParam(value = "timestamp",required = false) String timestamp,
                       @RequestParam(value = "nonce",required = false) String nonce,
                       @RequestParam(value = "echostr",required = false)String echostr){

        List<String> list = new ArrayList<String>();
        list.add("Martinlcs1");
        list.add(timestamp);
        list.add(nonce);

        Collections.sort(list);

        String s = StringUtils.collectionToDelimitedString(list,"");

        logger.info(timestamp);
        logger.info(nonce);
        logger.info(token);
        logger.info(echostr);


        //AppID(应用ID)
        //wx1e9c2e64cc5dbec0
        //AppSecret(应用密钥)
        //400e3f86359c49c7a5a3161362cdcf3f

        return echostr;
    }


    /**
     * 接收普通消息、接收事件推送
     * 返回内容为被动回复消息
      * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/checkSignature",method = RequestMethod.POST)
    public String receiveMs(@RequestParam(value = "timestamp",required = false) String timestamp,
                            @RequestParam(value = "nonce",required = false) String nonce,
                            @RequestParam(value = "echostr",required = false)String echostr){


        return "";
    }
}
