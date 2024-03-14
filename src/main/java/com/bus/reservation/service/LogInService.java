package com.bus.reservation.service;

import com.bus.reservation.exception.InvalidPasswordException;
import com.bus.reservation.exception.UserDoesNotExistsException;
import com.bus.reservation.model.Login;
import com.bus.reservation.model.User;

public interface LogInService {
	User authenticateLogin(Login login) throws InvalidPasswordException, UserDoesNotExistsException;

}
