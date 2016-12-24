package com.firstinnings.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.firstinnings.dto.Member;
import com.firstinnings.dto.Subscription;

/**
 * Created by poplig on 9/18/16.
 */
@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {

    List<Subscription> findByExpirationDateBeforeAndStatus(Date date, Member.Status status);

    List<Subscription> findByStatusAndMemberId(Member.Status status, String memberId);

    List<Subscription> findBySubscriptionDateAfter(Date subscriptionDate);
}
