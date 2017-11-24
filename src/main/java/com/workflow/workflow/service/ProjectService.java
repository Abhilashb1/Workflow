package com.workflow.workflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.workflow.bean.Projects;
import com.workflow.workflow.bean.Search;
import com.workflow.workflow.repository.ProjectRepository;

@Service
public class ProjectService {
	
@Autowired
private ProjectRepository projectRepository;

public void insertProject(Projects projects )
{
	projectRepository.save(projects);
}

public List<Projects> listAllProject()
{
	return projectRepository.findAll();
}

public List<Projects> searchProject(List<String> developerList)
{
	return projectRepository.findByDevelopers(developerList);
}



public List<Projects> searchProject(Search search)
{
	return projectRepository.findByProjects(search);
}
}
