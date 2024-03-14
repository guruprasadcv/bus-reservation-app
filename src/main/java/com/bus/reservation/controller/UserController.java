package com.bus.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bus.reservation.model.User;
import com.bus.reservation.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/userInfo")
	public ModelAndView showUserInfo(@RequestParam("username") String username, @ModelAttribute("user") User user) {
		ModelAndView modelAndView = new ModelAndView("user-info");
		User findUserByUsername = userInfoService.findUserByUsername(username);
		modelAndView.addObject("userInfo", findUserByUsername);
		return modelAndView;
	}
}
