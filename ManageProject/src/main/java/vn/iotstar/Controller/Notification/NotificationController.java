package vn.iotstar.Controller.Notification;

import java.util.Date;
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

import vn.iotstar.Entity.Notification;
import vn.iotstar.Model.NotificationModel;
import vn.iotstar.Service.INotificationService;

@Controller
@RequestMapping("notification")
public class NotificationController {
	@Autowired
	INotificationService notificationService;

	// IN TẤT CẢ THÔNG BÁO
	// admin
	@RequestMapping("admin")
	public String Admin(ModelMap model) {
		List<Notification> list = notificationService.findAll();
		model.addAttribute("notification", list);
		return "admin/notification/DSThongbao";
	}

	// Giảng Viên
	@RequestMapping("lecture/notification")
	public String Lecture(ModelMap model) {
		List<Notification> list = notificationService.findAll();
		model.addAttribute("notification", list);
		return "lecture/notification/list";
	}

	// Trưởng bộ môn
	@RequestMapping("leaderLecture")
	public String LeaderLecture(ModelMap model) {
		List<Notification> list = notificationService.findAll();
		model.addAttribute("notification", list);
		return "leaderLecture/notification/list";
	}

	// Sinh viên
	@RequestMapping("student")
	public String Student(ModelMap model) {
		List<Notification> list = notificationService.findAll();
		model.addAttribute("notification", list);
		return "leaderLecture/notification/list";
	}

	// TẠO THÔNG BÁO
	// admin, giảng viên, trưởng bộ môn

	// ADMIN
	@GetMapping("addOrEditAdmin")
	public String add1(ModelMap model) {
		NotificationModel notificationModel = new NotificationModel();
		notificationModel.setIsEdit(false);// thêm
		model.addAttribute("notification", notificationModel);
		return "admin/notification/addOrEdit";

	}

	// ADMIN
	@PostMapping("saveOrUpdateAdmin")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("notifications") NotificationModel notification, BindingResult result) // lấy dữ liệu
																											// từ bên
																											// giao diện
																											// file
																											// addOrEdit
																											// đỗ dô
																											// model
	{
		// chưa có dữ liệu thêm vào, chuyển sang trang đó tiếp để người dùng tiến hành
		// thêm vào
		if (result.hasErrors()) {
			return new ModelAndView("admin/notification/addOrEdit");
		}
		Notification entity = new Notification();
		// đổ dữ liệu từ cate qua bên entity
		BeanUtils.copyProperties(notification, entity);
		entity.set_active(false);
		Date date = new Date();
		if(notification.getIsEdit()==false) {
			entity.setCreate_at(date);
		entity.setUpdate_at(date);
		}
		else {
			entity.setUpdate_at(date);
		}
		
		notificationService.save(entity);
		

		String message = "";
		if (notification.getIsEdit() == true) {
			message = "Notifications Update succesfull !";
		} else {
			message = "Notifications Create Successfull !";
		}

		model.addAttribute("message", message);
		// điều hướng vào link council/admin để in danh sách có message
		return new ModelAndView("forward:/notification/admin", model);

	}

	// Giảng Viên
	@GetMapping("addOrEditLecture")
	public String add2(ModelMap model) {
		NotificationModel notificationModel = new NotificationModel();
		notificationModel.setIsEdit(false);// thêm
		model.addAttribute("notificationModel", notificationModel);
		return "lecture/notification/addOrEdit";

	}

	@PostMapping("saveOrUpdateLecture")
	public ModelAndView saveOrUpdateLecture(ModelMap model,
			@Valid @ModelAttribute("notifications") NotificationModel notification, BindingResult result) // lấy dữ liệu
																											// từ bên
																											// giao diện
																											// file
																											// addOrEdit
																											// đỗ dô
																											// model
	{
		// chưa có dữ liệu thêm vào, chuyển sang trang đó tiếp để người dùng tiến hành
		// thêm vào
		if (result.hasErrors()) {
			return new ModelAndView("lecture/notification/addOrEdit");
		}
		Notification entity = new Notification();
		// đổ dữ liệu từ cate qua bên entity
		BeanUtils.copyProperties(notification, entity);

		notificationService.save(entity);

		String message = "";
		if (notification.getIsEdit() == true) {
			message = "Notifications Update succesfull !";
		} else {
			message = "Notifications Create Successfull !";
		}

		model.addAttribute("message", message);
		// điều hướng vào link council/admin để in danh sách có message
		return new ModelAndView("forward:/notification/lecture", model);

	}

	// Trưởng bộ môn
	@GetMapping("addOrEditLeaderLecture")
	public String add3(ModelMap model) {
		NotificationModel notificationModel = new NotificationModel();
		notificationModel.setIsEdit(false);// thêm
		model.addAttribute("notificationModel", notificationModel);
		return "leaderLecture/notification/addOrEdit";

	}

	@PostMapping("saveOrUpdateLeaderLecture")
	public ModelAndView saveOrUpdateLeaderLecture(ModelMap model,
			@Valid @ModelAttribute("notifications") NotificationModel notification, BindingResult result) // lấy dữ liệu
																											// từ bên
																											// giao diện
																											// file
																											// addOrEdit
																											// đỗ dô
																											// model
	{
		// chưa có dữ liệu thêm vào, chuyển sang trang đó tiếp để người dùng tiến hành
		// thêm vào
		if (result.hasErrors()) {
			return new ModelAndView("leaderLecture/notification/addOrEdit");
		}
		Notification entity = new Notification();
		// đổ dữ liệu từ cate qua bên entity
		BeanUtils.copyProperties(notification, entity);

		notificationService.save(entity);

		String message = "";
		if (notification.getIsEdit() == true) {
			message = "Notification Update succesfull !";
		} else {
			message = "Notification Create Successfull !";
		}

		model.addAttribute("message", message);
		// điều hướng vào link council/admin để in danh sách có message
		return new ModelAndView("forward:/notification/leaderLecture", model);

	}

	// CHỈNH SỬA THÔNG BÁO
	// admin
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
		// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
		Optional<Notification> opt = notificationService.findById(id);
		NotificationModel notification = new NotificationModel();
		// Xét xem opt là Model đó có hiện diện không
		if (opt.isPresent())

		{
			// lấy otp đó chuyển sang model, etity sang model
			Notification entity = opt.get();
			BeanUtils.copyProperties(entity, notification);
			notification.setIsEdit(true);// có nghĩa là edit, xử lý giao diện
			model.addAttribute("notification", notification);// đưa lên query
			// đưa lên giao diện để tiến hành chỉnh sửa
			return new ModelAndView("/admin/notification/addOrEdit", model);
		}
		// nếu ko Id, eroll
		model.addAttribute("message", "Notifications not vaild !!!");
		// đẩy về list sau khi hoàn thành có message
		return new ModelAndView("forward:/notification/admin", model);
	}

	// Giảng viên
	@GetMapping("edit2/{id}")
	public ModelAndView edit2(ModelMap model, @PathVariable("id") Long id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
		// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
		Optional<Notification> opt = notificationService.findById(id);
		NotificationModel notification = new NotificationModel();
		// Xét xem opt là Model đó có hiện diện không
		if (opt.isPresent())

		{
			// lấy otp đó chuyển sang model, etity sang model
			Notification entity = opt.get();
			BeanUtils.copyProperties(entity, notification);
			notification.setIsEdit(true);// có nghĩa là edit, xử lý giao diện
			model.addAttribute("notification", notification);// đưa lên query
			// đưa lên giao diện để tiến hành chỉnh sửa
			return new ModelAndView("/lecture/notification/addOrEdit", model);
		}
		// nếu ko Id, eroll
		model.addAttribute("message", "Notifications not vaild !!!");
		// đẩy về list sau khi hoàn thành có message
		return new ModelAndView("forward:/notifications/lecture", model);

	}

	// Trưởng bộ môn
	@GetMapping("edit3/{id}")
	public ModelAndView edit3(ModelMap model, @PathVariable("id") Long id) {
		// @PathVariable("categoryId") Long categoryId): nhận biến từ trên form
		// xet categoryId đó có ton tai hay chua coppoy du lieu tu entity => model
		Optional<Notification> opt = notificationService.findById(id);
		NotificationModel notification = new NotificationModel();
		// Xét xem opt là Model đó có hiện diện không
		if (opt.isPresent())

		{
			// lấy otp đó chuyển sang model, etity sang model
			Notification entity = opt.get();
			BeanUtils.copyProperties(entity, notification);
			notification.setIsEdit(true);// có nghĩa là edit, xử lý giao diện
			model.addAttribute("notification", notification);// đưa lên query
			// đưa lên giao diện để tiến hành chỉnh sửa
			return new ModelAndView("/leaderLecture/notification/addOrEdit", model);
		}
		// nếu ko Id, eroll
		model.addAttribute("message", "Notifications not vaild !!!");
		// đẩy về list sau khi hoàn thành có message
		return new ModelAndView("forward:/notifications/leaderLecture", model);

	}

	// XÓA THÔNG BÁO
	@GetMapping("delete/{id}/{co}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id, @PathVariable("co") int co) {
		notificationService.deleteById(id);
		model.addAttribute("message", "NotificationService Delete Succesfull !!!");
		if (co == 1)
			return new ModelAndView("forward:/notification/admin", model);
		else if (co == 2)
			return new ModelAndView("forward:/notification/lecture", model);
		else
			return new ModelAndView("forward:/notification/leaderLecture", model);

	}

}
