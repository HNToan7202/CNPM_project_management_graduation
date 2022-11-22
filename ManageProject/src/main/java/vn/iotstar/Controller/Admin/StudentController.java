package vn.iotstar.Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.iotstar.Entity.Student;
import vn.iotstar.Service.IStudentService;
import vn.iotstar.Utils.Constant;
import vn.iotstar.Utils.UploadUtils;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

	@Autowired
	IStudentService studentService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		return "admin/student/addorEdit";
	}

	@GetMapping("edit/{mssv}")
	public String edit(Model model) {
		
		Student student = studentService.findById();
		model.addAttribute("student", student);
		return "admin/student/addorEdit";
	}

	@GetMapping("delete/{mssv}")
	public String delete() {
		return "redirect:/admin/student";
	}

	@PostMapping("saveofUpdate")
	public String saveOrUpdate(ModelMap model,@RequestParam("image") MultipartFile image) {
		Student entity = new Student();
		if(image.isEmpty())
		{
			model.addAttribute("message", "Vui lòng chọn file");
		}
		else {
			try {
				String path = Context.getRealPath("/image"+image.getOriginalFilename());
				image.transferTo(new File(path));
				
			}
		}

		return "redirect:/admin/student";
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
