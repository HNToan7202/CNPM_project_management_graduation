package vn.iotstar.Controller.Admin;


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
import vn.iotstar.Entity.LeaderLecture;
import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Role;
import vn.iotstar.Entity.Student;
import vn.iotstar.Model.AccountModel;
import vn.iotstar.Service.IAccountService;
import vn.iotstar.Service.ILeaderLectureService;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.IRoleService;
import vn.iotstar.Service.IStudentService;

@Controller
@RequestMapping("/admin/account")
public class AccountManageController {

	@Autowired
	IAccountService accountService;

	@Autowired
	IRoleService roleService;

	@Autowired
	ServletContext application;
	@Autowired
	ILectureService lectureSerivce;
	@Autowired
	IStudentService studentService;
	
	@Autowired
	ILeaderLectureService leaderLectureService;
	
	@GetMapping("add/{co}")
	public String add(Model model ,@PathVariable("co") int co) {
		AccountModel account = new AccountModel();
		account.setIsEdit(false);
		model.addAttribute("account", account);
		if(co==2) return "admin/account/lecture/addOrEdit";
		else if( co==4 )return "admin/account/student/addOrEdit";
		else return "admin/account/leaderLecture/addOrEdit";
	}
	@GetMapping("addhome")
	public String addhome(Model model ) {
		AccountModel account = new AccountModel();
		account.setIsEdit(false);
		model.addAttribute("account", account);
		
		return "admin/account/addOrEdit";
	}
	
	@GetMapping("listLecture")
	public String list(ModelMap model) {
		List<Lecture> lecture = lectureSerivce.findAll();
		List<Account> account = accountService.findAll();
		model.addAttribute("lecture", lecture);
		model.addAttribute("account", account);
		
		return "admin/account/lecture/lecture";
	}
	@GetMapping("listStudent")
	public String listST(ModelMap model) {
		List<Student> student = studentService.findAll();
		List<Account> account = accountService.findAll();
		model.addAttribute("student", student);
		model.addAttribute("account", account);
		return "admin/account/student/student";
	}
	@GetMapping("listLeaderLecture")
	public String listLeaderLecture(ModelMap model) {
		List<LeaderLecture> leaderLecture = leaderLectureService.findAll();
		List<Account> account = accountService.findAll();
		model.addAttribute("leaderLecture", leaderLecture);
		model.addAttribute("account", account);
		return "admin/account/leaderLecture/leaderLecture";
	}
	// đổ dữ liệu vào combobox
	@ModelAttribute("roles")
	public List<Role> getRoles() {
		List<Role> roles = roleService.findAll();
		return roles;
	}

	@GetMapping("edit/{email}/{co}")
	public ModelAndView edit(ModelMap model, @PathVariable("email") String email,@PathVariable("co") int co) throws IOException {
		Optional<Account> opt = accountService.findById(email);
		AccountModel account = new AccountModel();
		if (opt.isPresent()) {
			Account entity = opt.get();
			BeanUtils.copyProperties(entity, account);
			account.setIsEdit(true);
			model.addAttribute("account", account);
			//return new ModelAndView("common/account/addOrEdit", model);
			if(co==2) return new ModelAndView("admin/account/lecture/addOrEdit", model);
			else if( co==4 )return new ModelAndView("admin/account/student/addOrEdit", model);
			else return new ModelAndView("admin/account/leaderLecture/addOrEdit", model);
			
		}
		model.addAttribute("message", "account không tồn tại");
		if(co==2) return new ModelAndView("redirect:/admin/account/listLecture", model);
		else if( co==4 ) return new ModelAndView("redirect:/admin/account/listStudent", model);
		else  return new ModelAndView("redirect:/admin/account/listLeaderLecture", model);
		

	}

	@RequestMapping("saveofUpdate/{co}")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("account") AccountModel account,
			BindingResult result ,@PathVariable("co") int co) {
		Account entity = new Account();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			if(co==2) return new ModelAndView("admin/account/lecture/addOrEdit", model);
			else if( co==4 )return new ModelAndView("admin/account/student/addOrEdit", model);
			else return new ModelAndView("admin/account/leaderLecture/addOrEdit", model);
		}
		BeanUtils.copyProperties(account, entity);
		accountService.save(entity);
		String message = "";
		message = "Tạo tài khoản thành công!";
		model.addAttribute("message", message);
		
		if(co==2) return new ModelAndView("forward:/admin/account/listLecture", model);
		else if( co==4 ) return new ModelAndView("forward:/admin/account/listStudent", model);
		else  return new ModelAndView("forward:/admin/account/listLeaderLecture", model);
	}
	@RequestMapping("saveofUpdatehome")
	public ModelAndView saveOrUpdatehome(ModelMap model, @Valid @ModelAttribute("account") AccountModel account,
			BindingResult result) {
		Account entity = new Account();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			//return new ModelAndView("common/account/addOrEdit");/account/listLecture
			return new ModelAndView("admin/account/addOrEdit");
		}
		String message = "";
			message = "Tạo tài khoản thành công !";
		BeanUtils.copyProperties(account, entity);
		accountService.save(entity);
		model.addAttribute("message", message);
		return new ModelAndView("forward:/admin/account/addhome", model);
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
	@GetMapping("delete/{email}")
	public ModelAndView delete(ModelMap model, @PathVariable("email") String email) {
		accountService.deleteById(email);
		return new ModelAndView("redirect:/admin/account/listLecture", model);
	}

	/*
	 * @GetMapping("delete/{email}") public ModelAndView delete(ModelMap
	 * model, @PathVariable("email") String email) { Account entity = new Account();
	 * entity = accountService.findOneByemail(email); accountService.delete(entity);
	 * AccountModel account = new AccountModel(); BeanUtils.copyProperties(entity,
	 * account); account.setIsEdit(false); return new
	 * ModelAndView("redirect:/account", model); }
	 */
}

