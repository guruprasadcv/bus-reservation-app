package com.bus.reservation.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bus.reservation.exception.InvalidPasswordException;
import com.bus.reservation.exception.InvalidUsernameException;
import com.bus.reservation.exception.LogInException;
import com.bus.reservation.exception.UserDoesNotExistsException;
import com.bus.reservation.model.Bus;
import com.bus.reservation.model.Login;
import com.bus.reservation.model.User;
import com.bus.reservation.service.BusService;
import com.bus.reservation.service.LogInService;
import com.bus.reservation.validator.Validator;

@Controller
@RequestMapping("/login")
//@SessionAttributes("{username, userId}")
public class LogInController {
	Logger logger = Logger.getLogger(LogInController.class.getName());

	@Autowired
	private LogInService logInService;

	@Autowired
	private Environment environment;

	@Autowired
	private BusService busService;

	@RequestMapping("/loginPage")
	public ModelAndView loginPage(Login login) {
		ModelAndView modelAndView = new ModelAndView("login", "loginUser", login);
		return modelAndView;
	}

	@RequestMapping("/processLogin")
	public ModelAndView processLogin(@ModelAttribute("loginUser") Login login, ModelMap modelMap,
			HttpServletRequest httpRequest)
			throws InvalidPasswordException, UserDoesNotExistsException, InvalidUsernameException, LogInException {
		ModelAndView modelAndView = new ModelAndView();
		try {

			if (login.getUsername().isEmpty() && login.getPassword().isEmpty()) {
				throw new LogInException("LogInService.INVALID_LOGIN");
			}
			if (!Validator.validateUsername(login.getUsername())) {
				throw new InvalidUsernameException("LogInService.INVALID_USERNAME");
			}
			if (!Validator.validatePassword(login.getPassword())) {
				throw new InvalidPasswordException("LogInService.INVALID_PASSWORD");
			}
			User loginUser = logInService.authenticateLogin(login);
			modelMap.addAttribute("username", loginUser.getUserName());
			modelMap.addAttribute("userId", loginUser.getUserId());

			HttpSession httpSession = httpRequest.getSession();
			httpSession.setAttribute("username", loginUser.getUserName());
			httpSession.setAttribute("email", loginUser.getEmail());
			httpSession.setAttribute("phone", loginUser.getPhoneNumber());

			List<String> busSources = busService.findSources();
			modelMap.addAttribute("busSourceList", busSources);

			List<String> busDestinations = busService.findDestinations();
			modelMap.addAttribute("busDestinationList", busDestinations);
			modelAndView = new ModelAndView("book-bus", "bus", new Bus());

		} catch (InvalidPasswordException | UserDoesNotExistsException | LogInException e) {
			if (e.getMessage().contains("LogInService")) {
				modelAndView = new ModelAndView("login");
				modelAndView.addObject("errorMessage", environment.getProperty(e.getMessage()));
			}
		}
		return modelAndView;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("home-page");
		Enumeration<String> attributeNames = httpSession.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			httpSession.removeAttribute(attributeNames.nextElement());
		}
		modelAndView.addObject("logoutMessage", environment.getProperty("LogInService.LOG_OUT"));
		return modelAndView;

	}
}
