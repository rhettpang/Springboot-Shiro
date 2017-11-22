package com.test.shiro.entity;

import java.io.Serializable;

/**
 * @author Created by pangkunkun on 2017/11/16.
 */
public class RolePermission implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * role id
     * */
    private String roleId;

    /**
     * permission id
     * */
    private String permissionId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
