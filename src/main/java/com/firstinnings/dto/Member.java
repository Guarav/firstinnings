package com.firstinnings.dto;

import java.util.Map;

import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by poplig on 9/18/16.
 * Class storing the details of a member.
 */
@Getter
@Document
public class Member {

    @Id
    private String memberId;

    private String name;

    @Indexed
    private String email;

    private String address;

    private String sex;

    @Indexed
    private String phone;

    private String birthDate;

    private String membershipDate;

    private String placeJoining;

    private int    membershipMonths;

    private int    amountPaid;

    public Member(Map<String, String> details) {
        this.name = details.get("name");
        this.email = details.get("email");
        this.address = details.get("address");
        this.sex = details.get("sex");
        this.phone = details.get("phone");
        this.birthDate = details.get("birth_date");
        this.membershipDate = details.get("membership_date");
        this.placeJoining = details.get("place_joining");
        this.membershipMonths = Integer.valueOf(details.get("membership_months"));
        this.amountPaid = Integer.valueOf(details.get("amount_paid"));
    }
}
