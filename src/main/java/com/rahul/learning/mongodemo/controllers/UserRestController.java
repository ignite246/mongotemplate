package com.rahul.learning.mongodemo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.learning.mongodemo.models.User;
import com.rahul.learning.mongodemo.repos.UserRepoMongoTemplate;


@RestController
@RequestMapping("/user")
public class UserRestController {

	Logger logger = LoggerFactory.getLogger(UserRestController.class);

	//@Autowired
	//private UserRepository userRepos;

	@Autowired
	private UserRepoMongoTemplate userRepos;
	
	@PostMapping("/save")
	public User createUser(@RequestBody User user) {
		logger.info("=== Save API Starts === {}", user);
		user.setUserId(UUID.randomUUID().toString());
		return userRepos.save(user);

	}

	@GetMapping("/find_all")
	public List<User> findAllUsers() {
		logger.info("=== findAllUsers API Starts ===");
		return userRepos.findAll();
	}

	@GetMapping("/find_by_id/{userId}")
	public User findUserById(@PathVariable("userId") String userId) {
		logger.info("=== findUserById API Starts ==={}", userId);
		Optional<User> optional = userRepos.findById(userId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new RuntimeException("User not found with given id : " + userId);
		}
	}

	@DeleteMapping("/delete_by_id/{id}")
	public String deleteUserById(@PathVariable("id") String id) {
		logger.info("=== deleteUserById API starts ===={}", id);
		userRepos.deleteById(id);
		return "success";
	}

}
