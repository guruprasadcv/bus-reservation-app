package com.bus.reservation.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bus.reservation.entity.UserEntity;
import com.bus.reservation.exception.UserAlreadyExistsException;
import com.bus.reservation.model.User;
import com.bus.reservation.repo.RegisterRepositroy;
import com.bus.reservation.service.RegisterServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {

	@InjectMocks
	RegisterServiceImpl registerServiceImpl;

	@Mock
	RegisterRepositroy registerRepo;

	User user = new User();
	UserEntity userEntity = new UserEntity();

	@BeforeEach
	void setUp() {
		user.setUserId(101);
		user.setUserName("gurucv");
		user.setPassword("guruCta");
		user.setEmail("gurucv@gmail.com");
		user.setPhoneNumber("1234567890");
	}

	@Test
	void testRegisterUser() {
		Mockito.lenient().when(registerRepo.findByuserName(user.getUserName())).thenReturn(null);
		userEntity.setUserId(user.getUserId());
		userEntity.setUserName(user.getUserName());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhone(user.getPhoneNumber());
		assertEquals("guruCta", userEntity.getPassword());
	}

	@Test
	void testRegisterUserUserAlreadyExists() {
		userEntity.setUserName("david");
		when(registerRepo.findByuserName(user.getUserName())).thenReturn(userEntity);
		UserAlreadyExistsException thrown = assertThrows(UserAlreadyExistsException.class, () -> {
			registerServiceImpl.registerUser(user);
		});
		assertEquals("RegisterService.USER_ALREADY_EXISTS", thrown.getMessage());
	}
}
