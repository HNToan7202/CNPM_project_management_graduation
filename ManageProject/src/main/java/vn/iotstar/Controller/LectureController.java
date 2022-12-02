
package vn.iotstar.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Service.ILectureService;

@Controller

@RequestMapping("/lecture")
public class LectureController {
	
	@Autowired
	ILectureService lectureService;
	
	@RequestMapping("profile")
	public String profile(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Lecture lecture = (Lecture) lectureService.findByEmailContaining(email);
		model.addAttribute("user", lecture);
		return "/lecture/profile";
	}
	
}