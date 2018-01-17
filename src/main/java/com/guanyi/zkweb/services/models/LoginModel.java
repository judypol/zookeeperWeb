package com.guanyi.zkweb.services.models;

/**
 * 登录模型
 */
public class LoginModel {
    String loginName;
    String role;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
