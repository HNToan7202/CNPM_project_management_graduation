package vn.iotstar.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.iotstar.Entity.Project;
import vn.iotstar.ServiceImpl.ProjectServiceImpl;

@Controller
@RequestMapping("/admin/project")
public class ProjectController {
	
	@Autowired
	private ProjectServiceImpl projectService;
	
//	@GetMapping("add")
//	public String add(Model model)
//	{
//		model.addAttribute("project", new Project());
//		return "admin/project/addorEdit";
//		
//	}
//	
//	@GetMapping("edit/{id}")
//	public String edit() {
//		return "admin/project/addorEdit";
//	}
//	
//	@GetMapping("delete/{id}")
//	public String delete() {
//		return "redirect:/admin/project";
//	}
//	
	@RequestMapping("")
	public String list(ModelMap model) {

		//gọi hàm findAll() trong service

		List<Project> list = projectService.findAll();

		//chuyển dữ liệu từ list lên biến categories 

		model.addAttribute("projects", list);

		return "admin/project/list";

	}

}
