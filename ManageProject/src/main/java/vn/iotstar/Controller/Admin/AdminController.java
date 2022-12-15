package vn.iotstar.Controller.Admin;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Account;
import vn.iotstar.Entity.Admin;
import vn.iotstar.Entity.LeaderLecture;
import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Notification;
import vn.iotstar.Entity.Student;
import vn.iotstar.Model.AccountModel;
import vn.iotstar.Model.AdminModel;
import vn.iotstar.Model.LectureModel;
import vn.iotstar.Service.IAccountService;
import vn.iotstar.Service.IAdminService;
import vn.iotstar.Service.ILeaderLectureService;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.INotificationService;
import vn.iotstar.Service.IStudentService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IAdminService adminService;
	@Autowired
	INotificationService notificationService;
	@Autowired
	ILectureService lectureSerivce;
	@Autowired
	ServletContext application;
	@Autowired
	IStudentService studentService;
	@Autowired
	ILeaderLectureService leaderLectureService;
	@Autowired
	IAccountService accountService;
	
	// thêm tài khoản 
	@GetMapping("addAccount/{id}/{loaitaikhoan}")
	public ModelAndView addAccount(ModelMap model, @PathVariable("id") int id, @PathVariable("loaitaikhoan") int loaitaikhoan) {
		if(loaitaikhoan==1) {
			Lecture giangvien = lectureSerivce.findById((long)id).get();
			Random generator = new Random();
			model.addAttribute("pass", generator.nextInt(999999));
			model.addAttribute("lecture", giangvien);
			model.addAttribute("role", 1);
			return new ModelAndView("admin/AddTaiKhoan/GiangVien/Account", model);
		}
		else if(loaitaikhoan==2) {
			Student sinhvien = studentService.findById(id).get();
			Random generator = new Random();
			model.addAttribute("pass", generator.nextInt(999999));
			model.addAttribute("student", sinhvien);
			model.addAttribute("role", 2);
			return new ModelAndView("admin/AddTaiKhoan/SinhVien/Account", model);
		}
		else {
		
			LeaderLecture truongbomon = leaderLectureService.findById(id).get();
			Random generator = new Random();
			model.addAttribute("pass", generator.nextInt(999999));
			model.addAttribute("leaderLecture", truongbomon);
			model.addAttribute("role", 3);
			return new ModelAndView("admin/AddTaiKhoan/GiangVien/Account", model);
		}
		

	}// thêm tài khoản 
	@GetMapping("editAccount/{id}/{loaitaikhoan}")
	public ModelAndView editAccount(ModelMap model, @PathVariable("id") int id, @PathVariable("loaitaikhoan") int loaitaikhoan) {
		if(loaitaikhoan==1) {
			Lecture giangvien = lectureSerivce.findById((long)id).get();
			Random generator = new Random();
			model.addAttribute("pass", generator.nextInt(999999));
			model.addAttribute("lecture", giangvien);
			model.addAttribute("role", 1);
			return new ModelAndView("admin/AccountManagement/GiangVien/Account", model);
		}
		else if(loaitaikhoan==2) {
			Student sinhvien = studentService.findById(id).get();
			Random generator = new Random();
			model.addAttribute("pass", generator.nextInt(999999));
			model.addAttribute("student", sinhvien);
			model.addAttribute("role", 2);
			return new ModelAndView("admin/AccountManagement/SinhVien/Account", model);
		}
		else {
		
			LeaderLecture truongbomon = leaderLectureService.findById(id).get();
			Random generator = new Random();
			model.addAttribute("pass", generator.nextInt(999999));
			model.addAttribute("leaderLecture", truongbomon);
			model.addAttribute("role", 3);
			return new ModelAndView("admin/AccountManagement/TruongBoMon/Account", model);
		}
		

	}
	
	@PostMapping("saveoAccount/{loaitaikhoan}")
	public ModelAndView saveOrUpdate(ModelMap model,@PathVariable("loaitaikhoan") int loaitaikhoan, @Valid @ModelAttribute("account") AccountModel account,
			BindingResult result) {
		Account entity = new Account();

		/*
		 * if (result.hasErrors()) { model.addAttribute("message", "Có lỗi"); return new
		 * ModelAndView("admin/student/addOrEdit"); }
		 */
		
		BeanUtils.copyProperties(account, entity);
		entity.setIsactive(false);
		if (loaitaikhoan==1)
			entity.setRoleid(1);
		else if(loaitaikhoan==2)
			entity.setRoleid(2);
		else entity.setRoleid(3);
		accountService.save(entity);
		model.addAttribute("message", "Đã thêm tài khoản thành công");
		return new ModelAndView("admin/AddTaiKhoan/Home", model);
	}
	
	@PostMapping("saveoAccount2/{loaitaikhoan}")
	public ModelAndView saveOrUpdate2(ModelMap model,@PathVariable("loaitaikhoan") int loaitaikhoan, @Valid @ModelAttribute("account") AccountModel account,
			BindingResult result) {
		/*
		 * if (result.hasErrors()) { model.addAttribute("message", "Có lỗi"); return new
		 * ModelAndView("admin/student/addOrEdit"); }
		 */
		
		Account entity1 = accountService.findById(account.getEmail()).get();
		
		entity1.setIsactive(false);
		entity1.setPassword(account.getPassword());
		if (loaitaikhoan==1)
			entity1.setRoleid(1);
		else if(loaitaikhoan==2)
			entity1.setRoleid(2);
		else entity1.setRoleid(3);
		accountService.save(entity1);
		//model.addAttribute("message", "Cập nhật tài khoản " +account.getEmail() + " thành công");
		if (loaitaikhoan==1)
			return new ModelAndView("/admin/student", model);
		else if(loaitaikhoan==2)
			return new ModelAndView("forward:/admin/student", model);
		else return new ModelAndView("/admin/student", model);
		
	}
	//TRANG CHỦ ADMIN
	@RequestMapping("testtrang")
	public String Main1(ModelMap model) {
		return "admin/AccountManagement/SinhVien/list";
	}
	//Theem tai khoan
	@RequestMapping("addacount")
	public String addacount (ModelMap model) {
		return "admin/AddTaiKhoan/Home";
	}
	//TRANG CHỦ ADMIN
	@RequestMapping("trangchu")
	public String Main(ModelMap model) {
		List<Notification> list = notificationService.findAll();
		model.addAttribute("notification", list);
		return "Home/admin";
	}
	//IN TẤT CẢ ADMIN
	//admin
	@RequestMapping("")
	public String CouncilAdmin(ModelMap model) {
		List<Admin> list = adminService.findAll();
		model.addAttribute("admin", list);
		return "EditAdmin/list";
	}

	//TẠO ADMIN
	//admin
	@GetMapping("addOrEdit")
	public String add(ModelMap model) {
		AdminModel admin = new AdminModel();
		admin.setIsEdit(false);// thêm
		model.addAttribute("admin", admin);
		return "EditAdmin/addOrEdit";

	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("admins") AdminModel admin,
			BindingResult result) // lấy dữ liệu từ bên giao diện file addOrEdit đỗ dô model
	{
		//chưa có dữ liệu thêm vào, chuyển sang trang đó tiếp để người dùng tiến hành thêm vào
		if (result.hasErrors()) {
			return new ModelAndView("EditAdmin/addOrEdit");
		}
		Admin entity = new Admin();
		// đổ dữ liệu từ cate qua bên entity
		BeanUtils.copyProperties(admin, entity);
		adminService.save(entity);
		String message = "";
		if (admin.getIsEdit() == true) {
			message = "Admin Update succesfull !";
		} else {
			message = "Admin Create Successfull !";
		}
		model.addAttribute("message", message);
		//điều hướng vào link  để in danh sách có message
		return new ModelAndView("forward:/admin", model);

	}
	
	//CHỈNH SỬA ADMIN
	//admin
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
		// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
		Optional<Admin> opt = adminService.findById(id);
		AdminModel admin = new AdminModel();
		// Xét xem opt là Model đó có hiện diện không
		if (opt.isPresent())

		{
			// lấy otp đó chuyển sang model, etity sang model
			Admin entity = opt.get();
			BeanUtils.copyProperties(entity, admin);
			admin.setIsEdit(true);// có nghĩa là edit, xử lý giao diện
			model.addAttribute("admin", admin);// đưa lên query
			//đưa lên giao diện để tiến hành chỉnh sửa
			return new ModelAndView("/EditAdmin/addOrEdit", model);
		}
		// nếu ko Id, eroll
		model.addAttribute("message", "Admin not vaild !!!");
		// đẩy về list sau khi hoàn thành có message
		return new ModelAndView("forward:/admin", model);

	}
	//XÓA ADMIN
	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		adminService.deleteById(id);
		model.addAttribute("message", "Admin Delete Succesfull !!!");
		return new ModelAndView("forward:/admin", model);

	}
	//TÌM KIẾM ADMIN
	@GetMapping("search/{id}")
	public ModelAndView search(ModelMap model, @RequestParam(name="id") Long id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
		// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
		Optional<Admin> opt = adminService.findById(id);
		AdminModel admin = new AdminModel();
		// Xét xem opt là Model đó có hiện diện không
		if (opt.isPresent())
		{
			// lấy otp đó chuyển sang model, etity sang model
			Admin entity = opt.get();
			BeanUtils.copyProperties(entity, admin);
			model.addAttribute("admins", admin);// đưa lên query
			//đưa lên giao diện để tiến hành chỉnh sửa
			return new ModelAndView("/EditAdmin/list", model);
		}
		// nếu ko Id, eroll
		model.addAttribute("message", "Admin not vaild !!!");
		// đẩy về list sau khi hoàn thành có message
		return new ModelAndView("forward:/admin", model);
		
	}

}
