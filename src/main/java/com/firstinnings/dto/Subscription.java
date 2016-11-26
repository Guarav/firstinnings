package com.firstinnings.dto;

import lombok.Builder;
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
public class Subscription {

    @NonNull
    private String memberId;

    @Id
    @Setter
    private String subscriptionId;

    @NonNull
    @Indexed
    private String subscriptionDate;

    @Indexed
    private String currentDate;

    @NonNull
    private int    membershipMonths;

    @NonNull
    private int    amount;

    @NonNull
    private String place;
}
