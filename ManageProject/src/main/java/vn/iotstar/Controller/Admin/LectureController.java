package vn.iotstar.Controller.Admin;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Model.LectureModel;
import vn.iotstar.Service.ILectureService;

@Controller
@RequestMapping("/admin/lecture")
public class LectureController {
	@Autowired
	ILectureService lectureSerivce;

	@Autowired
	ServletContext application;

	@GetMapping("add")
	public String add(Model model) {
		LectureModel lecture = new LectureModel();
		lecture.setIsEdit(false);
		model.addAttribute("lecture", lecture);
		return "admin/lecture/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) throws IOException {
		Optional<Lecture> opt = lectureSerivce.findById(id);
		LectureModel lecture = new LectureModel();
		if (opt.isPresent()) {
			Lecture entity = opt.get();
			BeanUtils.copyProperties(entity, lecture);
			lecture.setIsEdit(true);
			model.addAttribute("lecture", lecture);
			return new ModelAndView("admin/lecture/addOrEdit", model);
		}
		model.addAttribute("message", "Lecture is not valid !!!");
		return new ModelAndView("redirect:/admin/lecture", model);

	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("lecture") LectureModel lecture,
			BindingResult result) {
		Lecture entity = new Lecture();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("admin/lecture/addOrEdit");
		}
		if (!lecture.getImageFile().isEmpty()) {
			String path = application.getRealPath("/");

			try {
				lecture.setImage(lecture.getImageFile().getOriginalFilename());
				String filePath = path + "/resources/images/" + lecture.getImage();
				lecture.getImageFile().transferTo(Path.of(filePath));
				lecture.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		BeanUtils.copyProperties(lecture, entity);
		lectureSerivce.save(entity);
		return new ModelAndView("redirect:/admin/lecture", model);
	}

	@GetMapping("")
	public String list(ModelMap model) {
		List<Lecture> lectures = lectureSerivce.findAll();
		model.addAttribute("lectures", lectures);
		return "admin/lecture/list";
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		List<Lecture> list = null;
		if (StringUtils.hasText(name)) {
			list = lectureSerivce.findByLectureNameContaining(name);
		} else
			list = lectureSerivce.findAll();
		model.addAttribute("categories", list);

		return "/admin/categories/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		lectureSerivce.deleteById(id);
		return new ModelAndView("redirect:/admin/lecture", model);
	}
}
