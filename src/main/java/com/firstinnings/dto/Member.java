package com.firstinnings.dto;

import java.util.Date;
import java.util.Map;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
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
@Builder
@EqualsAndHashCode
public class Member {

    @Indexed
    private Date   currentDate = new Date();

    @Id
    @Setter
    private String memberId;

    @NonNull
    private String name;

    @Indexed
    @NonNull
    private String email;

    @NonNull
    private String address;

    @NonNull
    private String sex;

    @Indexed
    @NonNull
    private String phone;

    @NonNull
    private Date   birthDate;

    @NonNull
    private String maritalStatus;

    @Indexed
    @Setter
    @NonNull
    private Date   membershipDate;

    private Status status = Status.ACTIVE;

    public static enum Status {
        ACTIVE,
        INACTIVE
    }
}
