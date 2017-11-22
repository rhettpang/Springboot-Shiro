package com.test.shiro.service.impl;

import com.test.shiro.redis.RedisUtils;
import com.test.shiro.service.TokenService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by pangkunkun on 2017/11/19.
 */
@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public UsernamePasswordToken findByToken(String token){

        System.out.println("findByToken token:"+token);
        System.out.println("findByToken redisUtils:"+redisUtils);

        return (UsernamePasswordToken)redisUtils.get(token);
    }
}
