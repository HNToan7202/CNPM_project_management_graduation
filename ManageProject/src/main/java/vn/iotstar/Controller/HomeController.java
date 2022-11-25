package vn.iotstar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.Entity.Student;

@Controller
@RequestMapping("home")
public class HomeController {
	@GetMapping()
	public String list() {
		return "index";
	}

}
