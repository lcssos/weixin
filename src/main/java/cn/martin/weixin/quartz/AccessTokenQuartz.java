package cn.martin.weixin.quartz;

import cn.martin.weixin.entity.AccessToken;
import cn.martin.weixin.util.HttpClientUtils;
import cn.martin.weixin.util.SpringContextUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * Created by 昌胜 on 2015-02-10.
 */


@Component
public class AccessTokenQuartz {

    private Logger logger = LoggerFactory.getLogger(AccessTokenQuartz.class);


    @Value("#{configProperties['wx.AppID']}")
    private String appid;

    @Value("#{configProperties['wx.AppSecret']}")
    private String secret;

    @Scheduled(cron = "0 0 0 * * *")
    public void timer(){
        try {
            getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @PostConstruct
    public void construct(){
        try {
            getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void getAccessToken() throws Exception {
        String result = HttpClientUtils.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret, null);

        AccessToken accessToken = JSON.parseObject(result, AccessToken.class);

        logger.info("access_token:"+result);
        logger.info(JSON.toJSONString(accessToken));

        //2015-08-30 20:39:46 [ INFO  ] [ cn.martin.weixin.quartz.AccessTokenQuartz:55 ] {"access_token":"lIXkFIb6hl5VgYnXGBLA3y1V0mjbI2s5y_GAwbYmdm6BIpsSxDITKJq_pw8V_CSFEbo5dklIvjdWVnjCqb4sSgYLPXmX3ZjFUia6mExNgRc","expires_in":7200}


        //进行保存处理


    }


}
