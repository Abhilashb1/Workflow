package com.workflow.workflow.bean;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projects")
public class Projects {
@Id
private String id;
private String projectNo;
private String projectName;
private String applicationType;
private String ioNumber;
private String isCapacityRequired;
private String projectType;
private String projectStatus;
private String implDate;
private String effort;
private String teamOwning;
private List<Resource> developers=new ArrayList<Resource>();
private String cqNumber;
private String geographicStates;
private String isNFRRequired;
private TimeLines timelines =new TimeLines();
private List<ChangeRequests> changeRequests=new ArrayList<ChangeRequests>();
private String projectFolder;
private String category;
private String priority;
private String taskName;
private String taskDescription;
private List<Resource> miscDevelopers=new ArrayList<Resource>();


public Projects(){
	
}

public Projects(String id, String projectNo, String projectName, String applicationType, String ioNumber,
		String isCapacityRequired, String projectType, String projectStatus, String implDate, String effort,
		String teamOwning, List<Resource> developers, String cqNumber, String geographicStates, String isNFRRequired,
		TimeLines timelines, List<ChangeRequests> changeRequests, String projectFolder, String category,
		String priority, String taskName, String taskDescription, List<Resource> miscDevelopers) {
	super();
	this.id = id;
	this.projectNo = projectNo;
	this.projectName = projectName;
	this.applicationType = applicationType;
	this.ioNumber = ioNumber;
	this.isCapacityRequired = isCapacityRequired;
	this.projectType = projectType;
	this.projectStatus = projectStatus;
	this.implDate = implDate;
	this.effort = effort;
	this.teamOwning = teamOwning;
	this.developers = developers;
	this.cqNumber = cqNumber;
	this.geographicStates = geographicStates;
	this.isNFRRequired = isNFRRequired;
	this.timelines = timelines;
	this.changeRequests = changeRequests;
	this.projectFolder = projectFolder;
	this.category = category;
	this.priority = priority;
	this.taskName = taskName;
	this.taskDescription = taskDescription;
	this.miscDevelopers = miscDevelopers;
}


public String getProjectNo() {
	return projectNo;
}
public void setProjectNo(String projectNo) {
	this.projectNo = projectNo;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getApplicationType() {
	return applicationType;
}
public void setApplicationType(String applicationType) {
	this.applicationType = applicationType;
}
public String getIoNumber() {
	return ioNumber;
}
public void setIoNumber(String ioNumber) {
	this.ioNumber = ioNumber;
}
public String getIsCapacityRequired() {
	return isCapacityRequired;
}
public void setIsCapacityRequired(String isCapacityRequired) {
	this.isCapacityRequired = isCapacityRequired;
}
public String getProjectType() {
	return projectType;
}
public void setProjectType(String projectType) {
	this.projectType = projectType;
}
public String getProjectStatus() {
	return projectStatus;
}
public void setProjectStatus(String projectStatus) {
	this.projectStatus = projectStatus;
}
public String getImplDate() {
	return implDate;
}
public void setImplDate(String implDate) {
	this.implDate = implDate;
}
public String getEffort() {
	return effort;
}
public void setEffort(String effort) {
	this.effort = effort;
}
public String getTeamOwning() {
	return teamOwning;
}
public void setTeamOwning(String teamOwning) {
	this.teamOwning = teamOwning;
}
public String getCqNumber() {
	return cqNumber;
}
public void setCqNumber(String cqNumber) {
	this.cqNumber = cqNumber;
}
public String getGeographicStates() {
	return geographicStates;
}
public void setGeographicStates(String geographicStates) {
	this.geographicStates = geographicStates;
}
public String getIsNFRRequired() {
	return isNFRRequired;
}
public void setIsNFRRequired(String isNFRRequired) {
	this.isNFRRequired = isNFRRequired;
}
public TimeLines getTimelines() {
	return timelines;
}
public void setTimelines(TimeLines timelines) {
	this.timelines = timelines;
}
public List<ChangeRequests> getChangeRequests() {
	return changeRequests;
}
public void setChangeRequests(List<ChangeRequests> changeRequests) {
	this.changeRequests = changeRequests;
}
public String getProjectFolder() {
	return projectFolder;
}
public void setProjectFolder(String projectFolder) {
	this.projectFolder = projectFolder;
}
	
public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public List<Resource> getDevelopers() {
	return developers;
}

public void setDevelopers(List<Resource> developers) {
	this.developers = developers;
}

public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
}

public String getTaskName() {
	return taskName;
}

public void setTaskName(String taskName) {
	this.taskName = taskName;
}

public String getTaskDescription() {
	return taskDescription;
}

public void setTaskDescription(String taskDescription) {
	this.taskDescription = taskDescription;
}

public List<Resource> getMiscDevelopers() {
	return miscDevelopers;
}

public void setMiscDevelopers(List<Resource> miscDevelopers) {
	this.miscDevelopers = miscDevelopers;
}





}
