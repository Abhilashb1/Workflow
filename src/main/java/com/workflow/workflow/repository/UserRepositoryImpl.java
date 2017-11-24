package com.workflow.workflow.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.workflow.workflow.bean.Users;

public class UserRepositoryImpl implements UserRepositoryCustom{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Users> findByUserId(String userId) {
		Query query = new Query();
		List<Users> user=mongoTemplate.find(query.addCriteria(Criteria.where("userId").is(userId)), Users.class, "users");
		
		return user;
	}

}
