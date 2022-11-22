package vn.iotstar.Controller.Admin;

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
	public String edit() {
		return "admin/student/addorEdit";
	}

	@GetMapping("delete/{mssv}")
	public String delete() {
		return "redirect:/admin/student";
	}

	@PostMapping("saveofUpdate")
	public String saveOrUpdate(HttpServletRequest req) {
		Student entity = new Student();
		try {
			BeanUtils.populate(entity, req.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = entity.getImage()+ System.currentTimeMillis();
		try {
			entity.setImage(UploadUtils.processUpload("image", req, Constant.DIR + "\\student\\", fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// gọi hàm insert để thêm dữ liệu
		studentService.save(entity);

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
