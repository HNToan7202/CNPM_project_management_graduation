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
import org.springframework.web.servlet.ModelAndView;


import vn.iotstar.Entity.Timeresgiter;

import vn.iotstar.Model.TimeResgiterModel;
import vn.iotstar.Service.ITimeResgiterSerivce;

@Controller
@RequestMapping("/admin/timeResgiter")
public class TimeResgiterController {
	@Autowired
	ITimeResgiterSerivce timeResgiterService;

	@RequestMapping("")
	public String Admin(ModelMap model) {
		List<Timeresgiter> list = timeResgiterService.findAll();
		model.addAttribute("timeResgiter", list);
		return "admin/timeResgiter/list";
	}
	@GetMapping("addOrEdit")
	public String add1(ModelMap model) {
		TimeResgiterModel timeResgiter = new TimeResgiterModel();
		timeResgiter.setIsEdit(false);// thêm
		model.addAttribute("timeResgiter", timeResgiter);
		return "admin/timeResgiter/addOrEdit";

	}
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
				// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
				Optional<Timeresgiter> opt = timeResgiterService.findById(id);
				TimeResgiterModel timeResgiter = new TimeResgiterModel();
				// Xét xem opt là Model đó có hiện diện không
				if (opt.isPresent())

				{
					// lấy otp đó chuyển sang model, etity sang model
					Timeresgiter entity = opt.get();
					BeanUtils.copyProperties(entity, timeResgiter);
					timeResgiter.setIsEdit(true);// có nghĩa là edit, xử lý giao diện
					model.addAttribute("timeResgiter", timeResgiter);// đưa lên query
					//đưa lên giao diện để tiến hành chỉnh sửa
					return new ModelAndView("/admin/timeResgiter/addOrEdit", model);
				}
				// nếu ko Id, eroll
				model.addAttribute("message", "timeResgiter not vaild !!!");
				// đẩy về list sau khi hoàn thành có message
				return new ModelAndView("forward:/admin/timeResgiter", model);
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("timeResgiter") TimeResgiterModel timeResgiter,
			BindingResult result) // lấy dữ liệu từ bên giao diện file addOrEdit đỗ dô model
	{
		//chưa có dữ liệu thêm vào, chuyển sang trang đó tiếp để người dùng tiến hành thêm vào
		if (result.hasErrors()) {
			return new ModelAndView("admin/timeResgiter/addOrEdit");
		}
		Timeresgiter entity = new Timeresgiter();
		// đổ dữ liệu từ cate qua bên entity
		BeanUtils.copyProperties(timeResgiter, entity);

		timeResgiterService.save(entity);

		String message = "";
		if (timeResgiter.getIsEdit() == true) {
			message = "timeResgiter Update succesfull !";
		} else {
			message = "timeResgiter Create Successfull !";
		}

		model.addAttribute("message", message);
		//điều hướng vào link council/admin để in danh sách có message
		return new ModelAndView("forward:/admin/timeResgiter", model);

	}
	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		timeResgiterService.deleteById(id);
		model.addAttribute("message", "TimeResgiterService Delete Succesfull !!!");
	
		return new ModelAndView("forward:/admin/timeResgiter", model);
	
	}
	
	
}
