package vn.iotstar.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import vn.iotstar.Entity.Account;
import vn.iotstar.Entity.Role;
import vn.iotstar.Model.AccountModel;
import vn.iotstar.Service.IAccountService;
import vn.iotstar.Service.IRoleService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	IAccountService accountService;

	@Autowired
	IRoleService roleService;

	@Autowired
	ServletContext application;

	@GetMapping("add")
	public String add(Model model) {
		AccountModel account = new AccountModel();
		model.addAttribute("account", account);
		return "common/account/addOrEdit";
	}

	// đổ dữ liệu vào combobox
	@ModelAttribute("roles")
	public List<Role> getRoles() {
		List<Role> roles = roleService.findAll();
		return roles;
	}

	@GetMapping("edit/{email}")
	public ModelAndView edit(ModelMap model, @PathVariable("email") String email) throws IOException {
		Optional<Account> opt = accountService.findById(email);
		AccountModel account = new AccountModel();
		if (opt.isPresent()) {
			Account entity = opt.get();
			BeanUtils.copyProperties(entity, account);
			account.setIsEdit(true);
			model.addAttribute("account", account);
			return new ModelAndView("common/account/addOrEdit", model);
		}
		model.addAttribute("message", "account không tồn tại");
		return new ModelAndView("redirect:/account", model);

	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("account") AccountModel account,
			BindingResult result) {
		Account entity = new Account();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("common/account/addOrEdit");
		}
		BeanUtils.copyProperties(account, entity);
		accountService.save(entity);
		return new ModelAndView("redirect:/account", model);
	}

	@GetMapping("")
	public String list(ModelMap model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
		Page<Account> page = accountService.findAll(pageable);
		model.addAttribute("accounts", page);
		return "common/account/list";
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "email", required = false) String email) {
		Optional<Account> entity = null;
		if (StringUtils.hasText(email))
			entity = accountService.findById(email);
		model.addAttribute("account", entity);
		return "admin/account/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") String id) {
		accountService.deleteById(id);
		return new ModelAndView("redirect:/account", model);
	}
}
