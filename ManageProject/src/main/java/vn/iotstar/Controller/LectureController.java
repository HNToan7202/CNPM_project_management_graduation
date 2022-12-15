
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Notification;
import vn.iotstar.Model.LectureModel;
import vn.iotstar.Model.NotificationModel;
import vn.iotstar.Service.ILeaderLectureService;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.INotificationService;
import vn.iotstar.Service.IStudentService;

@Controller

@RequestMapping("/lecture")
public class LectureController {

	@Autowired
	ILectureService lectureService;

	@Autowired
	INotificationService notificationService;

	@Autowired
	IStudentService studentService;

	@Autowired
	ILeaderLectureService leaderLectureService;

	@RequestMapping("profile")
	public String profile(ModelMap model, HttpSession sesson) {
		
		long count = lectureService.count() + studentService.count() + leaderLectureService.count();
		model.addAttribute("count", count);
		
		String email = (String) sesson.getValue("email");
		Lecture lecture = (Lecture) lectureService.findByEmailContaining(email);
		model.addAttribute("user", lecture);
		return "/lecture/profile";
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

		long count = lectureService.count() + studentService.count() + leaderLectureService.count();
		model.addAttribute("count", count);

		return new ModelAndView("lecture/home", model);

	}

	@GetMapping("/notify/{id}")
	public String seachnotify(ModelMap model, @PathVariable("id") Long id, HttpSession sesson) {
		
		long count = lectureService.count() + studentService.count() + leaderLectureService.count();
		model.addAttribute("count", count);
		
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