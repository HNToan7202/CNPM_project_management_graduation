package vn.iotstar.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Project;
import vn.iotstar.Entity.Student;
import vn.iotstar.Model.ProjectModel;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.IProjectService;
import vn.iotstar.Service.IStudentService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	IProjectService projectService;
	@Autowired
	ILectureService lectureService;

	@Autowired
	IStudentService studentService;

	@GetMapping("")
	public String search(ModelMap model) {
		List<Project> projects = projectService.findAll();
		List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("lectures", lectures);
		model.addAttribute("projects", projects);
		return "common/project";

	}

	@GetMapping("add")
	public String add(Model model) {
		ProjectModel project = new ProjectModel();
		project.setIsEdit(false);
		model.addAttribute("project", project);
		return "common/project/addOrEdit";
	}

	@GetMapping("/detail/{id}")
	public ModelAndView Detail(ModelMap model, HttpSession sesson, @PathVariable("id") Long id) {

		Optional<Project> opt = projectService.findById((long) id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			List<Student> studentlist = studentService.findByIdproject(id);
			model.addAttribute("sldk", studentlist.size());
			model.addAttribute("project", project);
			return new ModelAndView("common/projectDetail", model);
		}
		return new ModelAndView("common/projectDetail", model);
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) throws IOException {
		Optional<Project> opt = projectService.findById(id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			project.setIsEdit(true);
			model.addAttribute("notify", project);
			return new ModelAndView("common/project/addOrEdit", model);
		}
		model.addAttribute("message", "project không tồn tại");
		return new ModelAndView("redirect:/project", model);
	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("project") ProjectModel project,
			BindingResult result) {
		Project entity = new Project();
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("common/project/addOrEdit");
		}
		BeanUtils.copyProperties(project, entity);
		projectService.save(entity);
		return new ModelAndView("redirect:/project", model);
	}

	@GetMapping("search")
	public String search() {
		return "common/project/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		projectService.deleteById(id);
		return new ModelAndView("redirect:/project", model);
	}

}
