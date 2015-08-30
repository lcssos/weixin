import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lcssos on 2015/8/30.
 */

@ContextConfiguration(locations = {
        "classpath:springmvc/*.xml"
})
public class SortTest extends AbstractJUnit4SpringContextTests {


    @Value("#{configProperties['wx.token']}")
    private String token;

    @Test
    public void test(){
        List<String> list = new ArrayList<String>();
        list.add(token);
        list.add("456");
        list.add("abc");

        Collections.sort(list);

        String s = StringUtils.collectionToDelimitedString(list, "");




        System.out.println(s);

//        System.out.println(DigestUtils.shaHex(s));
        System.out.println(DigestUtils.sha1Hex(s));

    }

}
