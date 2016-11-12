package com.firstinnings.repositories;

import com.firstinnings.dto.Renew;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.firstinnings.dto.Member;

/**
 * Created by poplig on 9/18/16.
 */
@Repository
public interface RenewRepository extends MongoRepository<Renew, String> {

}
