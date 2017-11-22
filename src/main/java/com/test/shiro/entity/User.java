package com.test.shiro.entity;

import java.io.Serializable;

/**
 * @author Created by pangkunkun on 2017/11/15.
 */
public class User  implements Serializable {

    private static final long serialVersionUID = -8736616045315083846L;

    /**
     * 用户id
     * */
    private String userId;

    /**
     * 用户名称
     * */
    private String username;

    /**
     * 密码
     * */
    private String password;

    /**
     * 是否启用
     */
    private Integer enable=0;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                '}';
    }
}
