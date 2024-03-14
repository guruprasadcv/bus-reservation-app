package com.bus.reservation.service;

import java.util.Calendar;
import java.util.List;

import com.bus.reservation.exception.InvalidDestinationException;
import com.bus.reservation.exception.InvalidSourceDestinationException;
import com.bus.reservation.exception.InvalidSourceException;
import com.bus.reservation.exception.NoBusesAvailableException;
import com.bus.reservation.model.Bus;

public interface BusService {

	List<String> findSources();

	List<String> findDestinations();

	List<Bus> serachBuses(String source, String destination, Calendar journeyDate) throws InvalidSourceException,
			InvalidDestinationException, InvalidSourceDestinationException, NoBusesAvailableException;

}
