package com.bus.reservation.exception;

public class NoBusesAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoBusesAvailableException(String message) {
		super(message);
	}

}
