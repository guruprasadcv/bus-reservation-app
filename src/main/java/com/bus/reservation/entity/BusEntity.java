package com.bus.reservation.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bus_details")
public class BusEntity {

	@Id
	@Column(name = "bus_id")
	private String busId;

	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "fare")
	private Double fare;

	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "available_date")
	private Calendar availableDate;

	@Column(name = "seats_available")
	private Integer seatsAvailable;

	@Column(name = "departure_time")
	private String departureTime;

	@Column(name = "arrival_time")
	private String arrivalTime;

	public BusEntity() {
	}

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

	public Calendar getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Calendar availableDate) {
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
		return "BusEntity [busId=" + busId + ", departmentName=" + departmentName + ", source=" + source
				+ ", destination=" + destination + ", fare=" + fare + ", availableDate=" + availableDate
				+ ", seatsAvailable=" + seatsAvailable + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}

}
