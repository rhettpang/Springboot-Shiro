package com.test.shiro.service;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author Created by pangkunkun on 2017/11/19.
 */
public interface TokenService {

    /**
     * 使用header中token的字符串查找redis中存储的相关信息
     * @param token
     * @return UsernamePasswordToken
     * */
    UsernamePasswordToken findByToken(String token);
}
