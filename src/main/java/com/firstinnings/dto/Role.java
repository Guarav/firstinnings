package com.firstinnings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by poplig on 12/25/16.
 */
@Getter
@AllArgsConstructor
public class Role {

    private RoleName name;

    private String displayText;

    public static enum RoleName {

        enquiry,
        defaulters,
        addAMember,
        updateMember,
        subscribeMember,
        getRevenue

    }

}
