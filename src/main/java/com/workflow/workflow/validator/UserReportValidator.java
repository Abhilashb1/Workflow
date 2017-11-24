package com.workflow.workflow.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.workflow.workflow.bean.Users;

@Component
public class UserReportValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof Users){
			Users user=(Users) target;
			errors.reject("225", "Password entered for "+user.getUserId()+" is incorrect");
		}
		
	}

}
