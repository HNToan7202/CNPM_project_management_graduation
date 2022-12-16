package vn.iotstar.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Notification;
import vn.iotstar.Entity.Student;
import vn.iotstar.Model.NotificationModel;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.INotificationService;
import vn.iotstar.Service.IStudentService;

@Controller
public class HomeControllerGuest {

	@Autowired
	IStudentService studentService;

	@Autowired
	ILectureService lectureService;

	@Autowired
	INotificationService noticationService;

	@GetMapping("")
	public String home(ModelMap model) {
		List<Notification> notifications = noticationService.findByChosv(true);
		model.addAttribute("notifications", notifications);
		return "/common/home";
	}

	@GetMapping("/notify/{id}")
	public String seachnotify(ModelMap model, @PathVariable("id") Integer id, HttpSession sesson) {

		Optional<Notification> opt = noticationService.findById(((long) id));
		NotificationModel notify = new NotificationModel();
		if (opt.isPresent()) {
			Notification entity = opt.get();
			BeanUtils.copyProperties(entity, notify);
			notify.setIsEdit(false);
		}
		model.addAttribute("notify", notify);
		return "student/notify";

	}

	@GetMapping("liststudent")
	public String list(ModelMap model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("list", students);
		return "student/list";
	}

	@GetMapping("listlecture")
	public String listlecture(ModelMap model) {
		List<Lecture> lectures = lectureService.findAll();
		model.addAttribute("list", lectures);
		return "student/listlecture";
	}

	@GetMapping("detail/{mssv}")
	public String Profile(ModelMap model, HttpSession sesson, @PathVariable("mssv") Integer MSSV) {
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
}
