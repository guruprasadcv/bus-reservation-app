package com.bus.reservation.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bus.reservation.exception.InvalidDestinationException;
import com.bus.reservation.exception.InvalidJourneyDate;
import com.bus.reservation.exception.InvalidSourceDestinationException;
import com.bus.reservation.exception.InvalidSourceException;
import com.bus.reservation.exception.NoBusesAvailableException;
import com.bus.reservation.model.Bus;
import com.bus.reservation.service.BusService;
import com.bus.reservation.utility.CalendarUtility;

@Controller
@RequestMapping("/bus")
public class BusController {
	Logger logger = Logger.getLogger(BusController.class.getName());

	@Autowired
	private BusService busService;

	@Autowired
	private Environment environment;

	@RequestMapping("/showbus")
	public ModelAndView showSerachBusPage(ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> busSources = busService.findSources();
		List<String> busDestinations = busService.findDestinations();
		modelMap.addAttribute("busSource", busSources);
		modelMap.addAttribute("busDestination", busDestinations);
		modelAndView = new ModelAndView("search-bus", "bus", new Bus());
		return modelAndView;
	}

	@RequestMapping(value = "/searchBus", method = RequestMethod.POST)
	public ModelAndView searchBus(@ModelAttribute("bus") Bus bus, ModelMap modelMap, HttpSession httpSession) {
		logger.info("Inside searchBus() of BusController...");

		ModelAndView modelAndView = null;
		try {
			String source = bus.getSource();
			String destination = bus.getDestination();
			Calendar calendar = CalendarUtility.convertStringToDate(bus.getAvailableDate());

			logger.info("source: " + source);
			logger.info("destination: " + destination);
			logger.info("calendar: " + calendar.getTime());

			List<Bus> availableBusList = busService.serachBuses(source, destination, calendar);
			modelMap.addAttribute("availableBuses", availableBusList);
//			for (Bus busList : availableBusList) {
//				httpSession.setAttribute("busId", busList.getBusId());
//			}
			modelAndView = new ModelAndView("book-bus", "bus", bus);

		} catch (ParseException | InvalidSourceDestinationException | NoBusesAvailableException | InvalidSourceException
				| InvalidDestinationException e) {
			if (e.getMessage().contains("BusService")) {
				System.out.println("errorMessage: " + e.getMessage());
				modelAndView = new ModelAndView("book-bus");
				modelMap.addAttribute("errorMessage", environment.getProperty(e.getMessage()));
			}
		}

		List<String> busSources = busService.findSources();
		List<String> busDestinations = busService.findDestinations();
		modelMap.addAttribute("busSourceList", busSources);
		modelMap.addAttribute("busDestinationList", busDestinations);
		return modelAndView;
	}
}
