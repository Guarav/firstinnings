package com.firstinnings.accessor;

import com.firstinnings.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * Class for accessing mongo.
 */
// todo: currently our work is done by just defining methods in interface. leaving as is for now.
@Component
public class MongoAccessor {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Member findMemberByPhone(String phone) {
        Query query = new Query();
        query.addCriteria(Criteria.where("phone").is(phone));
        return mongoTemplate.findOne(query, Member.class);
    }

}
