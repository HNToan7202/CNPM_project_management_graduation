package vn.iotstar.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.iotstar.Entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping()
	public String add(ModelMap model) {
		
		return "student/index";
	}
}
