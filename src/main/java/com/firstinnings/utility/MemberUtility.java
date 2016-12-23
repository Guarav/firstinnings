package com.firstinnings.utility;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firstinnings.dto.Member;

/**
 * Created by poplig on 12/23/16. Utility class to provide methods related to member details.
 */
@Component
public class MemberUtility {

    @Autowired
    private DateUtility dateUtility;

    /**
     * Prepare the member object from parameters.
     * @param parameters the parameters
     * @return the member object
     */
    public Member prepareMemberFromParams(Map<String, String> parameters) {
        Member.MemberBuilder memberBuilder = Member.builder().address(parameters.get("address"))
                .name(parameters.get("name"))
                .email(parameters.get("email")).birthDate(dateUtility.convertToDate(parameters.get("birth_date")))
                .maritalStatus(parameters.get("marital_status")).sex(parameters.get("sex"))
                .phone(parameters.get("phone"))
                .membershipDate(dateUtility.convertToDate(parameters.get("membership_date")));

        String status = parameters.get("status");
        if (Member.Status.INACTIVE.toString().equals(status)) {
            memberBuilder.status(Member.Status.INACTIVE);
        }

        return memberBuilder.build();

    }

}
