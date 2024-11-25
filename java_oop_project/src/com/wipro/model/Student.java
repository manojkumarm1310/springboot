package com.wipro.model;

import java.time.LocalDate;
public class Student extends Person{
	private String classStudying;
	private String section;
	private Integer rollNumber;
	private Integer ranking;
	private String email;
	public Student() {
		
	}
	
	
	public Student(Long adharCard, String name, GenderType gender, LocalDate birthdate, String address, Long mobile,
			String classStudying, String section, Integer rollNumber, Integer ranking, String email) {
		super(adharCard, name, gender, birthdate, address, mobile);
		this.classStudying = classStudying;
		this.section = section;
		this.rollNumber = rollNumber;
		this.ranking = ranking;
		this.email = email;
	}
	public String getClassStudying() {
		return classStudying;
	}
	public void setClassStudying(String classStudying) {
		this.classStudying = classStudying;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Integer getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}
	public Integer getRanking() {
		return ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void showDetails() {
		System.out.println(this.getAdharCard()+","+this.getName()+","+this.getGender()+","+this.getBirthdate()+","
				+this.getAddress()+","+this.getMobile()+","+this.classStudying+","+this.section+","+this.rollNumber
				+","+ this.ranking+","+this.email);
		
		
	}
}
