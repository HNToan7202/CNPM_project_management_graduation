package vn.iotstar.Controller.Admin;

import java.io.IOException;
import java.sql.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestParam;
import vn.iotstar.Entity.Timeresgiter;
import vn.iotstar.Model.TimeResgiterModel;
import vn.iotstar.Service.ITimeResgiterSerivce;

@Controller
@RequestMapping("/admin/project/time")
public class ProjectManageController {

	/*
	 * @Autowired IProjectService projectService;
	 * 
	 * @GetMapping("") public String list(ModelMap model) { List<Project> project =
	 * projectService.findAll(); model.addAttribute("project", project); return
	 * "admin/project/list"; }
	 * 
	 * @GetMapping("add") public String add(ModelMap model) { ProjectModel proj =
	 * new ProjectModel(); proj.setIsEdit(false); model.addAttribute("project",
	 * proj);
	 * 
	 * return "admin/project/addOrEdit";
	 * 
	 * }
	 * 
	 * @PostMapping("saveOrUpdate") public ModelAndView saveOrUpdate(ModelMap
	 * model, @Valid @ModelAttribute("project") ProjectModel proj, BindingResult
	 * result) // Tra ve chuoi result {
	 * 
	 * String message = "Error Khong The Them"; if (result.hasErrors()) {
	 * 
	 * model.addAttribute("message", message); return new
	 * ModelAndView("admin/project/addOrEdit"); } Project entity = new Project();
	 * 
	 * BeanUtils.copyProperties(proj, entity); // do du lieu tu model sang entity
	 * 
	 * projectService.save(entity);
	 * 
	 * if (proj.getIsEdit() == true) { message = "Project Update succesfull !"; }
	 * else { message = "Project Create Successfull !"; }
	 * 
	 * model.addAttribute("message", message); return new
	 * ModelAndView("redirect:/admin/project", model);
	 * 
	 * }
	 * 
	 * @GetMapping("delete/{id}") public ModelAndView delete(ModelMap
	 * model, @PathVariable("id") Long id) { projectService.deleteById(id); return
	 * new ModelAndView("redirect:/admin/project", model); }
	 * 
	 * @GetMapping("edit/{id}") public ModelAndView edit(ModelMap
	 * model,@PathVariable("id") Long id){ Optional<Project> opt =
	 * projectService.findById(id); ProjectModel proj = new ProjectModel(); if
	 * (opt.isPresent()) { Project entity = opt.get();
	 * BeanUtils.copyProperties(entity, proj); proj.setIsEdit(true);
	 * model.addAttribute("project", proj); return new
	 * ModelAndView("admin/project/addOrEdit", model); }
	 * model.addAttribute("message", "Project không tồn tại"); return new
	 * ModelAndView("redirect:/admin/project", model);
	 * 
	 * }
	 * 
	 * }
	 */

	@Autowired
	private ITimeResgiterSerivce timeResgiterService;

	@GetMapping("add")
	private String add() {
		return "admin/project/addOrUpdate";
	}

	@GetMapping("")
	public String list(ModelMap model) {
		List<Timeresgiter> times = timeResgiterService.findAll();
		model.addAttribute("timeresgiter", times);
		return "admin/project/list";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @RequestParam("create_at") Date createAt,
			@RequestParam("finish_at") Date finishAt, @RequestParam(value = "id", required = false) Long id) {
		if (id == null) {
			Timeresgiter entity = new Timeresgiter(createAt, finishAt);
			timeResgiterService.save(entity);
		} else {
			Optional<Timeresgiter> opt = timeResgiterService.findById(id);
			if (opt.isPresent()) {
				Timeresgiter entity = opt.get();
				entity.setCreate_at(createAt);
				entity.setFinish_at(finishAt);
				timeResgiterService.save(entity);
			}
		}
		return new ModelAndView("redirect:/admin/project/time", model);
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long MSSV) {
		timeResgiterService.deleteById(MSSV);
		return new ModelAndView("redirect:/admin/project/time", model);
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) throws IOException {
		Optional<Timeresgiter> opt = timeResgiterService.findById(id);
		TimeResgiterModel time = new TimeResgiterModel();
		if (opt.isPresent()) {
			Timeresgiter entity = opt.get();
			BeanUtils.copyProperties(entity, time);
			time.setIsEdit(true);
			model.addAttribute("create_at", time.getCreate_at());
			model.addAttribute("finish_at", time.getFinish_at());
			model.addAttribute("id", time.getId());
			return new ModelAndView("admin/project/addOrUpdate", model);
		}
		model.addAttribute("message", "account không tồn tại");
		return new ModelAndView("redirect:/admin/project/time", model);

	}
}
