package vn.iotstar.Controller.Admin;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Project;
import vn.iotstar.Model.ProjectModel;
import vn.iotstar.Service.IProjectService;

@Controller
@RequestMapping("/admin/project")
public class ProjectManageController {

	@Autowired
	IProjectService projectService;

	@GetMapping("")
	public String list(ModelMap model) {
		List<Project> project = projectService.findAll();
		model.addAttribute("project", project);
		return "admin/project/list";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		ProjectModel proj = new ProjectModel();
		proj.setIsEdit(false);
		model.addAttribute("project", proj);

		return "admin/project/addOrEdit";

	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("project") ProjectModel proj,
			BindingResult result) // Tra ve chuoi result
	{

		String message = "Error Khong The Them";
		if (result.hasErrors()) {

			model.addAttribute("message", message);
			return new ModelAndView("admin/project/addOrEdit");
		}
		Project entity = new Project();

		BeanUtils.copyProperties(proj, entity); // do du lieu tu model sang entity

		projectService.save(entity);

		if (proj.getIsEdit() == true) {
			message = "Project Update succesfull !";
		} else {
			message = "Project Create Successfull !";
		}

		model.addAttribute("message", message);
		return new ModelAndView("redirect:/admin/project", model);

	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		projectService.deleteById(id);
		return new ModelAndView("redirect:/admin/project", model);
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model,@PathVariable("id") Long id){
		Optional<Project> opt = projectService.findById(id);
		ProjectModel proj = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, proj);
			proj.setIsEdit(true);
			model.addAttribute("project", proj);
			return new ModelAndView("admin/project/addOrEdit", model);
		}
		model.addAttribute("message", "Project không tồn tại");
		return new ModelAndView("redirect:/admin/project", model);
		
	}

}
