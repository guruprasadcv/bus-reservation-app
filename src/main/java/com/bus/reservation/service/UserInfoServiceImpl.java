package com.bus.reservation.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.reservation.controller.LogInController;
import com.bus.reservation.entity.UserEntity;
import com.bus.reservation.model.User;
import com.bus.reservation.repo.RegisterRepositroy;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	Logger logger = Logger.getLogger(UserInfoServiceImpl.class.getName());

	@Autowired
	private RegisterRepositroy regiesterRepository;

	@Override
	public User findUserByUsername(String username) {
		logger.info("Inside findUserByUsername() of UserInfoServiceImpl...");
		UserEntity userEntity = regiesterRepository.findByuserName(username);
		logger.info("userEntity in UserInfoServiceImpl: " + userEntity);
		User user = new User();
		user.setUserName(userEntity.getUserName());
		user.setEmail(userEntity.getEmail());
		user.setUserId(userEntity.getUserId());
		user.setPhoneNumber(userEntity.getPhone());
		return user;
	}

}
