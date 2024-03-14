package com.bus.reservation.service;

import com.bus.reservation.model.User;

public interface UserInfoService {
	
	User findUserByUsername(String username);

}
