package vn.iotstar.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Account;
import vn.iotstar.Entity.Admin;
import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Student;
import vn.iotstar.Model.AdminLoginModel;
import vn.iotstar.Service.IAccountService;
import vn.iotstar.Service.IAdminService;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.IStudentService;

@Controller
public class LoginController {
	@Autowired
	private IAccountService accountService;

	@Autowired
	private IAdminService adminService;

	@Autowired
	private ILectureService lectureService;

	@Autowired
	private IStudentService studentSerivce;

	@Autowired
	private HttpSession session;

	@GetMapping("login")
	public String login(ModelMap model) {
		model.addAttribute("account", new AdminLoginModel());
		return "/common/demologin";
	}

	@GetMapping("")
	public String home(ModelMap model) {
		model.addAttribute("account", new AdminLoginModel());
		return "/common/demologin";
	}

	@PostMapping("login")
	public ModelAndView login(ModelMap model, @Valid @ModelAttribute("account") AdminLoginModel loginmodel,
			BindingResult result) {
		/*
		 * if (result.hasErrors()) { model.addAttribute("message","loi"); return new
		 * ModelAndView("common/demologin", model); }
		 */
		Account account = accountService.login(loginmodel.getEmail(), loginmodel.getPassword());
		if (account == null) {
			model.addAttribute("message", "Tài khoản hoặc mật khẩu không chính xác");
			return new ModelAndView("common/demologin", model);
		}
		session.setAttribute("email", account.getEmail());
		String email = account.getEmail();
		Admin admin = adminService.findByEmailContaining(email);
		Student student = studentSerivce.findByEmailContaining(email);
		Lecture lecture = lectureService.findByEmailContaining(email);

		if (admin != null) {

			model.addAttribute("user", admin);
			return new ModelAndView("redirect:/account", model);
		} else if (student != null) {
			model.addAttribute("user", student);
			return new ModelAndView("redirect:/student/home", model);
		} else if (lecture != null) {
			model.addAttribute("user", lecture);
			return new ModelAndView("redirect:/lecture/home", model);
		} else {
			model.addAttribute("user", lecture);
			return new ModelAndView("redirect:/leaderlecture/home", model);
		}
	}

	@RequestMapping("logout")
	public String logout(HttpSession sesson) {
		sesson.removeAttribute("email");
		return "/common/demologin";
	}
}
