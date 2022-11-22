package vn.iotstar.Controller.Admin;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Student;
import vn.iotstar.Service.IStudentService;
import vn.iotstar.ServiceImpl.StudentServiceImpl;
import vn.iotstar.Utils.Constant;
import vn.iotstar.Utils.UploadUtils;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

	private IStudentService studentService = new StudentServiceImpl();

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
		String fileName = entity.getImage()+ System.currentTimeMillis();
		//entity.setImages(UploadUtils.processUpload("images", request, Constant.DIR + "\\category\\", fileName));
		// gọi hàm insert để thêm dữ liệu
		studentService.save(entity);

		return new ModelAndView("redirect:/admin/student", model);
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
