package com.workflow.workflow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workflow.workflow.bean.Users;

public interface UserRepository extends MongoRepository<Users,String>,UserRepositoryCustom{

	
	
}
