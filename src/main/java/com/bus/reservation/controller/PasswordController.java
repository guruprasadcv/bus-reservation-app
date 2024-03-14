package com.bus.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bus.reservation.exception.LogInException;
import com.bus.reservation.exception.UserDoesNotExistsException;
import com.bus.reservation.model.Password;
import com.bus.reservation.service.PasswordService;

@RequestMapping("/password")
@Controller
public class PasswordController {

	@Autowired
	private PasswordService passwordService;

	@Autowired
	private Environment environment;

	@RequestMapping("/forgotPassword")
	public ModelAndView forgotPassword() {
		ModelAndView model = new ModelAndView("forgot-password", "fp", new Password());
		return model;
	}

	@RequestMapping("/resetPassword")
	public ModelAndView resetPassword(@ModelAttribute("fp") Password password, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			int rowCount = passwordService.resetPassword(password.getUsername(), password.getPassword());
			if (rowCount == 1) {
				modelMap.addAttribute("successMessage", environment.getProperty("passwordController.SUCCESSFUL_RESET"));
				modelAndView = new ModelAndView("forgot-password", "fp", password);
			}
		} catch (UserDoesNotExistsException | LogInException e) {
			modelAndView = new ModelAndView("forgot-password");
			modelAndView.addObject("errorMessage", environment.getProperty(e.getMessage()));
		}
		return modelAndView;
	}
}
