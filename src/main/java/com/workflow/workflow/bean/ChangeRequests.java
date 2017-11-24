package com.workflow.workflow.bean;

import java.util.ArrayList;
import java.util.List;

public class ChangeRequests {
	
	private String cRNo;
	private String description;
	private String cqNumber;
	private String isCapacityRequired;
	private String postImplementation;
	private String cRType;
	private String cRStartDate;
	private String cREndDate;
	private String qcDropDate;
	private String effort;
	private String cRImplDate;
	private List<Resource> developers=new ArrayList<Resource>();
	private TimeLines timeLines=new TimeLines();
	
	public ChangeRequests(){
		
	}
	
	
	
	public ChangeRequests(String cRNo, String description, String cqNumber, String isCapacityRequired,
			String postImplementation, String cRType, String cRStartDate, String cREndDate, String qcDropDate, String effort,
			String cRImplDate, List<Resource> developers, TimeLines timeLines) {
		super();
		this.cRNo = cRNo;
		this.description = description;
		this.cqNumber = cqNumber;
		this.isCapacityRequired = isCapacityRequired;
		this.postImplementation = postImplementation;
		this.cRType = cRType;
		this.cRStartDate = cRStartDate;
		this.cREndDate = cREndDate;
		this.qcDropDate = qcDropDate;
		this.effort = effort;
		this.cRImplDate = cRImplDate;
		this.developers = developers;
		this.timeLines = timeLines;
	}



	public TimeLines getTimeLines() {
		return timeLines;
	}
	public void setTimeLines(TimeLines timeLines) {
		this.timeLines = timeLines;
	}
	public String getcRNo() {
		return cRNo;
	}
	public void setcRNo(String cRNo) {
		this.cRNo = cRNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCqNumber() {
		return cqNumber;
	}
	public void setCqNumber(String cqNumber) {
		this.cqNumber = cqNumber;
	}
	public String getIsCapacityRequired() {
		return isCapacityRequired;
	}
	public void setIsCapacityRequired(String isCapacityRequired) {
		this.isCapacityRequired = isCapacityRequired;
	}
	public String getPostImplementation() {
		return postImplementation;
	}
	public void setPostImplementation(String postImplementation) {
		this.postImplementation = postImplementation;
	}
	public String getcRType() {
		return cRType;
	}
	public void setcRType(String cRType) {
		this.cRType = cRType;
	}
	public String getcRStartDate() {
		return cRStartDate;
	}
	public void setcRStartDate(String cRStartDate) {
		this.cRStartDate = cRStartDate;
	}
	public String getcREndDate() {
		return cREndDate;
	}
	public void setcREndDate(String cREndDate) {
		this.cREndDate = cREndDate;
	}
	public String getQcDropDate() {
		return qcDropDate;
	}
	public void setQcDropDate(String qcDropDate) {
		this.qcDropDate = qcDropDate;
	}
	public String getEffort() {
		return effort;
	}
	public void setEffort(String effort) {
		this.effort = effort;
	}
	public String getcRImplDate() {
		return cRImplDate;
	}
	public void setcRImplDate(String cRImplDate) {
		this.cRImplDate = cRImplDate;
	}
	public List<Resource> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<Resource> developers) {
		this.developers = developers;
	}
	
	

}
