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
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Account;
import vn.iotstar.Model.AdminLoginModel;
import vn.iotstar.Service.IAccountService;

@Controller
public class LoginController {
	@Autowired
	private IAccountService accountService;

	@Autowired
	private HttpSession session;

	@GetMapping("login")
	public String login(ModelMap model) {
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

		// trả về trang trước đó
		Object ruri = session.getAttribute("redirect-uri");

		if (ruri != null) {
			session.removeAttribute("redirect-uri");
			return new ModelAndView("redirect:" + ruri);
		}

		return new ModelAndView("redirect:/account", model);
	}
}
