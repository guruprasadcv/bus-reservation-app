package com.bus.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bus.reservation.exception.InvalidEmailException;
import com.bus.reservation.exception.InvalidPasswordException;
import com.bus.reservation.exception.InvalidPhoneNumber;
import com.bus.reservation.exception.InvalidUsernameException;
import com.bus.reservation.exception.UserAlreadyExistsException;
import com.bus.reservation.model.User;
import com.bus.reservation.service.RegisterService;
import com.bus.reservation.validator.Validator;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@Autowired
	private Environment environment;

	@RequestMapping("/registerPage")
	public ModelAndView registerPage(User user) {
		ModelAndView modelAndView = new ModelAndView("register", "user", user);
		return modelAndView;
	}

	@RequestMapping("/processRegister")
	public ModelAndView processRegister(@ModelAttribute("user") User user) throws UserAlreadyExistsException,
			InvalidUsernameException, InvalidPasswordException, InvalidEmailException, InvalidPhoneNumber {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (!Validator.validateUsername(user.getUserName())) {
				throw new InvalidUsernameException("RegisterService.INVALID_USERNAME");
			}
			if (!Validator.validatePassword(user.getPassword())) {
				throw new InvalidPasswordException("RegisterService.INVALID_PASSWORD");
			}
			if (!Validator.validateEmail(user.getEmail())) {
				throw new InvalidEmailException("RegisterService.INVALID_EMAIL");
			}
			if (!Validator.validatePhoneNumber(user.getPhoneNumber())) {
				throw new InvalidPhoneNumber("RegisterService.INVALID_PHONENUMBER");
			}
			registerService.registerUser(user);
			modelAndView = new ModelAndView("register", "user", user);
			modelAndView.addObject("registerSuccess", environment.getProperty("RegisterService.REGISTRATION_SUCCESS"));
			return modelAndView;
		} catch (UserAlreadyExistsException | InvalidUsernameException | InvalidPasswordException
				| InvalidEmailException | InvalidPhoneNumber e) {
			if (e.getMessage().contains("RegisterService"))
				modelAndView = new ModelAndView("register", "user", user);
			modelAndView.addObject("registerError", environment.getProperty(e.getMessage()));
		}
		return modelAndView;
	}

}
