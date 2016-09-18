package com.firstinnings.dto;

import java.util.Map;

import org.springframework.data.annotation.Id;

/**
 * Created by poplig on 9/18/16.
 * Class storing the details of a member.
 */
public class Member {

    @Id
    private String memberId;

    private String name;

    private String email;

    private String address;

    private String sex;

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

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getMembershipDate() {
        return membershipDate;
    }

    public String getPlaceJoining() {
        return placeJoining;
    }

    public int getMembershipMonths() {
        return membershipMonths;
    }

    public int getAmountPaid() {
        return amountPaid;
    }
}
