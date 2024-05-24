package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;

public class PatientTO implements Serializable {
    
    private Long id;

	private String firstName;

	private String lastName;

	private String telephoneNumber;

	private String email;

	private String patientNumber;

	private LocalDate dateOfBirth;

	private AddressTO address;

	private List<Long> visitsID;

	private Boolean stillAlive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressTO getAddress() {
		return address;
	}

	public void setAddress(AddressTO address) {
		this.address = address;
	}

	public List<Long> getVisitsID() {
		return visitsID;
	}

	public void setVisitsID(List<Long> visitsID) {
		this.visitsID = visitsID;
	}

	public void setStillAlive(Boolean stillAlive) {
		this.stillAlive = stillAlive;
	}

	public Boolean getStillAlive() {
		return stillAlive;
	}
}
