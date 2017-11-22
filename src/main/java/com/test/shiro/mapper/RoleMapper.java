package com.test.shiro.mapper;

import com.test.shiro.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @author Created by pangkunkun on 2017/11/20.
 */
@Mapper
@Service
public interface RoleMapper {

    /**
     * 新增角色
     * @param role
     * */
    void save(Role role);
}
