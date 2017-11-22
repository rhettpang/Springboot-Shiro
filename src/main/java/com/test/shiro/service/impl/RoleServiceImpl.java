package com.test.shiro.service.impl;

import com.test.shiro.entity.Role;
import com.test.shiro.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Created by pangkunkun on 2017/11/16.
 */
@Service
public class RoleServiceImpl implements RoleService{

//    @Override
//    public Set<String> findAllRolesByUserId(String userId){
//        Set<String> roles=new HashSet<>();
//        roles.add("admin");
//        roles.add("user");
//        return roles;
//    }

    @Override
    public void save(Role role){

    }
}
