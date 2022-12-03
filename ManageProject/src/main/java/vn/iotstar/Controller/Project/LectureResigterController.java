package vn.iotstar.Controller.Project;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

import vn.iotstar.Entity.Project;
import vn.iotstar.Entity.Timeresgiter;
import vn.iotstar.Model.ProjectModel;
import vn.iotstar.Service.ILeaderLectureService;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.IProjectService;
import vn.iotstar.Service.IStudentService;
import vn.iotstar.Service.ITimeResgiterSerivce;

@Controller
@RequestMapping("/lecture/project")
public class LectureResigterController {

	@Autowired
	ITimeResgiterSerivce resgiterSerivce;

	@Autowired
	IProjectService projectService;

	@Autowired
	ILectureService lectureService;

	@Autowired
	IStudentService studentService;

	@Autowired
	ILeaderLectureService leaderLectureService;

	@GetMapping("")
	public ModelAndView List(ModelMap model) {

		long count = lectureService.count() + studentService.count() + leaderLectureService.count();
		model.addAttribute("count", count);

		List<Project> project = projectService.findAll();
		model.addAttribute("project", project);
		return new ModelAndView("common/lecproject/list", model);
	}

	@GetMapping("add")
	public String add(Model model) {
//		Optional<Timeresgiter> opt = resgiterSerivce.findById((long)1);
//		if(opt.isPresent()){
//			Timeresgiter time = opt.get();
//			Date create = time.getCreate_at();
//			Date finish = time.getFinish_at();
//			Date getDate = new Date();
//			model.addAttribute("create_date", create);
//			model.addAttribute("finish_date", finish);
//			model.addAttribute("getdate", getDate);

//		}

		ProjectModel project = new ProjectModel();
		project.setIsEdit(false);
		model.addAttribute("project", project);
		return "common/lecproject/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) throws IOException {
		long count = lectureService.count() + studentService.count() + leaderLectureService.count();
		model.addAttribute("count", count);
		Optional<Project> opt = projectService.findById(id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			project.setIsEdit(true);
			model.addAttribute("project", project);
			return new ModelAndView("common/lecproject/addOrEdit", model);
		}
		model.addAttribute("message", "project không tồn tại");
		return new ModelAndView("redirect:/lecutre/project", model);
	}

	@GetMapping("view/{id}")
	public ModelAndView view(ModelMap model, @PathVariable("id") Long id) throws IOException {

		long count = lectureService.count() + studentService.count() + leaderLectureService.count();
		model.addAttribute("count", count);
		Optional<Project> opt = projectService.findById(id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			project.setIsEdit(true);
			model.addAttribute("project", project);
			return new ModelAndView("common/lecproject/view", model);
		}
		model.addAttribute("message", "project không tồn tại");
		return new ModelAndView("redirect:/lecture/project", model);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("project") ProjectModel project,
			BindingResult result) {

		long count = lectureService.count() + studentService.count() + leaderLectureService.count();
		model.addAttribute("count", count);
		Project entity = new Project();
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("common/lecproject/addOrEdit");
		}
		BeanUtils.copyProperties(project, entity);
		projectService.save(entity);
		return new ModelAndView("redirect:/lecture/project", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

		// Tong mau tin trong category services

		int count = (int) projectService.count();
		int currentpage = page.orElse(1);
		int pageSize = size.orElse(3); // load len 3 mau tin

		Pageable pageable = PageRequest.of(currentpage - 1, pageSize, Sort.by("id"));

		Page<Project> resultPage = null;

		if (StringUtils.hasText(name)) {
			resultPage = projectService.findByNameContaining(name, pageable);

			model.addAttribute("name", name);
		} else {
			resultPage = projectService.findAll(pageable);
		}

		int totalPages = resultPage.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(1, currentpage - 2);
			int end = Math.min(currentpage + 2, totalPages);
			if (totalPages > count) {
				if (end == totalPages) {
					start = end - count;
				} else if (start == 1)
					end = start + count;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);

		}

		model.addAttribute("projectPage", resultPage);
		return "common/lecproject/search";

	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		projectService.deleteById(id);
		return new ModelAndView("redirect:/lecture/project", model);
	}

	@GetMapping("/danhGia/{id}")
	public ModelAndView edit1(ModelMap model, @PathVariable("id") Long id) throws IOException {
		long count = lectureService.count() + studentService.count() + leaderLectureService.count();
		model.addAttribute("count", count);

		Optional<Project> opt = projectService.findById(id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			project.setIsEdit(true);
			model.addAttribute("project", project);
			return new ModelAndView("common/lecproject/addOrEdit", model);
		}
		model.addAttribute("message", "project không tồn tại");
		return new ModelAndView("redirect:/lecutre/project/rate", model);
	}
	@GetMapping("rate")
	public ModelAndView rate(ModelMap model) {
		long count = lectureService.count() + studentService.count() + leaderLectureService.count();
		model.addAttribute("count", count);
		List<Project> project = projectService.findAll();
		model.addAttribute("project", project);
		return new ModelAndView("common/lecproject/ratelistproject", model);
	}

}
