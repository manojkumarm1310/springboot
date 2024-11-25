package com.wipro.model;

import java.time.LocalDate;
public class Professor extends Person{
	private String skill;
	private Integer experience;
	private String citation;
	private String email;
	public Professor() {
		
	}
	
	
	public Professor(Long adharCard, String name, GenderType gender, LocalDate birthdate, String address, Long mobile,
			String skill, Integer experience, String citation, String email) {
		super(adharCard, name, gender, birthdate, address, mobile);
		this.skill = skill;
		this.experience = experience;
		this.citation = citation;
		this.email = email;
	}
	
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public String getCitation() {
		return citation;
	}
	public void setCitation(String citation) {
		this.citation = citation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void showDetails() {
		System.out.println(this.getAdharCard()+","+this.getName()+","+this.getGender()+","+this.getBirthdate()+","
				+this.getAddress()+","+this.getMobile()+","+this.skill+","+this.experience+","
				+","+ this.citation+","+this.email);
		
	}
}

