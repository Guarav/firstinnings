package com.firstinnings;

import java.util.List;

/**
 * Request context for the user logged in.
 * Created by poplig on 9/11/16.
 */
public class RequestContext {

    private String       userName;

    private String       fullName;

    private List<String> roles;

    private String       userId;

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
