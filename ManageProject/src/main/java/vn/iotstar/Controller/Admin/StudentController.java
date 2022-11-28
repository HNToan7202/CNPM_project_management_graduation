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
	public ModelAndView edit(ModelMap model, @PathVariable("mssv") Long MSSV) throws IOException {
		Optional<Student> opt = studentService.findById(MSSV);
		StudentModel student = new StudentModel();
		if (opt.isPresent()) {
			Student entity = opt.get();
			BeanUtils.copyProperties(entity, student);
			student.setIsEdit(true);
			model.addAttribute("student", student);
			return new ModelAndView("admin/student/addOrEdit", model);
		}
		model.addAttribute("message", "Student không tồn tại");
		return new ModelAndView("redirect:/admin/student", model);

	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("student") StudentModel student,
			BindingResult result) {
		Student entity = new Student();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("admin/student/addOrEdit");
		}
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
		studentService.save(entity);
		return new ModelAndView("redirect:/admin/student", model);
	}

	@GetMapping("")
	public String list(ModelMap model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
		Page<Student> page = studentService.findAll(pageable);
		model.addAttribute("students", page);
		return "admin/student/list";
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

	@GetMapping("search/paginated")
	public String pageable(ModelMap model, @RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "page") Optional<Integer> page,
			@RequestParam(name = "size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int sizePage = size.orElse(3);
		
		Pageable pageable = PageRequest.of(currentPage, sizePage,Sort.by("name"));
		Page<Student> resultPage = null;
		
		if (StringUtils.hasText(name)) {
			resultPage = studentService.findByNameContaining(name,pageable);
			model.addAttribute("name", name);
		}
		else
			resultPage = studentService.findAll(pageable);

		int totalPages = resultPage.getTotalPages();
		if (totalPages >0)
		{
			int start = Math.max(1, currentPage-2);
			int end = Math.min(currentPage+2, totalPages);
			
			if(totalPages >5) {
				if(end==totalPages)
					start =end-5;
				else if(start ==1) end=start+5;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers",pageNumbers);
		}
		model.addAttribute("studentPage", resultPage);
		return "admin/student/searchpage";
	}

	@GetMapping("delete/{mssv}")
	public ModelAndView delete(ModelMap model, @PathVariable("mssv") Long MSSV) {
		studentService.deleteById(MSSV);
		return new ModelAndView("redirect:/admin/student", model);
	}
}
