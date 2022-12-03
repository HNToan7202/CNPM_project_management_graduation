package vn.iotstar.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
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

import vn.iotstar.Entity.Council;
import vn.iotstar.Entity.LeaderLecture;
import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Notification;
import vn.iotstar.Entity.Project;
import vn.iotstar.Model.CouncilModel;
import vn.iotstar.Model.LectureModel;
import vn.iotstar.Model.NotificationModel;
import vn.iotstar.Model.ProjectModel;
import vn.iotstar.Repository.IProjectRepository;
import vn.iotstar.Service.ICouncilService;
import vn.iotstar.Service.ILeaderLectureService;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.INotificationService;
import vn.iotstar.Service.IProjectService;

@Controller

@RequestMapping("/leadlecture")
public class LeadLectureController {

	@Autowired
	ILeaderLectureService leaderLectureService;

	@Autowired
	IProjectService projectService;

	@Autowired
	ICouncilService councilService;

	@Autowired
	ILectureService lectureService;
	
	@Autowired 
	INotificationService notificationService;

	@RequestMapping("profile")
	public String profile(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		LeaderLecture lecture = (LeaderLecture) leaderLectureService.findByEmailContaining(email);
		model.addAttribute("user", lecture);
		return "/leaderLecture/profile";
	}

	@GetMapping("/dshoidong")
	public ModelAndView listHoiDong(ModelMap model) {
		List<Council> council = councilService.findAll();
		model.addAttribute("council", council);
		return new ModelAndView("common/leadlecture/listhoidong", model);
	}

	@GetMapping("/dshoidong/add")
	public String addHoiDong(ModelMap model) {
		CouncilModel council = new CouncilModel();
		council.setIsEdit(false);
		model.addAttribute("council", council);
		return "common/leadlecture/addOrEditHD";
	}

	@GetMapping("/project/view/{id}")
	public ModelAndView view(ModelMap model, @PathVariable("id") Long id) throws IOException {
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

	@GetMapping("/dshoidong/addGV/{id}")
	public ModelAndView addGV(ModelMap model, @PathVariable("id") int id) throws IOException {

		List<Lecture> lecture = lectureService.findAll();
		model.addAttribute("lecture", lecture);
		model.addAttribute("id", id);
		return new ModelAndView("common/leadlecture/listlecture", model);
	}

	@GetMapping("list")
	public ModelAndView List(ModelMap model) {
		List<Project> project = projectService.findAll();
		model.addAttribute("project", project);
		return new ModelAndView("common/leadlecture/listproject", model);
	}

	@PostMapping("/dshoidong/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("lecture") CouncilModel council,
			BindingResult result) {
		Council entity = new Council();
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("common/leadlecture/addOrEditHD");
		}
		BeanUtils.copyProperties(council, entity);
		councilService.save(entity);
		return new ModelAndView("redirect:/leadlecture/dshoidong", model);
	}

	@PostMapping("/project/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("project") ProjectModel project,
			BindingResult result) {
		Project entity = new Project();
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("common/leadlecture/addOrEdit");
		}
		BeanUtils.copyProperties(project, entity);
		projectService.save(entity);
		return new ModelAndView("redirect:/leadlecture/list", model);
	}

	@GetMapping("/project/edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) throws IOException {
		Optional<Project> opt = projectService.findById(id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			project.setIsEdit(true);
			model.addAttribute("project", project);
			return new ModelAndView("common/leadlecture/addOrEdit", model);
		}
		model.addAttribute("message", "project không tồn tại");
		return new ModelAndView("redirect:/leadlecture/list", model);
	}

	@GetMapping("/dshoidong/edit/{id}")
	public ModelAndView editGV(ModelMap model, @PathVariable("id") Long id) throws IOException {
		Optional<Project> opt = projectService.findById(id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			project.setIsEdit(true);
			model.addAttribute("project", project);
			return new ModelAndView("common/leadlecture/addOrEdit", model);
		}
		model.addAttribute("message", "project không tồn tại");
		return new ModelAndView("redirect:/leadlecture/list", model);
	}

	@GetMapping("/dshoidong/view/{idhoidong}")
	public ModelAndView viewCTHD(ModelMap model, @PathVariable("idhoidong") int id) throws IOException {
		// List<Lecture> lecture = lectureService.findByIdhoidongContaining(id);
		// model.addAttribute("lecture", lecture);

		// return new ModelAndView("common/leadlecture/listlecture", model);
		List<Lecture> lecture = lectureService.findAll();
		model.addAttribute("lecture", lecture);
		model.addAttribute("id", id);
		return new ModelAndView("common/leadlecture/listlecture", model);
	}

	@GetMapping("/home")
	public ModelAndView List(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Lecture studententity = lectureService.findByEmailContaining(email);
		LectureModel student = new LectureModel();
		BeanUtils.copyProperties(studententity, student);
		model.addAttribute("user", student);
		List<Notification> notifies = notificationService.findAll();
		model.addAttribute("notifies", notifies);
		return new ModelAndView("lecture/home", model);
	}

	@GetMapping("/notify/{id}")
	public String seachnotify(ModelMap model, @PathVariable("id") Long id, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Lecture studententity = lectureService.findByEmailContaining(email);
		LectureModel student = new LectureModel();
		BeanUtils.copyProperties(studententity, student);
		model.addAttribute("user", student);
		Optional<Notification> opt = notificationService.findById((id));
		NotificationModel notify = new NotificationModel();
		if (opt.isPresent()) {
			Notification entity = opt.get();
			BeanUtils.copyProperties(entity, notify);
			notify.setIsEdit(false);
		}
		model.addAttribute("notify", notify);
		return "lecture/notify";

	}
}
