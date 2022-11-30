package vn.iotstar.Controller.Admin;

import java.util.List;
import java.util.Optional;

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

import vn.iotstar.Entity.Admin;

import vn.iotstar.Model.AdminModel;

import vn.iotstar.Service.IAdminService;


@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	IAdminService adminService;
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
