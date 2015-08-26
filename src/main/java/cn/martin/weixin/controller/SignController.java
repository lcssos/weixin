package cn.martin.weixin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lcssos on 2015/8/27.
 */
@RestController
public class SignController {

    Logger logger = LoggerFactory.getLogger(SignController.class);

    @RequestMapping(value = "/sign",method = RequestMethod.GET)
    public String sign(@RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("token")String token,
                       @RequestParam("echostr")String echostr){

        logger.info(timestamp);
        logger.info(nonce);
        logger.info(token);
        logger.info(echostr);


        return echostr;
    }
}
