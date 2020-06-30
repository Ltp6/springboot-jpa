package com.ltp.service.impl;

import com.ltp.dao.UserDao;
import com.ltp.dto.resp.Category;
import com.ltp.dto.resp.UserInfo;
import com.ltp.entity.QUser;
import com.ltp.entity.User;
import com.ltp.feign.PolyvFeign;
import com.ltp.service.UserService;
import com.ltp.utils.PolyvSignUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private JPAQueryFactory jpaQueryFactory;

    @Resource
    private PolyvFeign polyvFeign;

    @Resource
    private PolyvSignUtils polyvSignUtils;

    @Value("${polyv.appId}")
    private String appId;

    @Override
    public List<User> queryAll() {
        List<User> userList = userDao.findAll();
        jpaQueryFactory.selectFrom(QUser.user).where(QUser.user.id.eq(1L)).fetchResults();
        return userList;
    }

    @Override
    public UserInfo getUserInfo() {
        long timestamp = System.currentTimeMillis();
        Map<String, String> map = new HashMap<>();
        map.put("appId", appId);
        map.put("timestamp", Long.toString(timestamp));
        String sign = polyvSignUtils.generateSign(map);
        return polyvFeign.getUserInfo(appId, timestamp, sign).getData();
    }

    @Override
    public void updateCategoryName(Integer categoryId, String categoryName) {
        long timestamp = System.currentTimeMillis();
        Map<String, String> map = new HashMap<>();
        map.put("appId", appId);
        map.put("timestamp", Long.toString(timestamp));
        map.put("categoryId", Integer.toString(categoryId));
        map.put("categoryName", categoryName);
        String sign = polyvSignUtils.generateSign(map);
        polyvFeign.updateCategoryName(appId, timestamp, sign, categoryId, categoryName);
    }

    @Override
    public List<Category> getCategory() {
        long timestamp = System.currentTimeMillis();
        Map<String, String> map = new HashMap<>();
        map.put("appId", appId);
        map.put("timestamp", Long.toString(timestamp));
        String sign = polyvSignUtils.generateSign(map);
        return polyvFeign.getCategory(appId, timestamp, sign).getData();
    }
}
