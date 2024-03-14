package com.bus.reservation.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.reservation.entity.BusEntity;
import com.bus.reservation.exception.InvalidDestinationException;
import com.bus.reservation.exception.InvalidSourceDestinationException;
import com.bus.reservation.exception.InvalidSourceException;
import com.bus.reservation.exception.NoBusesAvailableException;
import com.bus.reservation.model.Bus;
import com.bus.reservation.repo.BusRepository;
import com.bus.reservation.utility.CalendarUtility;

@Service
public class BusServiceImpl implements BusService {
	Logger logger = Logger.getLogger(BusServiceImpl.class.getName());

	@Autowired
	private BusRepository busRepository;

	@Override
	public List<String> findSources() {
		logger.info("Inside findSources() of BusServiceImpl...");
		List<String> busSources = busRepository.loadBusSources();
		return busSources;
	}

	@Override
	public List<String> findDestinations() {
		logger.info("Inside findDestinations() of BusServiceImpl...");
		List<String> destinations = busRepository.loadBusDestinations();
		return destinations;
	}

	@Override
	public List<Bus> serachBuses(String source, String destination, Calendar journeyDate) throws InvalidSourceException,
			InvalidDestinationException, InvalidSourceDestinationException, NoBusesAvailableException {
		logger.info("Inside serachBuses() of BusServiceImpl...");
		if (source.isEmpty()) {
			throw new InvalidSourceException("BusService.INVALID_SOURCE");
		}
		if (destination.isEmpty()) {
			throw new InvalidDestinationException("BusService.INVALID_DESTINATION");
		}
		if (source.equalsIgnoreCase(destination)) {
			throw new InvalidSourceDestinationException("BusService.INVALID_SOURCE_DESTINATION");
		}
		List<BusEntity> busList = busRepository.searchBuses(source, destination, journeyDate);
		logger.info("busList in serachBuses(): " + busList);
		if (busList.isEmpty()) {
			throw new NoBusesAvailableException("BusService.NO_BUSES_AVAILABLE");
		}
		List<Bus> availableBuses = new ArrayList<>();
		for (BusEntity busEntity : busList) {
			Bus busModel = new Bus();
			busModel.setDepartmentName(busEntity.getDepartmentName());
			busModel.setSource(busEntity.getSource());
			busModel.setDestination(busEntity.getDestination());
			busModel.setAvailableDate(CalendarUtility.getStringFromCalendar(busEntity.getAvailableDate()));
			busModel.setFare(busEntity.getFare());
			busModel.setSeatsAvailable(busEntity.getSeatsAvailable());
			busModel.setBusId(busEntity.getBusId());
			availableBuses.add(busModel);
		}
		return availableBuses;
	}

}
