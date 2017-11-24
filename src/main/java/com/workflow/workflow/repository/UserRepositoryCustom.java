package com.workflow.workflow.repository;

import java.util.List;

import com.workflow.workflow.bean.Users;

public interface UserRepositoryCustom {
	
	public List<Users> findByUserId(String userId);

}
