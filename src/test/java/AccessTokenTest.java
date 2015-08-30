import cn.martin.weixin.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by lcssos on 2015/8/30.
 */
@ContextConfiguration(locations = {
        "classpath:springmvc/*.xml",
        "classpath:spring/*.xml"
})
public class AccessTokenTest extends AbstractJUnit4SpringContextTests {

    @Value("#{configProperties['wx.AppID']}")
    private String appid;

    @Value("#{configProperties['wx.AppSecret']}")
    private String secret;


    @Test
    public void test() throws Exception {
        String result = HttpClientUtils.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret,null);

        System.out.println(result);

    }

}
