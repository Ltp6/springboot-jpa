package com.ltp.feign;

import com.ltp.dto.R;
import com.ltp.dto.resp.Category;
import com.ltp.dto.resp.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Ltp
 * @description
 * @date 2020/6/30 16:27
 */
@FeignClient(name = "polyv", url = "${polyv.url}")
public interface PolyvFeign {
    /**
     * 获取直播用户账号信息接口
     * @param appId
     * @param timestamp
     * @param sign
     * @return
     */
    @GetMapping("/user/get-info")
    R<UserInfo> getUserInfo(@RequestParam(value = "appId") String appId,
                            @RequestParam(value = "timestamp") Long timestamp,
                            @RequestParam(value = "sign") String sign);

    /**
     * 查询账号下直播分类
     * @param appId
     * @param timestamp
     * @param sign
     * @return
     */
    @GetMapping("/user/category/list")
    R<List<Category>> getCategory(@RequestParam(value = "appId") String appId,
                                  @RequestParam(value = "timestamp") Long timestamp,
                                  @RequestParam(value = "sign") String sign);

    /**
     * 修改直播频道分类名称
     * @param appId
     * @param timestamp
     * @param sign
     * @param categoryId
     * @param categoryName
     * @return
     */
    @PostMapping("/user/category/update-name")
    R<String> updateCategoryName(@RequestParam(value = "appId") String appId,
                                 @RequestParam(value = "timestamp") Long timestamp,
                                 @RequestParam(value = "sign") String sign,
                                 @RequestParam(value = "categoryId") Integer categoryId,
                                 @RequestParam(value = "categoryName") String categoryName);
}
