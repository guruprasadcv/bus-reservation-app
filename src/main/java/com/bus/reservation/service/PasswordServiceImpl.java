package com.bus.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.reservation.entity.UserEntity;
import com.bus.reservation.exception.InvalidUsernameException;
import com.bus.reservation.exception.LogInException;
import com.bus.reservation.exception.UserDoesNotExistsException;
import com.bus.reservation.repo.PasswordRepository;
import com.bus.reservation.repo.RegisterRepositroy;
import com.bus.reservation.validator.Validator;

@Service
public class PasswordServiceImpl implements PasswordService {
	@Autowired
	private RegisterRepositroy registerRepo;

	@Autowired
	private PasswordRepository passwordRepo;

	@Override
	public int resetPassword(String username, String password) throws UserDoesNotExistsException, LogInException {
		if (username.isEmpty() || password.isEmpty()) {
			throw new LogInException("LogInService.INVALID_LOGIN");
		}
		UserEntity user = registerRepo.findByuserName(username);
		if (user == null) {
			throw new UserDoesNotExistsException("LogInService.USER_DOES_NOT_EXISTS");
		}
		return passwordRepo.resetPassword(username, password);
	}

}
