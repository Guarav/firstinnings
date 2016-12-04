package com.firstinnings.dto;

import java.util.Date;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by poplig on 11/13/16.
 */
@Getter
@Builder
@Document
@EqualsAndHashCode
public class Subscription {

    @NonNull
    private String memberId;

    @Id
    @Setter
    private String subscriptionId;

    @NonNull
    @Indexed
    private Date   subscriptionDate;

    @Indexed
    private Date   currentDate;

    @Indexed
    @NonNull
    private Date   expirationDate;

    @NonNull
    private int    membershipMonths;

    @NonNull
    private int    amount;

    @NonNull
    private String place;

    @Setter
    private Member.Status status = Member.Status.ACTIVE;
}
