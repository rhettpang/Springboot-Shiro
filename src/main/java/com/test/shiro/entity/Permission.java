package com.test.shiro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @author Created by pangkunkun on 2017/11/16.
 */
public class Permission implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * ID
     * */
    public Integer permissionId;

    /**
     *权限，如：update、delete、add、query等
     * */
    public String permission;

    /**
     * 角色名称，如：admin,user等
     * */
    @JsonIgnore
    private String roleName;


    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", permission='" + permission + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
