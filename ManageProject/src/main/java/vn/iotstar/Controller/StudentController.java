package vn.iotstar.Controller;

import java.nio.file.Path;
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
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Notification;
import vn.iotstar.Entity.Student;
import vn.iotstar.Model.NotificationModel;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Service.INotificationService;
import vn.iotstar.Service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	INotificationService notificationService;

	@Autowired
	IStudentService studentService;

	@Autowired
	ServletContext application;

	@GetMapping("/home")
	public ModelAndView List(ModelMap model) {
		List<Notification> notifies = notificationService.findAll();
		model.addAttribute("notifies", notifies);
		return new ModelAndView("student/home", model);
	}

	@GetMapping("/notify/{id}")
	public String seachnotify(ModelMap model, @PathVariable("id") Long id) {
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
	public ModelAndView Inf(ModelMap model, @PathVariable("mssv") Long MSSV) {
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
		return "student/group";
	}
}
