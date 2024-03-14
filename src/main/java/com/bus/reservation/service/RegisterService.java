package com.bus.reservation.service;

import com.bus.reservation.exception.UserAlreadyExistsException;
import com.bus.reservation.model.User;

public interface RegisterService {
	
	void registerUser(User user) throws UserAlreadyExistsException;

}
