package vn.iotstar.Controller.Council;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


import vn.iotstar.Entity.Council;

import vn.iotstar.Model.CouncilModel;
import vn.iotstar.Service.ICouncilService;



@Controller
@RequestMapping("council")
public class CouncilController {
	@Autowired
	ICouncilService councilService;
	//IN TẤT CẢ NHÓM HỘI ĐỒNG
	//admin
	@RequestMapping("admin")
	public String CouncilAdmin(ModelMap model) {
		List<Council> list = councilService.findAll();
		model.addAttribute("council", list);
		return "admin/council/list";
	}
	//Giảng Viên
	@RequestMapping("lecture")
	public String CouncilLecture(ModelMap model) {
		List<Council> list = councilService.findAll();
		model.addAttribute("council", list);
		return "lecture/council/list";
	}
	//Trưởng bộ môn
	@RequestMapping("leaderLecture")
	public String CouncilLeaderLecture(ModelMap model) {
		List<Council> list = councilService.findAll();
		model.addAttribute("council", list);
		return "leaderLecture/council/list";
	}
	//TẠO HỘI ĐỒNG
	//admin
	@GetMapping("addOrEdit")
	public String add(ModelMap model) {
		CouncilModel council = new CouncilModel();
		council.setIsEdit(false);// thêm
		model.addAttribute("council", council);
		return "admin/council/addOrEdit";

	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("councils") CouncilModel council,
			BindingResult result) // lấy dữ liệu từ bên giao diện file addOrEdit đỗ dô model
	{
		//chưa có dữ liệu thêm vào, chuyển sang trang đó tiếp để người dùng tiến hành thêm vào
		if (result.hasErrors()) {
			return new ModelAndView("admin/council/addOrEdit");
		}
		Council entity = new Council();
		// đổ dữ liệu từ cate qua bên entity
		BeanUtils.copyProperties(council, entity);

		councilService.save(entity);

		String message = "";
		if (council.getIsEdit() == true) {
			message = "Councils Update succesfull !";
		} else {
			message = "CouncilsCreate Successfull !";
		}

		model.addAttribute("message", message);
		//điều hướng vào link council/admin để in danh sách có message
		return new ModelAndView("forward:/council/admin", model);

	}
	
	//CHỈNH SỬA HỘI ĐỒNG
	//admin
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
		// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
		Optional<Council> opt = councilService.findById(id);
		CouncilModel council = new CouncilModel();
		// Xét xem opt là Model đó có hiện diện không
		if (opt.isPresent())

		{
			// lấy otp đó chuyển sang model, etity sang model
			Council entity = opt.get();
			BeanUtils.copyProperties(entity, council);
			council.setIsEdit(true);// có nghĩa là edit, xử lý giao diện
			model.addAttribute("council", council);// đưa lên query
			//đưa lên giao diện để tiến hành chỉnh sửa
			return new ModelAndView("/admin/council/addOrEdit", model);
		}
		// nếu ko Id, eroll
		model.addAttribute("message", "Councilis not vaild !!!");
		// đẩy về list sau khi hoàn thành có message
		return new ModelAndView("forward:/council/admin", model);

	}
	//XÓA HỘI ĐỒNG
	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		councilService.deleteById(id);
		model.addAttribute("message", "Council Delete Succesfull !!!");
		return new ModelAndView("forward:/council/admin", model);

	}
	//TÌM KIẾM HỘI ĐỒNG THEO ID HỘI ĐỒNG
	@GetMapping("search/{id}")
	public ModelAndView search(ModelMap model, @RequestParam(name="id") Long id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
		// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
		Optional<Council> opt = councilService.findById(id);
		CouncilModel council = new CouncilModel();
		// Xét xem opt là Model đó có hiện diện không
		if (opt.isPresent())
		{
			// lấy otp đó chuyển sang model, etity sang model
			Council entity = opt.get();
			BeanUtils.copyProperties(entity, council);
			model.addAttribute("councils", council);// đưa lên query
			//đưa lên giao diện để tiến hành chỉnh sửa
			return new ModelAndView("/admin/council/list", model);
		}
		// nếu ko Id, eroll
		model.addAttribute("message", "Councilis not vaild !!!");
		// đẩy về list sau khi hoàn thành có message
		return new ModelAndView("forward:/council/admin", model);
		
	}
	
	

	
}
