package vn.iotstar.Controller.Admin;

import java.util.List;

import javax.servlet.ServletContext;
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

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Project;
import vn.iotstar.Model.LectureModel;
import vn.iotstar.Model.ProjectModel;
import vn.iotstar.Service.ILectureService;


@Controller
@RequestMapping("/admin/lecture")

public class LectureManageController {
	
	@Autowired
	ILectureService lectureSerivce;
	
	@GetMapping("")
	public String list(ModelMap model) {
		List<Lecture> lecture = lectureSerivce.findAll();
		model.addAttribute("lecture", lecture);
		return "admin/lecture/list";
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		LectureModel lecture = new LectureModel();
		lecture.setIsEdit(false);
		model.addAttribute("lecture", lecture);

		return "admin/project/addOrEdit";

	}
	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		lectureSerivce.deleteById(id);
		return new ModelAndView("redirect:/admin/lecture", model);
	}
}

