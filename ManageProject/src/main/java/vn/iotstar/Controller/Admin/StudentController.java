package vn.iotstar.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.Entity.Student;

@Controller
@RequestMapping("/admin/student")
public class StudentController {
	/*
	 * @GetMapping("add") public String add() { return "admin/student/addorEdit"; }
	 * 
	 * @GetMapping("edit/{mssv}") public String edit() { return
	 * "admin/student/addorEdit"; }
	 * 
	 * @GetMapping("edit/{mssv}") public String delete() { return
	 * "redirect:/admin/student/list"; }
	 * 
	 * @GetMapping("delete/{mssv}") public String saveOrUpdate() { return
	 * "redirect:/admin/student/list"; }
	 */
	@GetMapping("list")
	public String list() {
		return "admin/student/list";
	}
	public String search() {
		return "admin/student/search";
	}
}
