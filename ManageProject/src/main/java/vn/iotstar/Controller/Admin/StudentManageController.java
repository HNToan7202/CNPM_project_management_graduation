package vn.iotstar.Controller.Admin;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Student;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Service.IStudentService;

@Controller
@RequestMapping("/admin/student")
public class StudentManageController {

	@Autowired
	IStudentService studentService;

	@Autowired
	ServletContext application;
	
	@GetMapping("list")
	public String ListDS() {
		return "admin/add/Student";
	}
	@GetMapping("logintest")
	public String login() {
		return "common/login";
	}
	@GetMapping("add")
	public String add(Model model) {
		StudentModel student = new StudentModel();
		student.setIsEdit(false);
		model.addAttribute("student", student);
		return "admin/AddTaiKhoan/SinhVien/SinhVien";
	}

	@GetMapping("edit/{mssv}")
	public ModelAndView edit(ModelMap model, @PathVariable("mssv") int MSSV) throws IOException {
		Optional<Student> opt = studentService.findById(MSSV);
		StudentModel student = new StudentModel();
		if (opt.isPresent()) {
			Student entity = opt.get();
			BeanUtils.copyProperties(entity, student);
			student.setIsEdit(true);
			student.setImage(entity.getImage());
			model.addAttribute("student", student);
			return new ModelAndView("admin/AccountManagement/SinhVien/edit", model);
		}
		model.addAttribute("error", "Student không tồn tại");
		return new ModelAndView("forward:/admin/student", model);

	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("student") StudentModel student,
			BindingResult result) {
		Student entity = new Student();
		

		/*
		 * if (result.hasErrors()) { model.addAttribute("message", "Có lỗi"); return new
		 * ModelAndView("admin/student/addOrEdit"); }
		 */
		
		if (!student.getImageFile().isEmpty()) {
			String path = application.getRealPath("/");

			try {
				student.setImage(student.getImageFile().getOriginalFilename());
				String filePath = path + "/resources/images/" + student.getImage();
				student.getImageFile().transferTo(Path.of(filePath));
				student.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		BeanUtils.copyProperties(student, entity);
		entity.setMssv(student.getMssv());
		entity.setIdproject((long) 0);
		entity.setIsleader(false); 
		entity.setWaitproject((long) 0);
		entity.setXoaproject((long) 0);
		studentService.save(entity);
		return new ModelAndView("redirect:/admin/addAccount/"+student.getMssv()+"/2", model);
	}
	
	@RequestMapping("saveofUpdate1")
	public ModelAndView saveOrUpdate1(ModelMap model, @Valid @ModelAttribute("student") StudentModel student,
			BindingResult result) {
		Student entity = new Student();
		

		/*
		 * if (result.hasErrors()) { model.addAttribute("message", "Có lỗi"); return new
		 * ModelAndView("admin/student/addOrEdit"); }
		 */
		
		if (!student.getImageFile().isEmpty()) {
			String path = application.getRealPath("/");

			try {
				student.setImage(student.getImageFile().getOriginalFilename());
				String filePath = path + "/resources/images/" + student.getImage();
				student.getImageFile().transferTo(Path.of(filePath));
				student.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		BeanUtils.copyProperties(student, entity);
		entity.setMssv(student.getMssv());
		entity.setIdproject((long) 0);
		entity.setIsleader(false); 
		entity.setWaitproject((long) 0);
		entity.setXoaproject((long) 0);
		studentService.save(entity);
		model.addAttribute("message", "Cập nhật thông tài khoản " +student.getEmail() + " thành công");
		return new ModelAndView("redirect:/admin/student", model);
	}

	/*
	 * @GetMapping("") public String list(ModelMap model,@RequestParam("p")
	 * Optional<Integer> p) { Pageable pageable = PageRequest.of(p.orElse(0), 3);
	 * Page<Student> page = studentService.findAll(pageable);
	 * model.addAttribute("students", page); return "admin/student/list"; }
	 */
	@GetMapping("")
	public String list(ModelMap model) {
		List<Student> page = studentService.findAll();
		model.addAttribute("students", page);
		
		return "admin/AccountManagement/SinhVien/list";
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		List<Student> list = null;
		if (StringUtils.hasText(name))
			list = studentService.findByNameContaining(name);
		else
			list = studentService.findAll();

		model.addAttribute("students", list);
		return "admin/student/search";
	}

	

	@GetMapping("delete/{mssv}")
	public ModelAndView delete(ModelMap model, @PathVariable("mssv") int MSSV) {
		studentService.deleteById(MSSV);
		model.addAttribute("message", "Đã xóa sinh viên này");
		return new ModelAndView("forward:/admin/student", model);
	}
}
