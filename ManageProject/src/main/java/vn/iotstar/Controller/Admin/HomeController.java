package vn.iotstar.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@RequestMapping("/admin/Home")

public class HomeController {
	@RequestMapping("")
	public String home(Model model) {
		return "admin/Home";
	}
	@RequestMapping("GV")
	public String ST(Model model) {
		return "admin/edit/GiangVien";
	}
	

}
