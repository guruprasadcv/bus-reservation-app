package com.bus.reservation.model;

public class Bus {
	private String busId;
	private String departmentName;
	private String source;
	private String destination;
	private Double fare;
	private String availableDate;
	private Integer seatsAvailable;
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
		return "Bus [busId=" + busId + ", departmentName=" + departmentName + ", source=" + source + ", destination="
				+ destination + ", fare=" + fare + ", availableDate=" + availableDate + ", seatsAvailable="
				+ seatsAvailable + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}

}
