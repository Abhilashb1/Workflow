package com.workflow.workflow.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.workflow.workflow.bean.Projects;
import com.workflow.workflow.bean.Search;

public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	public List<Projects> findByProjects(Search search) {

		Query query = new Query();
		
		if (null!=search.getDeveloperName()&& !search.getDeveloperName().isEmpty()) {
			query.addCriteria(Criteria.where("developers").elemMatch(Criteria.where("name").is(search.getDeveloperName())));
		}

		if (null!=search.getTrack() && !search.getTrack().isEmpty()) {
			query.addCriteria(Criteria.where("applicationType").is(search.getTrack()));
		}
		if (null!=search.getCategory() && !search.getCategory().isEmpty()) {
			if(search.getCategory().equalsIgnoreCase("CR"))
			{
			query.addCriteria(Criteria.where("changeRequests").exists(true));
			}
			else
			{
			query.addCriteria(Criteria.where("category").is(search.getCategory()));
			}
		}
		if (null!=search.getProjectType() && !search.getProjectType().isEmpty()) {
			query.addCriteria(Criteria.where("projectType").is(search.getProjectType()));
		}
		if (null!=search.getImplDate() && !search.getImplDate().isEmpty()) {
			query.addCriteria(Criteria.where("implDate").is(search.getImplDate()));
		}
		/*
		 * if(!search.getSdlcPhase().isEmpty()) {
		 * query.addCriteria(Criteria.where("category").is(search.getCategory())
		 * ); }
		 */
		if (null!=search.getTeamOwning() && !search.getTeamOwning().isEmpty()) {
			query.addCriteria(Criteria.where("teamOwning").is(search.getTeamOwning()));
		}
		if (null!=search.getIoNumber() && !search.getIoNumber().isEmpty()) {
			query.addCriteria(Criteria.where("ioNumber").is(search.getIoNumber()));
		}
		if (null!=search.getTddType() && !search.getTddType().isEmpty()) {
			// query.addCriteria(Criteria.where("tddType").is(search.getTddType()));
		}
		if (null!=search.getLeadName() && !search.getLeadName().isEmpty()) {
			query.addCriteria(Criteria.where("offshoreTL").is(search.getLeadName()));
		}
		if (null!=search.getProjectName() && !search.getProjectName().isEmpty()) {
			query.addCriteria(Criteria.where("projectName").is(search.getProjectName()));
		}

		List<Projects> filteredProjects=mongoTemplate.find(query, Projects.class, "projects");
		return filteredProjects;
	}

}
