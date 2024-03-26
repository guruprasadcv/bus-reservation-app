package com.bus.reservation.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bus.reservation.entity.UserEntity;
import com.bus.reservation.exception.InvalidPasswordException;
import com.bus.reservation.exception.UserDoesNotExistsException;
import com.bus.reservation.model.Login;
import com.bus.reservation.model.User;
import com.bus.reservation.repo.RegisterRepositroy;
import com.bus.reservation.service.LogInServiceImpl;

@ExtendWith(MockitoExtension.class)
public class LogInServiceTest {

	@InjectMocks
	LogInServiceImpl logInServiceImpl;

	@Mock
	RegisterRepositroy registerRepo;

	Login login = new Login();
	UserEntity userEntity = new UserEntity();
	UserEntity demoUser = new UserEntity();
	User user = new User();

	@BeforeEach
	public void startUp() {
		login.setUsername("gurucv");
		login.setPassword("gurucv");
		userEntity.setUserId(101);
		userEntity.setUserName("gurucv");
		userEntity.setPassword("gurucv");
		userEntity.setEmail("guru@gmail.com");
		userEntity.setPhone("1254789632");
	}

	@Test
	void TestAutenticateLogin() {
		when(registerRepo.findByuserName(login.getUsername())).thenReturn(userEntity);
		try {
			User authenticateLogin = logInServiceImpl.authenticateLogin(login);
			demoUser.setUserId(authenticateLogin.getUserId());
			demoUser.setUserName(authenticateLogin.getUserName());
			demoUser.setPassword(authenticateLogin.getPassword());
			demoUser.setEmail(authenticateLogin.getEmail());
			demoUser.setPhone(authenticateLogin.getPhoneNumber());

			assertEquals(demoUser.getPhone(), userEntity.getPhone());
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (UserDoesNotExistsException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testAuthenticateLoginUserDoesNotExists() {
		when(registerRepo.findByuserName(login.getUsername())).thenReturn(null);
		UserDoesNotExistsException thrown = assertThrows(UserDoesNotExistsException.class, () -> {
			logInServiceImpl.authenticateLogin(login);
		});
//		assertTrue(thrown.getMessage().contains("LogInService.USER_DOES_NOT_EXISTS"));
		assertEquals("LogInService.USER_DOES_NOT_EXISTS", thrown.getMessage());
	}
	
	@Test
	void testAuthenticateLoginInvalidPassword() {
		when(registerRepo.findByuserName(login.getUsername())).thenReturn(userEntity);
		login.setPassword("dummy");
		InvalidPasswordException thrown = assertThrows(InvalidPasswordException.class, () ->{
			logInServiceImpl.authenticateLogin(login);
		});
//		assertTrue(thrown.getMessage().contains("LogInService.INVALID_PASSWORD"));
		assertEquals("LogInService.INVALID_PASSWORD", thrown.getMessage());
	}
}
