package com.bus.reservation.model;

public class Bus {
	private String busId;
	private String departmentName;
	private String source;
	private String destination;
	private Double fare;
	private String availableDate;
	private Integer seatsAvailable;

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

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", departmentName=" + departmentName + ", source=" + source + ", destination="
				+ destination + ", fare=" + fare + ", availableDate=" + availableDate + ", seatsAvailable="
				+ seatsAvailable + "]";
	}

}
