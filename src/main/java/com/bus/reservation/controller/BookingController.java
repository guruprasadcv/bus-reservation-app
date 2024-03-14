package com.bus.reservation.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bus.reservation.model.Bus;

@RequestMapping("/booking")
public class BookingController {

	@RequestMapping("/bookBus")
	public ModelAndView bookBus(@ModelAttribute("bus") Bus bus, @RequestParam("busId") String busId) {
		return null;
	}
}
