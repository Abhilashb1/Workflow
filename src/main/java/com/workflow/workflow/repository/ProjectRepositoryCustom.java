package com.workflow.workflow.repository;

import java.util.List;

import com.workflow.workflow.bean.Projects;
import com.workflow.workflow.bean.Search;

public interface ProjectRepositoryCustom {
	
	List<Projects> findByProjects(Search projects);

}
