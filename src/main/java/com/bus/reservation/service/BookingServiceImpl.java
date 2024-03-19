package com.bus.reservation.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.reservation.entity.BusEntity;
import com.bus.reservation.repo.BusRepository;

@Service
public class BookingServiceImpl implements BookingService {
	Logger logger = Logger.getLogger(BookingServiceImpl.class.getName());

	@Autowired
	private BusRepository busRepository;

	@Override
	public BusEntity bookBus(String busId) {
		logger.info("Inside bookBus() of BookingServiceImpl...");
		BusEntity busEntity = busRepository.findBybusId(busId);
		logger.info("busEntity in bookBus() of BookingServiceImpl : " + busEntity);
		return busEntity;
	}

}
