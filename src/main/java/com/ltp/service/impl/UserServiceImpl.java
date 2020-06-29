package com.ltp.service.impl;

import com.ltp.dao.UserDao;
import com.ltp.entity.QUser;
import com.ltp.entity.User;
import com.ltp.service.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> queryAll() {
        List<User> userList = userDao.findAll();
        jpaQueryFactory.selectFrom(QUser.user).where(QUser.user.id.eq(1L)).fetchResults();
        return userList;
    }
}
