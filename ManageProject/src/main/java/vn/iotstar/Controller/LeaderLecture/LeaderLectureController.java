package vn.iotstar.Controller.LeaderLecture;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

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


import vn.iotstar.Entity.LeaderLecture;
import vn.iotstar.Model.LeaderLectureModel;
import vn.iotstar.Service.ILeaderLectureService;

@Controller
@RequestMapping("/admin/leaderLecture")
public class LeaderLectureController {
	@Autowired
	ILeaderLectureService leaderLectureService;
	@Autowired
	ServletContext application;
	//IN TẤT CẢ TRƯỞNG BỘ MÔN
	//admin
	@RequestMapping("")
	public String LeaderLectureAdmin(ModelMap model) {
		List<LeaderLecture> list = leaderLectureService.findAll();
		model.addAttribute("leaderLecture", list);
		return "admin/leaderLecture/list";
	}


	//TẠO TRƯỞNG BỘ MÔN
	//admin
	@GetMapping("addOrEdit")
	public String add(ModelMap model) {
		LeaderLectureModel leaderLecture = new LeaderLectureModel();
		leaderLecture.setIsEdit(false);// thêm
		model.addAttribute("leaderLecture", leaderLecture);
		return "admin/leaderLecture/addOrEdit";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("leaderLectures") LeaderLectureModel leaderLecture,
			BindingResult result) // lấy dữ liệu từ bên giao diện file addOrEdit đỗ dô model
	{
		//chưa có dữ liệu thêm vào, chuyển sang trang đó tiếp để người dùng tiến hành thêm vào
		if (result.hasErrors()) {
			return new ModelAndView("admin/leaderLecture/addOrEdit");
		}
		if (!leaderLecture.getImageFile().isEmpty()) {
			String path = application.getRealPath("/");

			try {
				leaderLecture.setImage(leaderLecture.getImageFile().getOriginalFilename());
				String filePath = path + "/resources/images/" + leaderLecture.getImage();
				leaderLecture.getImageFile().transferTo(Path.of(filePath));
				leaderLecture.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LeaderLecture entity = new LeaderLecture();
		// đổ dữ liệu từ cate qua bên entity
		BeanUtils.copyProperties(leaderLecture, entity);

		leaderLectureService.save(entity);

		String message = "";
		if (leaderLecture.getIsEdit() == true) {
			message = "LeaderLecture Update succesfull !";
		} else {
			message = "LeaderLecture Successfull !";
		}

		model.addAttribute("message", message);
		//điều hướng vào link  để in danh sách có message
		return new ModelAndView("forward:/admin/leaderLecture", model);

	}
	
	//CHỈNH SỬA TRƯỞNG BỘ MÔN
	//admin
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") int id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
		// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
		Optional<LeaderLecture> opt = leaderLectureService.findById(id);
		LeaderLectureModel leaderLecture = new LeaderLectureModel();
		// Xét xem opt là Model đó có hiện diện không
		if (opt.isPresent())

		{
			// lấy otp đó chuyển sang model, etity sang model
			LeaderLecture entity = opt.get();
			BeanUtils.copyProperties(entity, leaderLecture);
			leaderLecture.setIsEdit(true);// có nghĩa là edit, xử lý giao diện
			model.addAttribute("leaderLecture", leaderLecture);// đưa lên query
			//đưa lên giao diện để tiến hành chỉnh sửa
			return new ModelAndView("/admin/leaderLecture/addOrEdit", model);
		}
		// nếu ko Id, eroll
		model.addAttribute("message", "LeaderLecture not vaild !!!");
		// đẩy về list sau khi hoàn thành có message
		return new ModelAndView("forward:/admin/leaderLecture", model);

	}
	//XÓA TRƯỞNG BỘ MÔN
	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") int id) {
		leaderLectureService.deleteById(id);
		model.addAttribute("message", "/LeaderLecture Delete Succesfull !!!");
		return new ModelAndView("forward:/admin/leaderLecture", model);

	}
	//TÌM KIẾM TRƯỞNG BỘ MÔN THEO ID
	@GetMapping("search/{id}")
	public ModelAndView search(ModelMap model, @RequestParam(name="id") int id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
		// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
		Optional<LeaderLecture> opt = leaderLectureService.findById(id);
		LeaderLectureModel leaderLecture = new LeaderLectureModel();
		// Xét xem opt là Model đó có hiện diện không
		if (opt.isPresent())
		{
			// lấy otp đó chuyển sang model, etity sang model
			LeaderLecture entity = opt.get();
			BeanUtils.copyProperties(entity, leaderLecture);
			model.addAttribute("leaderLectures", leaderLecture);// đưa lên query
			//đưa lên giao diện để tiến hành chỉnh sửa
			return new ModelAndView("/admin/leaderLecture/list", model);
		}
		// nếu ko Id, eroll
		model.addAttribute("message", "LeaderLecture not vaild !!!");
		// đẩy về list sau khi hoàn thành có message
		return new ModelAndView("forward:/admin/leaderLecture", model);
		
	}


}
