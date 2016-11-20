package com.firstinnings.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.firstinnings.dto.Member;

/**
 * Created by poplig on 9/18/16.
 */
@Repository
public interface MemberRepository extends MongoRepository<Member, String> {

    Member findByPhone(String phone);

    Member findByEmail(String email);

    Member findByName(String name);

    Member findAllByPlaceJoining();

}
