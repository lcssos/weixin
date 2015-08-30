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
        String result = HttpClientUtils.get("https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=URzgpxdTLUFBUIcfiaY5os6ZJPpcT3xpDjeNscC96QSgEYlEBBKZPKwkv2i6lY3GACfV8G2Wm8ogzXGzf8mKjq00LW2uDadj_3CZX7ksP3Q",null);

        System.out.print(result);
    }

}
