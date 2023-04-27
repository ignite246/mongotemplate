package com.rahul.learning.mongodemo.repos;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.rahul.learning.mongodemo.controllers.UserRestController;
import com.rahul.learning.mongodemo.models.User;

@Repository
public class UserRepoMongoTemplate {
	
	
	Logger logger = LoggerFactory.getLogger(UserRepoMongoTemplate.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public User save(User user) {
		logger.info("<=== Going to save user ===>");
		return mongoTemplate.save(user);
	}
	
	public Optional<User> findById(String id) {
		logger.info("<=== Going to find user id ===>{}",id);
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(id));
		
		User userFound = mongoTemplate.findOne(query, User.class);
		return Optional.of(userFound);
	}
	
	public List<User> findAll(){
		logger.info("<=== Going to findAll user ===>()");
		return mongoTemplate.findAll(User.class);
	}
	
	public void deleteById(String id) {
		logger.info("<=== Going to delete user id===>{}",id);
		User userFound = findById(id).get();
		mongoTemplate.remove(userFound);
	}

}
