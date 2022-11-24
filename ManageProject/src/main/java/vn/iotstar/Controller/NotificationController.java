package vn.iotstar.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	INotificationService notificationService;

	@GetMapping("")
	public ModelAndView List(ModelMap model) {
		List<Notification> notifies = notificationService.findAll();
		model.addAttribute("notifies", notifies);
		return new ModelAndView("common/notify/list", model);
	}

	@GetMapping("add")
	public String add(Model model) {
		NotificationModel notify = new NotificationModel();
		notify.setIsEdit(false);
		model.addAttribute("notify", notify);
		return "common/notify/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) throws IOException {
		Optional<Notification> opt = notificationService.findById(id);
		NotificationModel notify = new NotificationModel();
		if (opt.isPresent()) {
			Notification entity = opt.get();
			BeanUtils.copyProperties(entity, notify);
			notify.setIsEdit(true);
			model.addAttribute("notify", notify);
			return new ModelAndView("common/notify/addOrEdit", model);
		}
		model.addAttribute("message", "Notify không tồn tại");
		return new ModelAndView("redirect:/notification", model);
	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("notify") NotificationModel notify,
			BindingResult result) {
		Notification entity = new Notification();
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("common/notify/addOrEdit");
		}
		BeanUtils.copyProperties(notify, entity);
		notificationService.save(entity);
		return new ModelAndView("redirect:/notification", model);
	}

	@GetMapping("search")
	public String search() {
		return "common/notify/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		notificationService.deleteById(id);
		return new ModelAndView("redirect:/notification", model);
	}

}
