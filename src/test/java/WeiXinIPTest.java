import cn.martin.weixin.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by lcssos on 2015/8/30.
 */
@ContextConfiguration(locations = {
        "classpath:springmvc/*.xml",
        "classpath:spring/*.xml"
})
public class WeiXinIPTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void test() throws Exception {
        String result = HttpClientUtils.get("https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=lIXkFIb6hl5VgYnXGBLA3y1V0mjbI2s5y_GAwbYmdm6BIpsSxDITKJq_pw8V_CSFEbo5dklIvjdWVnjCqb4sSgYLPXmX3ZjFUia6mExNgRc",null);

        System.out.print(result);
    }

}
