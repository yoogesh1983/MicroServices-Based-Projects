package com.codetutr.vehicleTrackingSystem.Entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle 
{
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private long id;
	private String name;
	private int odometer;
	private String status;
	private String latLong;
	private String currentDriver;
	private String chassisNumber;
	private BigDecimal lat;
	private BigDecimal longitude;
	private Date timestamp;
	
	
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="Pid")
    private Profile profile;
	

	public Vehicle() {}
	
	public long getId() {
		return id;
	}

/*	public void setId(long id) {
		this.id = id;
	}*/
	
	public Vehicle(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLatLong() {
		return latLong;
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}

	public String getCurrentDriver() {
		return currentDriver;
	}

	public void setCurrentDriver(String currentDriver) {
		this.currentDriver = currentDriver;
	}
	
	public String getChassisNumber() {
		return chassisNumber;
	}
	
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", odometer=" + odometer + ", status=" + status + ", latLong="
				+ latLong + ", currentDriver=" + currentDriver + ", chassisNumber=" + chassisNumber + ", lat=" + lat
				+ ", longitude=" + longitude + ", timestamp=" + timestamp + ", profile=" + profile + "]";
	}

}
