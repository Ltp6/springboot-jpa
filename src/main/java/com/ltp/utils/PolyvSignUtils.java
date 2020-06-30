package com.ltp.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ltp
 * @description
 * @date 2020/6/30 16:38
 */
public class PolyvSignUtils {

    @Value("${polyv.appSecret}")
    private String appSecret;

    public String generateSign(Map<String,String> paramMap) {
        //对参数名进行字典排序
        List<String> list = new ArrayList<>(paramMap.keySet());
        Collections.sort(list);

        //拼接有序的参数串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(appSecret);
        for (String key : list) {
            stringBuilder.append(key).append(paramMap.get(key));
        }

        stringBuilder.append(appSecret);
        String signSource = stringBuilder.toString();
        return DigestUtils.md5Hex(signSource).toUpperCase();
    }
}
