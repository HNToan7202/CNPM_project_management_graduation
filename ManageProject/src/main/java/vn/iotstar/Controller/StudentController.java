package vn.iotstar.Controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
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
		if (idproject == 0) {
			model.addAttribute("message", "Bạn chưa đăng ký đề tài");
		} else {
			List<Student> list = studentService.findByIdproject(idproject);
			model.addAttribute("list", list);
		}

		return "student/group";
	}

	@GetMapping("/project")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name, HttpSession sesson,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		String email = (String) sesson.getValue("email");
		Student entity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(entity, student);
		model.addAttribute("user", student);
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
		return "student/project";

	}

	@SuppressWarnings("deprecation")
	@GetMapping("project/dangky/{id}")
	public ModelAndView ProjectResgiter(ModelMap model, HttpSession sesson, @PathVariable("id") Long id) {
		String email = (String) sesson.getValue("email");
		Student entity = studentService.findByEmailContaining(email);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(entity, student);
		model.addAttribute("user", student);

		int id1 = id.intValue();
		Project projectentity = projectService.getById(id);

		List<Student> studentlist = studentService.findByIdproject(id1);

		System.out.print(studentlist.size());
		System.out.print(projectentity.getSoluongsv());
		if (studentlist.size() < projectentity.getSoluongsv()) {

			int idproject = entity.getIdproject();
			if (idproject == 0) {
				if (studentlist.size() == 0) {
					entity.setIsleader(true);
				} else {
					entity.setIsleader(false);
				}
				entity.setIdproject((id1));
				model.addAttribute("message", "Đã đăng ký thành công");
			}else {
				model.addAttribute("message", "Bạn đã đăng ký đề tài trước đó");
			}
		}else {

			model.addAttribute("message", "Số lượng thành viên đã đủ");
		}

		return new ModelAndView("forward:/student/project/resgiter", model);
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
			List<Student> studentlist = studentService.findByIdproject(id.intValue());
			model.addAttribute("sldk", studentlist.size());
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
			model.addAttribute("id", student.getIdproject());
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
			Date create = time.getCreateat();
			Date finish = time.getFinishat();
			Date getDate = new Date();
			model.addAttribute("create_date", create);
			model.addAttribute("finish_date", finish);
			model.addAttribute("getdate", getDate);
		}
		List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("lectures", lectures);
		List<Project> project = projectService.findAll();
		model.addAttribute("projects", project);
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

	@GetMapping("deletegroup/{mssv}")
	public ModelAndView edit(ModelMap model, @PathVariable("mssv") Long MSSV) throws IOException {
		Optional<Student> opt = studentService.findById(MSSV);
		if (opt.isPresent()) {
			Student entity = opt.get();
			entity.setIdproject(0);
			studentService.save(entity);
			model.addAttribute("message", "Xóa thành viên thành công");
			return new ModelAndView("forward:/student/group", model);
		}
		model.addAttribute("message", "Thành viên này không thể xóa");
		return new ModelAndView("forward:/student/group", model);

	}
}
