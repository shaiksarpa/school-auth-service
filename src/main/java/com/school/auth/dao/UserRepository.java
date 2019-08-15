package com.school.auth.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.auth.model.User;

/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
