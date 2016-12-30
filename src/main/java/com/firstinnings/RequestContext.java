package com.firstinnings;

import com.firstinnings.dto.Role;

import java.util.List;

/**
 * Request context for the user logged in.
 * Created by poplig on 9/11/16.
 */
public class RequestContext {

    private String       userName;

    private String       fullName;

    private List<Role> roles;

    private String       userId;

    private String pageType;

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "RequestContext{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", roles=" + roles +
                ", userId='" + userId + '\'' +
                ", pageType='" + pageType + '\'' +
                '}';
    }
}
