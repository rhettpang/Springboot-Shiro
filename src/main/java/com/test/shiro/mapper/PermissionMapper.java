package com.test.shiro.mapper;

import com.test.shiro.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Created by pangkunkun on 2017/11/20.
 */
@Mapper
@Service
public interface PermissionMapper {

    /**
     * 新增权限
     * @param permission
     * */
    void save(Permission permission);

    /**
     * 通过userId获取用户所具有的权限
     * @param userId
     * @return List<Permission>
     * */
    List<Permission> findPermissionAndRoleNameByUserId(String userId);
}
