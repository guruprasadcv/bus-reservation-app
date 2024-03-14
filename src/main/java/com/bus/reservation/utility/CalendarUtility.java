package com.bus.reservation.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtility {

	public static Calendar convertStringToDate(String date) throws ParseException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
		Date dateReference = null;
		dateReference = simpleDate.parse(date);
		Calendar instance = Calendar.getInstance();
		instance.setTime(dateReference);
		return instance;
	}

	public static String getStringFromCalendar(Calendar calendar) {
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		date = calendar.getTime();
		String textDate = dateFormat.format(date);
		return textDate;
	}

}
