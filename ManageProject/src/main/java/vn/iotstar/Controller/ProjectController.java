package vn.iotstar.Controller;

import java.util.List;

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
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	IProjectService projectService;

	@GetMapping("")
	public ModelAndView List(ModelMap model) {
		List<Project> project = projectService.findAll();
		model.addAttribute("project", project);
		return new ModelAndView("common/project/list", model);
		
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		ProjectModel project = new ProjectModel();
		project.setIsEdit(false);
		model.addAttribute("project", project);

		return "common/project/addOrEdit";

	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") ProjectModel project,
			BindingResult result) // Tra ve chuoi result
	{
		if (result.hasErrors()) {
			return new ModelAndView("project/addOrEdit");
		}
		Project entity = new Project();

		BeanUtils.copyProperties(project, entity); // do du lieu tu model sang entity

		projectService.save(entity);

		String message = "";
		if (project.getIsEdit() == true) {
			message = "Category Update succesfull !";
		} else {
			message = "Category Create Successfull !";
		}

		model.addAttribute("message", message);
		return new ModelAndView("forward:/project", model);

	}
	
	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		projectService.deleteById(id);
		model.addAttribute("message", "Category Delete Succesfull !!!");

		return new ModelAndView("redirect:/project", model);

	}
//	@GetMapping("add")
//	public String add(Model model) {
//		ProjectModel project = new ProjectModel();
//		project.setIsEdit(false);
//		model.addAttribute("project", project);
//		return "common/project/addOrEdit";
//	}
//
//	@GetMapping("edit/{id}")
//	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) throws IOException {
//		Optional<Project> opt = projectService.findById(id);
//		ProjectModel project = new ProjectModel();
//		if (opt.isPresent()) {
//			Project entity = opt.get();
//			BeanUtils.copyProperties(entity, project);
//			project.setIsEdit(true);
//			model.addAttribute("notify", project);
//			return new ModelAndView("common/project/addOrEdit", model);
//		}
//		model.addAttribute("message", "project không tồn tại");
//		return new ModelAndView("redirect:/project", model);
//	}
//
//	@PostMapping("saveOrUpdate")
//	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("project") ProjectModel project,
//			BindingResult result) {
//		Project entity = new Project();
//		if (result.hasErrors()) {
//			model.addAttribute("message", "Có lỗi");
//			return new ModelAndView("common/project/addOrEdit");
//		}
//		BeanUtils.copyProperties(project, entity);
//		projectService.save(entity);
//		return new ModelAndView("redirect:/project", model);
//	}
//
//	@GetMapping("search")
//	public String search() {
//		return "common/project/search";
//	}
//
//	@GetMapping("delete/{id}")
//	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
//		projectService.deleteById(id);
//		return new ModelAndView("redirect:/project", model);
//	}

}
