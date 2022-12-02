
package vn.iotstar.Controller;

import java.util.List;

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
import vn.iotstar.Entity.Project;
import vn.iotstar.Entity.Student;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.IProjectService;
import vn.iotstar.Service.IStudentService;

@Controller

@RequestMapping("/lecture")
public class LectureController {

	@Autowired
	ILectureService lectureService;
	@Autowired
	IStudentService studentService;

	@Autowired
	IProjectService projectService;

	@RequestMapping("profile")
	public String profile(ModelMap model, HttpSession sesson) {
		String email = (String) sesson.getValue("email");
		Lecture lecture = (Lecture) lectureService.findByEmailContaining(email);
		model.addAttribute("user", lecture);
		return "/lecture/profile";
	}

}