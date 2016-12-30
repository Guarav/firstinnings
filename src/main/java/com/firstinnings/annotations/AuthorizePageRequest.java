package com.firstinnings.annotations;

import com.firstinnings.dto.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by poplig on 12/30/16.
 * This annotation is used to authorize the request for a particular page given the role controlling it.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AuthorizePageRequest {

    Role.RoleName roleName();
}
