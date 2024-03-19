package com.bus.reservation.model;

public class BusDTO {
	private String busId;
	private String departmentName;
	private String source;
	private String destination;
	private Double fare;
	private String availableDate;
	private Integer seatsAvailable;
	private String username;
	private String email;
	private String phoneNumber;
	private String departureTime;
	private String arrivalTime;

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "BusDTO [busId=" + busId + ", departmentName=" + departmentName + ", source=" + source + ", destination="
				+ destination + ", fare=" + fare + ", availableDate=" + availableDate + ", seatsAvailable="
				+ seatsAvailable + ", username=" + username + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}

}
