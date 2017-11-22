package com.test.shiro.service.impl;

import com.test.shiro.entity.Permission;
import com.test.shiro.mapper.PermissionMapper;
import com.test.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Created by pangkunkun on 2017/11/16.
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findPermissionAndRoleNameByUserId(String userId){
        List<Permission> permissions=new ArrayList<>(2);
//        Permission permission=new Permission();
//        permission.setPermission("permission1");
//        permissions.add(permission);
//        permission.setPermission("add");
//        permissions.add(permission);
        permissions=permissionMapper.findPermissionAndRoleNameByUserId(userId);
        return permissions;
    }

    @Override
    public void save(Permission permission){
        System.out.println("permission:"+permission.toString());
        permissionMapper.save(permission);
    }
}
