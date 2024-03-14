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

	@Override
	public String toString() {
		return "BusEntity [busId=" + busId + ", departmentName=" + departmentName + ", source=" + source
				+ ", destination=" + destination + ", fare=" + fare + ", availableDate=" + availableDate
				+ ", seatsAvailable=" + seatsAvailable + "]";
	}

}
