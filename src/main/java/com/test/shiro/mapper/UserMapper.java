package com.test.shiro.mapper;

import com.test.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @author Created by pangkunkun on 2017/11/20.
 */
@Mapper
@Service
public interface UserMapper {

    /**
     * 通过username获取用户信息
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
