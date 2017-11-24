package com.workflow.workflow.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workflow.workflow.bean.Projects;

public interface ProjectRepository extends MongoRepository<Projects, String>,ProjectRepositoryCustom{
	
	public List<Projects> findByDevelopers(List<String> developers);
	

}
