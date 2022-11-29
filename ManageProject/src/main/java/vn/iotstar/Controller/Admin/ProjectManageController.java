package vn.iotstar.Controller.Admin;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.Entity.Project;
import vn.iotstar.Service.IProjectService;

@Controller
@RequestMapping("/admin/project")
public class ProjectManageController {
	
	@Autowired
	IProjectService projectService;
	
	@Autowired
	ServletContext application;
	
	@GetMapping("")
	public String list(ModelMap model) {
		List<Project> project = projectService.findAll();
		model.addAttribute("projects", project);
		return "admin/project/list";
	}
	
	
	

	
}
