package vn.iotstar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
	@GetMapping("/list")
	public String list() {
		return "index";
	}

}
