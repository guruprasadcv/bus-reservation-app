package com.bus.reservation.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.reservation.entity.UserEntity;
import com.bus.reservation.exception.InvalidPasswordException;
import com.bus.reservation.exception.UserDoesNotExistsException;
import com.bus.reservation.model.Login;
import com.bus.reservation.model.User;
import com.bus.reservation.repo.RegisterRepositroy;

@Service
public class LogInServiceImpl implements LogInService {
	Logger logger = Logger.getLogger(LogInServiceImpl.class.getName());

	@Autowired
	private RegisterRepositroy registerRepositroy;

	@Override
	public User authenticateLogin(Login login) throws InvalidPasswordException, UserDoesNotExistsException {
		logger.info("Inside authenticateLogin() of LogInServiceImpl");
		UserEntity userEntity = registerRepositroy.findByuserName(login.getUsername());
		logger.info("findByuserName: " + userEntity);
		if (userEntity == null) {
			throw new UserDoesNotExistsException("LogInService.USER_DOES_NOT_EXISTS");
		}
		if (!userEntity.getPassword().equalsIgnoreCase(login.getPassword())) {
			throw new InvalidPasswordException("LogInService.INVALID_PASSWORD");
		}
		User user = new User();
		user.setUserName(userEntity.getUserName());
		user.setPassword(userEntity.getPassword());
		user.setEmail(userEntity.getEmail());
		user.setPhoneNumber(userEntity.getPhone());
		return user;
	}

}
