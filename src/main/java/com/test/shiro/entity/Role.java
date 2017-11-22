package com.test.shiro.entity;

import java.io.Serializable;

/**
 * @author Created by pangkunkun on 2017/11/15.
 */
public class Role implements Serializable{
    private static final long serialVersionUID = -6140090613812307452L;

    /**
     * 角色id
     * */
    private String roleId;

    /**
     * 角色名称，如：admin,user等
     * */
    private String roleName;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}