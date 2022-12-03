package vn.iotstar.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@RequestMapping("/admin/test")

public class HomeController {
	@RequestMapping("")
	public String home(Model model) {
		return "Home/admin";
	}
	@RequestMapping("GV")
	public String ST(Model model) {
		return "admin/edit/GiangVien";
	}
	@RequestMapping("addGV")
	public String addGV(Model model) {
		return "admin/lecture/add";
	}
	@RequestMapping("addST")
	public String addST(Model model) {
		return "admin/student/add";
	}
	@RequestMapping("addTBM")
	public String addTBM(Model model) {
		return "admin/leaderLecture/add";
	}
	
	@RequestMapping("listGV")
	public String listGV(Model model) {
		return "admin/lecture/list_admin";
	}
	@RequestMapping("listST")
	public String listST(Model model) {
		return "admin/student/list_admin";
	}
	@RequestMapping("listTBM")
	public String list(Model model) {
		return "admin/leaderLecture/list";
	}
	@RequestMapping("listTGDK")
	public String listTgDK(Model model) {
		return "admin/timeResgiter/list";
	}
	
	@RequestMapping("addinput")
	public String listTgDK1(Model model) {
		return "leaderLecture/council/addcouncil";
	}
}
