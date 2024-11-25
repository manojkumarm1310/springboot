package com.wipro.model;

import java.time.LocalDate;

public class Person {
	
	private Long adharCard;
	private String name;
	private String gender;
	private LocalDate birthDate;
	private String address;
	private Long mobile;
	
	public Person() {
		
	}

	public Person(Long adharCard, String name, String gender, LocalDate birthDate, String address, Long mobile) {
		super();
		this.adharCard = adharCard;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.address = address;
		this.mobile = mobile;
	}

	public Long getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(Long adharCard) {
		this.adharCard = adharCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Person [adharCard=" + adharCard + ", name=" + name + ", gender=" + gender + ", birthDate=" + birthDate
				+ ", address=" + address + ", mobile=" + mobile + "]";
	}
	
	
	
}
