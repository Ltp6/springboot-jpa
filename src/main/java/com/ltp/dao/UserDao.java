package com.ltp.dao;

import com.ltp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserDao extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
}
