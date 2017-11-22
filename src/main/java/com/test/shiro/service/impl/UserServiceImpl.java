package com.test.shiro.service.impl;

import com.test.shiro.entity.User;
import com.test.shiro.mapper.UserMapper;
import com.test.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by pangkunkun on 2017/11/16.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username){
        User user=new User();
//        user.setUserId("userId");
//        user.setUsername("admin");
//        user.setPassword("3ef7164d1f6167cb9f2658c07d3c2f0a");
//        user.setUserId("1");
//        user.setUsername("kun1");
//        user.setPassword("b7465a01fc4f189163c09360ee1142b5");
//        user.setEnable(1);

        return userMapper.findByUsername(username);
    }

    @Override
    public void save(User user){

    }
}
