package com.bus.reservation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public static String regex = "^[a-zA-Z0-9]{3,20}+$";

	public static boolean validateUsername(String username) {
		boolean result = false;
		Pattern userNamePattern = Pattern.compile(regex);
		Matcher matcher = userNamePattern.matcher(username);
		if (matcher.matches())
			result = true;
		return result;
	}

	public static boolean validatePassword(String password) {
		boolean result = false;
		String passwordRegex = "^[a-zA-Z0-9]{6,15}+$";
		Pattern passwordPattern = Pattern.compile(passwordRegex);
		Matcher matcher = passwordPattern.matcher(password);
		if (matcher.matches())
			result = true;
		return result;
	}

	public static boolean validateEmail(String email) {
		boolean result = false;
		String emailRegex = "^[a-zA-Z0-9+_.-]+@(.+)$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher matcher = emailPattern.matcher(email);
		if (matcher.matches())
			result = true;
		return result;
	}

	public static boolean validatePhoneNumber(String phoneNumber) {
		boolean result = false;
		String phoneNumberRegex = "^[0-9]{10}";
		Pattern phoneNumberPattern = Pattern.compile(phoneNumberRegex);
		Matcher matcher = phoneNumberPattern.matcher(phoneNumber);
		if (matcher.matches())
			result = true;
		return result;
	}
}
