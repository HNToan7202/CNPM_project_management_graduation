package vn.iotstar.Controller.Admin;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

import vn.iotstar.Entity.Project;
import vn.iotstar.Entity.Timeresgiter;
import vn.iotstar.Model.TimeResgiterModel;
import vn.iotstar.Service.IProjectService;
import vn.iotstar.Service.ITimeResgiterSerivce;

@Controller
@RequestMapping("/admin/project/time")
public class ProjectManageController {

	@Autowired
	private ITimeResgiterSerivce timeResgiterService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private ITimeResgiterSerivce timeResgiterSerivce;
	@GetMapping("add")
	private String add() {
		return "admin/project/addOrUpdate";
	}
	@GetMapping("")
	public ModelAndView List(ModelMap model) {
		List<Project> project = projectService.findAll();
		model.addAttribute("project", project);
		return new ModelAndView("admin/MoDK/list", model);
	}

	@GetMapping("list")
	public String list(ModelMap model) {
		List<Timeresgiter> times = timeResgiterService.findAll();
		model.addAttribute("timeresgiter", times);
		return "admin/timeResgiter/list";
	}
	@GetMapping("MDK/{id}")
	public ModelAndView Modksv(ModelMap model,@PathVariable("id") Long id) {
		Project p =projectService.findById(id).get();
		p.setIs_active(1);
		projectService.save(p);
		return new ModelAndView("redirect:/admin/project/time", model);
	}
	@GetMapping("DDK/{id}")
	public ModelAndView Dongdksv(ModelMap model,@PathVariable("id") Long id) {
		Project p =projectService.findById(id).get();
		p.setIs_active(0);
		projectService.save(p);
		return new ModelAndView("redirect:/admin/project/time", model);
	}
	@RequestMapping("MDKk")
	public ModelAndView Modksvgv(ModelMap model) {
		model.addAttribute("message", "Đã mở");
		return new ModelAndView("admin/MoDK/gv", model);
	}
	@RequestMapping("DDKk")
	public ModelAndView Dongdksvgv(ModelMap model) {
		model.addAttribute("message", "Đã đóng");
		return new ModelAndView("admin/MoDK/gv", model);
	}
	@GetMapping("DKGV")
	private String DKGV() {
		return "admin/MoDK/gv";
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
