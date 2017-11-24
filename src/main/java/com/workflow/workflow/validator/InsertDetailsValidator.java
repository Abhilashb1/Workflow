package com.workflow.workflow.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.workflow.workflow.bean.Projects;
import com.workflow.workflow.bean.Resource;
import com.workflow.workflow.bean.Search;
import com.workflow.workflow.service.ProjectService;
@Component
public class InsertDetailsValidator implements Validator{

	
	
	private Search aSearch=new Search();
	@Autowired
	private ProjectService projectService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Projects.class.isAssignableFrom(clazz);
	}

	public void validate(Projects target, Errors errors)  {
		for (Resource aResource : target.getDevelopers()) {
			Calendar newAnalyzeStart= Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
			try {
				newAnalyzeStart.setTime(dateFormat.parse(target.getTimelines().getAnalyzeStart()));
			
			aSearch.setDeveloperName(aResource.getName());
			List<Projects> projects=projectService.searchProject(aSearch);
			for (Projects projects2 : projects) {
				Calendar analyzeStart=Calendar.getInstance();
				analyzeStart.setTime(dateFormat.parse(projects2.getTimelines().getAnalyzeStart()));
				Calendar qcDrop=Calendar.getInstance();
				qcDrop.setTime(dateFormat.parse(projects2.getTimelines().getQcDrop()));
				
				if(analyzeStart.compareTo(newAnalyzeStart)>=0 && analyzeStart.compareTo(qcDrop)<=0){
					for (Resource resource : projects2.getDevelopers()) {
						if(aResource.getName().equalsIgnoreCase(resource.getName())){
							errors.reject("256",""+aResource.getName()+" is blocked for the project "+projects2.getProjectName()+" with an allocation percentage of "+resource.getAllocationPercentage()+" in this duration.Do you still want to proceed?");
							break;
						}
					}
					
				}
			}
			
			} catch (ParseException myException) {
				// TODO Auto-generated catch block
				myException.printStackTrace();
			}
		}
		
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors,"applicationType","applicationType Empty","Track : enter a valid value");
//		 ValidationUtils.rejectIfEmptyOrWhitespace(errors,"category","category Empty","Category :enter a valid value");
//		 ValidationUtils.rejectIfEmptyOrWhitespace(errors,"projectType","projectType Empty","Project : Type enter a valid application type");
//		 ValidationUtils.rejectIfEmptyOrWhitespace(errors,"projectType","projectType Empty","Project : Type enter a valid application type");
//		 ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ioNumber","ioNumber Empty","IO Number enter a valid application type");
		 
		 
		 
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
