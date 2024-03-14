package com.bus.reservation.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.reservation.entity.UserEntity;
import com.bus.reservation.exception.UserAlreadyExistsException;
import com.bus.reservation.model.User;
import com.bus.reservation.repo.RegisterRepositroy;

@Service
public class RegisterServiceImpl implements RegisterService {

	Logger logger = Logger.getLogger(RegisterServiceImpl.class.getName());
	@Autowired
	private RegisterRepositroy registerRepository;

	@Override
	public void registerUser(User user) throws UserAlreadyExistsException {
		logger.info("Inside registerUser() of RegisterServiceImpl");
		UserEntity findByuserName = registerRepository.findByuserName(user.getUserName());
		logger.info("foundUser: " + findByuserName);
		if (findByuserName != null) {
			throw new UserAlreadyExistsException("RegisterService.USER_ALREADY_EXISTS");
		}
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(user.getUserId());
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setEmail(user.getEmail());
		userEntity.setPhone(user.getPhoneNumber());
		UserEntity savedUser = registerRepository.saveAndFlush(userEntity);
		logger.info("successfully saved to database. " + savedUser);
	}

}
