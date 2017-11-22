package com.test.shiro.service;

import com.test.shiro.entity.Permission;
import java.util.List;

/**
 * @author Created by pangkunkun on 2017/11/16.
 */
public interface PermissionService {


    /**
     * 新增角色
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
