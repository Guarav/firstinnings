package com.firstinnings.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by poplig on 11/13/16.
 */
@Getter
@Builder
@Document
public class Renew {

    @NonNull
    @Id
    private String memberId;

    @NonNull
    @Indexed
    private String renewalDate;

    @Indexed
    private String currentDate;

    @NonNull
    private int membershipMonths;

    @NonNull
    private int amount;
}
