package com.ltp.service;


import com.ltp.dto.resp.Category;
import com.ltp.dto.resp.UserInfo;
import com.ltp.entity.User;

import java.util.List;

public interface UserService {

    List<User> queryAll();

    UserInfo getUserInfo();

    void updateCategoryName(Integer categoryId, String categoryName);

    List<Category> getCategory();
}
