package com.test.shiro.service;

import com.test.shiro.entity.User;

/**
 * @author Created by pangkunkun on 2017/11/16.
 */
public interface UserService {

    /**
     * 通过userName获取用户信息
     * @param username
     * @return User
     * */
    User findByUsername(String username);

    /**
     * 新增user
     * @param user
     * */
    void save(User user);
}
