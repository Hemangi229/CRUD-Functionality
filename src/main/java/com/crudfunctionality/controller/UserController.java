package com.crudfunctionality.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crudfunctionality.formvalidation.FormValidation;
import com.crudfunctionality.model.User;
import com.crudfunctionality.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	FormValidation formValidation;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(formValidation);
	}

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.debug("indax()");
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		logger.debug("list()");		
		ModelAndView model = new ModelAndView("user/user_page");
		List<User> list = userService.listAllUsers();
		model.addObject("listUser", list);

		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		logger.debug("add()");		
		ModelAndView model = new ModelAndView("user/user_form");
		User user = new User();
		model.addObject("userForm", user);

		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		logger.debug("update() " +  id);		
		ModelAndView model = new ModelAndView("user/user_form");
		User user = userService.findUserById(id);
		model.addObject("userForm", user);

		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("userForm") @Validated User user, BindingResult result, final RedirectAttributes redirectAttributes) {
		logger.debug("save() " + user);
		if (result.hasErrors()) {
			return new ModelAndView("user/user_form");
		} else {
			if (user != null && user.getId() != null) {
				userService.updateUser(user);
			} else {
				userService.saveUser(user);
			}
		}
		return new ModelAndView("redirect:/user/list");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		logger.debug("delete()" + id);
		userService.deleteUser(id);
		return new ModelAndView("redirect:/user/list");
	}
}
