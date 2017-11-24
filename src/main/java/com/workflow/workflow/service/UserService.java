package com.workflow.workflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.workflow.bean.Users;
import com.workflow.workflow.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public void insertUsers(Users users )
	{
		userRepository.save(users);
	}

	public List<Users> fetchUser(String userId)
	{
		
		
		return userRepository.findByUserId(userId);
	
	}
	
	public Users findUser(String userId)
	{
		
		
		return userRepository.findOne(userId);
	
	}
}
