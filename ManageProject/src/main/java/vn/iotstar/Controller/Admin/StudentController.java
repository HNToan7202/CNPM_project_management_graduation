package vn.iotstar.Controller.Admin;

import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Student;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Service.IStudentService;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

	@Autowired
	IStudentService studentService;

	@Autowired
	ServletContext application;

	@GetMapping("add")
	public String add(Model model) {
		StudentModel student = new StudentModel();
		student.setIsEdit(false);
		model.addAttribute("student", student);
		return "admin/student/addOrEdit";
	}

	@GetMapping("edit/{mssv}")
	public String edit(Model model) {
		return null;

		/*
		 * Student student = studentService.findById(); model.addAttribute("student",
		 * student); return "admin/student/addorEdit";
		 */
	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("student") StudentModel student,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("admin/student/addOrEdit");
		}
		if (!student.getImageFile().isEmpty()) {
			String path = application.getRealPath("/");
			Student entity = new Student();
			try {
				student.setImage(student.getImageFile().getOriginalFilename());
				String filePath = path + "/resources/images/" + student.getImage();
				student.getImageFile().transferTo(Path.of(filePath));
				student.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			BeanUtils.copyProperties(student, entity);
			studentService.save(entity);
		}
		return new ModelAndView("redirect:/admin/student", model);
	}

	@GetMapping("")
	public String list(ModelMap model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "admin/student/list";
	}

	@GetMapping("search")
	public String search() {
		return "admin/student/search";
	}
}
