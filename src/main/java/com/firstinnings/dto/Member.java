package com.firstinnings.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by poplig on 9/18/16. Class storing the details of a member. This will stores the details
 * of the member at the time of joining. Renewing the subscriptions will be done in separate table.
 */
@Getter
@Document
@EqualsAndHashCode
public class Member {

    @Indexed
    private Date   currentDate;

    @Id
    @Setter
    private String memberId;

    private String name;

    @Indexed
    private String email;

    private String address;

    private String sex;

    @Indexed
    private String phone;

    private Date   birthDate;

    private String maritalStatus;

    @Indexed
    private Date   membershipDate;

    private Status status = Status.ACTIVE;

    public Member() {

    }

    public Member(Map<String, String> details) throws Exception {
        this.name = details.get("name");
        this.email = details.get("email");
        this.address = details.get("address");
        this.sex = details.get("sex");
        this.phone = details.get("phone");
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        this.birthDate = dateFormat.parse(details.get("birth_date"));
        this.membershipDate = dateFormat.parse(details.get("membership_date"));
        this.maritalStatus = details.get("marital_status");
        String status = details.get("status");
        if (Status.INACTIVE.toString().equals(status)) {
            this.status = Status.INACTIVE;
        } else {
            this.status = Status.ACTIVE;
        }

        this.currentDate = new Date();
    }

    public static enum Status {
        ACTIVE,
        INACTIVE
    }
}
