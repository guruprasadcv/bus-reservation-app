package com.bus.reservation.service;

import com.bus.reservation.exception.InvalidUsernameException;
import com.bus.reservation.exception.LogInException;
import com.bus.reservation.exception.UserDoesNotExistsException;

public interface PasswordService {
	int resetPassword(String username, String password) throws UserDoesNotExistsException, LogInException;
}
