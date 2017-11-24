package com.workflow.workflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workflow.workflow.bean.Users;
import com.workflow.workflow.service.UserService;
import com.workflow.workflow.validator.UserReportValidator;

@Controller
public class UsersReportController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserReportValidator userValidator;

	@RequestMapping(value="/signIn", params={"login"})
	public String signUp(@ModelAttribute("users") Users users, final BindingResult aResult) {
		String landingPage="index";
		String myUserId=users.getUserId();
		String myPassword=users.getPassword();
		if(!myUserId.isEmpty())
		{
			Users user=userService.findUser(myUserId);
			if(user!=null){
		if(!user.getPassword().equalsIgnoreCase(myPassword)){
			userValidator.validate(user.getPassword(), aResult);
			
		}
		if("Developer".equalsIgnoreCase(user.getRole())){
			
			landingPage="redirect:/searchDev";
		}else if("Lead".equalsIgnoreCase(user.getRole())){
			landingPage="redirect:/searchLead";
		}else if("Manager".equalsIgnoreCase(user.getRole())){
			landingPage="redirect:/searchManager";
		}
		}else{
				aResult.reject("226", "User ID "+myUserId+" does not exist!");
			}
			
		}
		
		
		
		
		return landingPage;
	}
	
	@RequestMapping(value="/register")
	public String register(@ModelAttribute Users users) {
		String myUserId=users.getUserId();
		if(!myUserId.isEmpty())
		{
		userService.insertUsers(users);
		}
		return "index";
	}
	
	@RequestMapping(value="/home")
	public String loadHome(Model model) {
		Users users=new Users();
		model.addAttribute(users);
		return "index";
	}
	
}
