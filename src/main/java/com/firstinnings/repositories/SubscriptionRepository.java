package com.firstinnings.repositories;

import com.firstinnings.dto.Member;
import com.firstinnings.dto.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by poplig on 9/18/16.
 */
@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {

    List<Subscription> findByExpirationDateBeforeAndStatus(Date date, Member.Status status);

    List<Subscription> findByStatusAndMemberId(Member.Status status, String memberId);

}
