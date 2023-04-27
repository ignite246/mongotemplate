package com.rahul.learning.mongodemo.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {

	@Id
	private String userId;
	private String name;
	private String email;
	private String designation;
	private Date creationDate = new Date();
	private Map<String, String> address = new HashMap<>();
}
