package com.workflow.workflow.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workflow.workflow.bean.ChangeRequests;
import com.workflow.workflow.bean.Projects;
import com.workflow.workflow.bean.Resource;
import com.workflow.workflow.bean.Search;
import com.workflow.workflow.service.ProjectService;
import com.workflow.workflow.validator.InsertDetailsValidator;

@Controller
public class DisplayProjectController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private InsertDetailsValidator detailsValidator;

	
	@GetMapping(value="/tracker")
	public String welcome(@ModelAttribute List<Projects> projectList) {
		List<Projects> retrievProjectList= projectService.listAllProject();
		for(Projects project:retrievProjectList)
		{
			projectList.add(project);
		}
		return "project";
	}
	
	
	@RequestMapping(value="/insert" , params={"removeRow"})
	public String unloadRowProject(@ModelAttribute("projectObject") final Projects projectObject, final BindingResult aResult,HttpServletRequest req ) {
		final  Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
		projectObject.getDevelopers().remove(rowId.intValue());
		return "InsertProjectDetails";
	}
	
	@RequestMapping(value="/insert", params={"addRow"})
	public   String loadRowProject(@ModelAttribute("projectObject") final Projects projectObject,final BindingResult aResult ) {
		projectObject.getDevelopers().add(new Resource());
		return "InsertProjectDetails";
	}
	
	@RequestMapping(value="/insert", params={"addRowCR"})
	public   String loadRowCR(@ModelAttribute("projectObject") final Projects projectObject,final BindingResult aResult ) {
		projectObject.getChangeRequests().get(0).getDevelopers().add(new Resource());
		return "InsertProjectDetails";
	}
	
	@RequestMapping(value="/insert", params={"addMiscRow"})
	public   String loadRowMisc(@ModelAttribute("projectObject") final Projects projectObject,final BindingResult aResult ) {
		projectObject.getMiscDevelopers().add(new Resource());
		return "InsertProjectDetails";
	}
	@RequestMapping(value="/insert" , params={"removeMiscRow"})
	public String unloadRowMisc(@ModelAttribute("projectObject") final Projects projectObject, final BindingResult aResult,HttpServletRequest req ) {
		final  Integer rowId = Integer.valueOf(req.getParameter("removeMiscRow"));
		projectObject.getMiscDevelopers().remove(rowId.intValue());
		return "InsertProjectDetails";
	}
	
	@RequestMapping(value="/insert" , params={"removeRowCR"})
	public String unloadRowCR(@ModelAttribute("projectObject") final Projects projectObject, final BindingResult aResult,HttpServletRequest req ) {
		final  Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
		projectObject.getChangeRequests().get(0).getDevelopers().remove(rowId.intValue());
		return "InsertProjectDetails";
	}
	
	@RequestMapping(value="/insert", params={"submit"})
	public   String insertProject(@ModelAttribute("projectObject") @Valid final Projects projectObject,final BindingResult aResult ) {
		detailsValidator.validate(projectObject, aResult);
		if(aResult.hasErrors()){
			return "InsertProjectDetails";
			
		}
		if(!"CR".equalsIgnoreCase(projectObject.getCategory())){
		projectObject.setChangeRequests(null);
		projectObject.setProjectNo(projectObject.getProjectName().substring(0, projectObject.getProjectName().indexOf(" ")));
		projectObject.setId(projectObject.getApplicationType()+"_"+projectObject.getProjectNo());
		projectService.insertProject(projectObject);
		}else {
			Search search=new Search();
			search.setProjectName(projectObject.getProjectName());
			search.setTrack(projectObject.getApplicationType());
			List<Projects> projects=projectService.searchProject(search);
			//we should have only one object in the list
			if(projects!=null){
				for (Projects projects2 : projects) {
					ChangeRequests changeRequests=projectObject.getChangeRequests().get(0);
					int cRlistsize=projects2.getChangeRequests().size();
					changeRequests.setcRNo(Integer.toString(cRlistsize+1));
					projects2.getChangeRequests().add(changeRequests);
					projectService.insertProject(projects2);
				}
			}
		}
		return "InsertProjectDetails";
	}
	
	@RequestMapping(value="/insert")
	public String loadProject( Model model) {
		Projects projects =new Projects();
		projects.getDevelopers().add(new Resource());
		projects.getMiscDevelopers().add(new Resource());
		projects.getChangeRequests().add(new ChangeRequests());
		projects.getChangeRequests().get(0).getDevelopers().add(new Resource());
		model.addAttribute("projectObject", projects);
		return "InsertProjectDetails"; 
	}
	
	@RequestMapping(value="/searchDev")
	public String searchDeveloper(Model model) {
		model.addAttribute("searchObject", new Search());
		model.addAttribute("projectListObject", new ArrayList<Projects>());
		return "developerSearch";
	}
	
	@RequestMapping(value="/searchDev",params={"fetch"})
	public String fetchProjects(@ModelAttribute("searchObject")final Search searchProject,@ModelAttribute("projectListObject")final ArrayList<Projects> projectsList,BindingResult aResult) {
		List<Projects> filteredProjects=projectService.searchProject(searchProject);
		for(Projects projects:filteredProjects)
		{
			if(searchProject.getCategory().equalsIgnoreCase("CR"))
			{
				projects.setCategory("CR");
			}
			projectsList.add(projects);
		}
		return "developerSearch";
	}
	
	@RequestMapping(value="/searchLead")
	public String searchLead(Model model) {
		model.addAttribute("searchObject", new Search());
		model.addAttribute("projectListObject", new ArrayList<Projects>());
		return "leadSearch";
	}
	
	@RequestMapping(value="/searchLead",params={"fetch"})
	public String fetchProjectsForLead(@ModelAttribute("searchObject")final Search searchProject,@ModelAttribute("projectListObject")final ArrayList<Projects> projectsList,BindingResult aResult) {
		List<Projects> filteredProjects=projectService.searchProject(searchProject);
		for(Projects projects:filteredProjects)
		{
			if(searchProject.getCategory().equalsIgnoreCase("CR"))
			{
				projects.setCategory("CR");
			}
			projectsList.add(projects);
		}
		return "leadSearch";
	}
	
	@RequestMapping(value="/searchLead",params={"addwork"})
	public String addNewWork() {
		return "redirect:/insert";
	}
	
	@RequestMapping(value="/searchManager")
	public String searchManager(Model model) {
		model.addAttribute("searchObject", new Search());
		model.addAttribute("projectListObject", new ArrayList<Projects>());
		return "managerSearch";
	}
	
	@RequestMapping(value="/searchManager",params={"fetch"})
	public String fetchProjectsForManager(@ModelAttribute("searchObject")final Search searchProject,@ModelAttribute("projectListObject")final ArrayList<Projects> projectsList,BindingResult aResult) {
		List<Projects> filteredProjects=projectService.searchProject(searchProject);
		for(Projects projects:filteredProjects)
		{
			if(searchProject.getCategory().equalsIgnoreCase("CR"))
			{
				projects.setCategory("CR");
			}
			projectsList.add(projects);
		}
		return "managerSearch";
	}
	
	
	
}
