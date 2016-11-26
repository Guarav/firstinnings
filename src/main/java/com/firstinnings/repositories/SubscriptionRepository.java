package com.firstinnings.repositories;

import com.firstinnings.dto.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by poplig on 9/18/16.
 */
@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {

}
