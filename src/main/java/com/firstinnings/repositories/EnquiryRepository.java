package com.firstinnings.repositories;

import com.firstinnings.dto.Enquiry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.firstinnings.dto.Subscription;

/**
 * Created by poplig on 9/18/16.
 */
@Repository
public interface EnquiryRepository extends MongoRepository<Enquiry, String> {

}
