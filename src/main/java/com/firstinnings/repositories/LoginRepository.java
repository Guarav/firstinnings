package com.firstinnings.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.firstinnings.dto.Login;

/**
 * Created by kumrahul on 9/11/16.
 * https://spring.io/guides/gs/accessing-data-mongodb/
 * http://projects.spring.io/spring-data-mongodb/
 */
@Repository
public interface LoginRepository extends MongoRepository<Login, String> {}
