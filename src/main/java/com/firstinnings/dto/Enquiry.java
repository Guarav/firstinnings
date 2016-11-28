package com.firstinnings.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by eshag on 11/27/16.
 */
@Getter
@Builder
@Document
public class Enquiry {

    @NonNull
    private String name;

    private String email;

    private String address;

    private String sex;

    @NonNull
    private String phone;

    @Id
    @Setter
    private String enquiryId;

    @Indexed
    private Date currentDate;

    @NonNull
    private String source;

}
