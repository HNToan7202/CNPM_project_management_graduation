package vn.iotstar.Controller.Admin;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import vn.iotstar.Entity.Student;
import vn.iotstar.ServiceImpl.StudentServiceImpl;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		return "admin/student/addorEdit";
	}

	@GetMapping("edit/{mssv}")
	public String edit() {
		return "admin/student/addorEdit";
	}

	@GetMapping("delete/{mssv}")
	public String delete() {
		return "redirect:/admin/student";
	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, Student stu) {
		Student entity = new Student();
		BeanUtils.copyProperties(stu, entity);
		studentService.save(entity);
		
		return new ModelAndView("redirect:/admin/student",model);
	}

	@GetMapping("")
	public String list(ModelMap model) {
		List<Student> list = studentService.findAll();
		model.addAttribute("students", list);
		return "admin/student/list";
	}
	@GetMapping("search")
	public String search() {
		return "admin/student/search";
	}
}
