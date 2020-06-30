package com.ltp;

import com.ltp.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootJpaApplicationTests {

    @Resource
    private UserService userService;

    /**
     * sign生成规则
     */
    @Test
    void contextLoads() {
        String appId = "foucrmoiej";
        String userId = "32585cb2a6";
        String appSecret = "7335ec173f144463bd199f23a463deb0";

        long ts = System.currentTimeMillis();
// 创建参数表 （创建接口需要传递的所有参数表）
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("appId", appId);
        paramMap.put("timestamp", Long.toString(ts));

//对参数名进行字典排序
        String[] keyArray = paramMap.keySet().toArray(new String[0]);
        Arrays.sort(keyArray);

//拼接有序的参数串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(appSecret);
        for (String key : keyArray) {
            stringBuilder.append(key).append(paramMap.get(key));
        }

        stringBuilder.append(appSecret);
        String signSource = stringBuilder.toString();

//        String sign = org.apache.commons.codec.digest.DigestUtils.md5Hex(signSource).toUpperCase();
        String sign = DigestUtils.md5Hex(signSource).toUpperCase();
        System.out.println("ts = " + ts);
        System.out.println("sign = " + sign);
        System.out.println("http://api.polyv.net/live/v1/users/" + userId + "/channels?appId=" + appId + "&timestamp=" + ts + "&sign=" + sign);
    }

    @Test
    void queryAll() {
        userService.queryAll();
    }

    @Test
    void getUserInfo() {
        System.out.println(userService.getUserInfo());
    }

    @Test
    void updateCategoryName() {
        userService.updateCategoryName(327846, "测试分类");
    }
    @Test
    void getCategory() {
        System.out.println(userService.getCategory());
    }
}
