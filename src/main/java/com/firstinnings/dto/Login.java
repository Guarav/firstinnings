package com.firstinnings.dto;

import org.springframework.data.annotation.Id;

/**
 * Created by kumrahul on 9/11/16.
 * It stores login information.
 */
public class Login {

    @Id
    public String  loginId;

    private String password;

    public Login() {}

    public Login(final String loginId, final String lastName) {
        this.loginId = loginId;
        this.password = lastName;
    }

    public String getPassword() {
        return password;
    }
}
