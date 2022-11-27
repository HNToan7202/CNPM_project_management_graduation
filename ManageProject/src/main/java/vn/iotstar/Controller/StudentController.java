package vn.iotstar.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("")
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

}
