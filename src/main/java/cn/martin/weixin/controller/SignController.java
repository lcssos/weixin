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

    @RequestMapping(value = "/checkSignature",method = RequestMethod.GET)
    public String checkSignature(@RequestParam(value = "timestamp",required = false) String timestamp,
                       @RequestParam(value = "nonce",required = false) String nonce,
                       @RequestParam(value = "echostr",required = false)String echostr){

        String token = "Martinlcs1";

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
}
