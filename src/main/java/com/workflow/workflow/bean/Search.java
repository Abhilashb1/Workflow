package com.workflow.workflow.bean;

public class Search {
	
	private String developerName;
	private String track;
	private String category;
	private String projectType;
	private String implDate;
	private String sdlcPhase;
	private String teamOwning;
	private String ioNumber;
	private String tddType;
	private String leadName;
	private String projectName;
	
	public Search(){
		
	}
	
	public Search(String developerName, String track, String category, String projectType, String implDate,
			String sdlcPhase, String teamOwning, String ioNumber, String tddType, String leadName, String projectName) {
		super();
		this.developerName = developerName;
		this.track = track;
		this.category = category;
		this.projectType = projectType;
		this.implDate = implDate;
		this.sdlcPhase = sdlcPhase;
		this.teamOwning = teamOwning;
		this.ioNumber = ioNumber;
		this.tddType = tddType;
		this.leadName = leadName;
		this.projectName = projectName;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getImplDate() {
		return implDate;
	}
	public void setImplDate(String implDate) {
		this.implDate = implDate;
	}
	public String getSdlcPhase() {
		return sdlcPhase;
	}
	public void setSdlcPhase(String sdlcPhase) {
		this.sdlcPhase = sdlcPhase;
	}
	public String getTeamOwning() {
		return teamOwning;
	}
	public void setTeamOwning(String teamOwning) {
		this.teamOwning = teamOwning;
	}
	public String getIoNumber() {
		return ioNumber;
	}
	public void setIoNumber(String ioNumber) {
		this.ioNumber = ioNumber;
	}
	public String getTddType() {
		return tddType;
	}
	public void setTddType(String tddType) {
		this.tddType = tddType;
	}
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	

}
