package com.bus.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bus.reservation.entity.BusEntity;
import com.bus.reservation.model.BusDTO;
import com.bus.reservation.service.BookingService;
import com.bus.reservation.utility.CalendarUtility;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@RequestMapping("/bookBus")
	public ModelAndView bookBus(@RequestParam("busId") String busId, @ModelAttribute("busDTO") BusDTO busDTO,
			ModelMap modelMap, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		BusEntity busEntity = bookingService.bookBus(busId);
		busDTO.setBusId(busEntity.getBusId());
		busDTO.setDepartmentName(busEntity.getDepartmentName());
		busDTO.setSource(busEntity.getSource());
		busDTO.setDestination(busEntity.getDestination());
		busDTO.setFare(busEntity.getFare());
		busDTO.setAvailableDate(CalendarUtility.getStringFromCalendar(busEntity.getAvailableDate()));
		busDTO.setUsername((String) httpSession.getAttribute("username"));
		busDTO.setEmail((String)httpSession.getAttribute("email"));
		busDTO.setPhoneNumber((String)httpSession.getAttribute("phone"));
		busDTO.setDepartureTime(busEntity.getDepartureTime());
		busDTO.setArrivalTime(busEntity.getArrivalTime());
		modelMap.addAttribute("busDto", busDTO);
		modelAndView = new ModelAndView("booking-details", "busDTO", busDTO);
		return modelAndView;
	}
}
