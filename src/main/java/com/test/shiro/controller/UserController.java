package com.test.shiro.controller;

import com.test.shiro.entity.Permission;
import com.test.shiro.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by pangkunkun on 2017/11/16.
 */
@RestController
public class UserController {

    private static final Logger log= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/users")
    @RequiresRoles(value={"admin","user"},logical = Logical.OR)
    @RequiresPermissions(value={"add","update"},logical = Logical.OR)
    public String getUserInfo(){

        log.info("into getUserInfo");
//        Subject subject= SecurityUtils.getSubject();
//        try {
//            subject.checkPermissions("add","update");
//        }catch (UnauthorizedException e){
//            log.info("错误信息："+e.getMessage());
//            //TODO 定义错误处理页面
//            log.info("权限不足");
//        }

        log.info("...............................");

        return "Success to get user info";
    }


    @PostMapping("/permission")
    public Permission createPermission(){
        System.out.println("createPermission");
        Permission permission=new Permission();
        permission.setPermission("add");
        permissionService.save(permission);
        return permission;
    }

}
