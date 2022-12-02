package vn.iotstar.Controller;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Notification;
import vn.iotstar.Entity.Project;
import vn.iotstar.Entity.Student;
import vn.iotstar.Entity.Timeresgiter;
import vn.iotstar.Entity.Account;
import vn.iotstar.Model.NotificationModel;
import vn.iotstar.Model.ProjectModel;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Model.TimeResgiterModel;
import vn.iotstar.Service.IAccountService;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.INotificationService;
import vn.iotstar.Service.IProjectService;
import vn.iotstar.Service.IStudentService;
import vn.iotstar.Service.ITimeResgiterSerivce;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	INotificationService notificationService;

	@Autowired
	IStudentService studentService;

	@Autowired
	IAccountService accountSerivce;

	@Autowired
	ServletContext application;

	@Autowired
	IProjectService projectService;

	@Autowired
	ILectureService lectureService;

	@Autowired
	ITimeResgiterSerivce timeResgiterService;

	@GetMapping("/home")
	public ModelAndView List(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Student studententity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(studententity, student);
		model.addAttribute("user", student);
		List<Notification> notifies = notificationService.findAll();
		model.addAttribute("notifies", notifies);
		return new ModelAndView("student/home", model);
	}

	@GetMapping("/notify/{id}")
	public String seachnotify(ModelMap model, @PathVariable("id") Long id, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Student studententity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
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
		return "student/notify";

	}

	@GetMapping("/information/{id}")
	public ModelAndView Inf(ModelMap model, @PathVariable("id") Long MSSV, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Student studententity = studentService.findByEmailContaining(email);
		StudentModel student1 = new StudentModel();
		BeanUtils.copyProperties(studententity, student1);
		model.addAttribute("user", student1);
		Optional<Student> opt = studentService.findById(MSSV);
		StudentModel student = new StudentModel();
		if (opt.isPresent()) {
			Student entity = opt.get();
			BeanUtils.copyProperties(entity, student);
			student.setIsEdit(true);
			model.addAttribute("student", student);
			return new ModelAndView("student/inf", model);
		}
		model.addAttribute("message", "Student không tồn tại");
		return new ModelAndView("redirect:/student", model);
	}

	@SuppressWarnings("deprecation")
	@GetMapping("/profile")
	public String Profile(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Student entity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(entity, student);
		model.addAttribute("user", student);
		return "student/profile";
	}

	@SuppressWarnings("deprecation")
	@GetMapping("/detail/{mssv}")
	public String Profile(ModelMap model, HttpSession sesson, @PathVariable("mssv") Long MSSV) {
		/*
		 * String email = (String) sesson.getValue("email"); Student entity =
		 * studentService.findByEmailContaining(email); StudentModel student = new
		 * StudentModel(); BeanUtils.copyProperties(entity, student);
		 * model.addAttribute("user", student);
		 */

		Student stu = studentService.getById(MSSV);
		model.addAttribute("user", stu);

		return "student/yourProfile";
	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("student") StudentModel student,
			BindingResult result) {
		Student entity = new Student();

		/*
		 * if (result.hasErrors()) { model.addAttribute("message", "Có lỗi"); return new
		 * ModelAndView("redirect:/student/profile", model); }
		 */
		if (!student.getImageFile().isEmpty()) {
			String path = application.getRealPath("/");

			try {
				student.setImage(student.getImageFile().getOriginalFilename());
				String filePath = path + "/resources/images/" + student.getImage();
				student.getImageFile().transferTo(Path.of(filePath));
				student.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		BeanUtils.copyProperties(student, entity);
		studentService.save(entity);
		return new ModelAndView("redirect:/student/profile", model);

	}

	@SuppressWarnings("deprecation")
	@GetMapping("group")
	public String Group(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Student entity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(entity, student);
		model.addAttribute("user", student);
		int idproject = entity.getIdproject();
		List<Student> list = studentService.findAll();
		model.addAttribute("list", list);

		return "student/group";
	}

	@GetMapping("/project")
	public String Project(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Student entity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(entity, student);
		model.addAttribute("user", student);
		List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("lectures", lectures);
		List<Project> project = projectService.findAll();
		model.addAttribute("project", project);
		return "student/project";
	}

	@SuppressWarnings("deprecation")
	@GetMapping("project/detail/{id}")
	public ModelAndView Detail(ModelMap model, HttpSession sesson, @PathVariable("id") Long id) {
		String email = (String) sesson.getValue("email");
		Student studententity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(studententity, student);
		model.addAttribute("user", student);

		Optional<Project> opt = projectService.findById(id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			student.setIsEdit(false);
			model.addAttribute("project", project);
			return new ModelAndView("student/projectDetail", model);
		}
		return new ModelAndView("student/projectDetail", model);
	}

	@GetMapping("project/my/{id}")
	public ModelAndView myProject(ModelMap model, HttpSession sesson, @PathVariable("id") Long id) {
		String email = (String) sesson.getValue("email");
		Student studententity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(studententity, student);
		model.addAttribute("user", student);

		Optional<Project> opt = projectService.findById(id);
		ProjectModel project = new ProjectModel();
		if (opt.isPresent()) {
			Project entity = opt.get();
			BeanUtils.copyProperties(entity, project);
			student.setIsEdit(false);
			model.addAttribute("project", project);
			return new ModelAndView("student/myProject", model);
		}
		return new ModelAndView("student/myProject", model);
	}

	@GetMapping("project/resgiter")
	public String ResgiterProje(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Student studententity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(studententity, student);
		model.addAttribute("user", student);

		Optional<Timeresgiter> opt = timeResgiterService.findById((long) 1);
		if (opt.isPresent()) {
			Timeresgiter time = opt.get();
			Date create = time.getCreate_at();
			Date finish = time.getFinish_at();
			Date getDate = new Date();
			model.addAttribute("create_date", create);
			model.addAttribute("finish_date", finish);
			model.addAttribute("getdate", getDate);
		}
		return "student/projectResgiter";

	}

	@GetMapping("account")
	public String AccountStudent(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Student studententity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(studententity, student);
		model.addAttribute("user", student);
		return "student/account";
	}

	@PostMapping("account")
	public ModelAndView ProjectResgiter(ModelMap model, HttpSession sesson,
			@RequestParam(name = "password", required = false) String password,
			@RequestParam(name = "mewpassword", required = false) String mewpassword) {
		String email = (String) sesson.getValue("email");
		Account account = accountSerivce.login(email, password);
		if (account == null) {
			model.addAttribute("message", "Mật khẩu không chính xác");
			return new ModelAndView("student/account", model);
		}
		Account acc = account;
		acc.setPassword(mewpassword);
		accountSerivce.save(acc);
		model.addAttribute("message", "Mật khẩu đã được cập nhật");
		return new ModelAndView("student/account", model);
	}
}