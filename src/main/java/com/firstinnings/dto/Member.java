package com.firstinnings.dto;

import java.util.Date;
import java.util.Map;

import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by poplig on 9/18/16. Class storing the details of a member. This will stores the details
 * of the member at the time of joining. Renewing the subscriptions will be done in separate table.
 */
@Getter
@Document
public class Member {

    @Indexed
    private String currentDate;

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

    @Indexed
    private String membershipDate;

    @Indexed
    private String placeJoining;

    @Indexed
    private int    membershipMonths;

    private int    amountPaid;

    public Member() {

    }

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
        this.currentDate = new Date().toString();
    }

    @Override
    public String toString() {
        return "Member{" +
                "currentDate='" + currentDate + '\'' +
                ", memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", membershipDate='" + membershipDate + '\'' +
                ", placeJoining='" + placeJoining + '\'' +
                ", membershipMonths=" + membershipMonths +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
