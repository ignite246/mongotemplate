package com.rahul.learning.mongodemo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rahul.learning.mongodemo.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

}
