package com.wipro.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
//Student is owning side and Address is inverse side
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	private String doorNumber;
	private String cityTownVillageName;
	
	@OneToOne(mappedBy = "address")
	private Student student;
	
	
	public Address() {
		
	}
	public Address( String doorNumber, String cityTownVillageName ) {
		super();
		
		this.doorNumber = doorNumber;
		this.cityTownVillageName=cityTownVillageName;
	}
	public Address(Integer addressId, String doorNumber, String cityTownVillageName ) {
		super();
		this.addressId = addressId;
		this.doorNumber = doorNumber;
		this.cityTownVillageName=cityTownVillageName;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getCityTownVillageName() {
		return cityTownVillageName;
	}
	public void setCityTownVillageName(String cityTownVillageName) {
		this.cityTownVillageName = cityTownVillageName;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", doorNumber=" + doorNumber + ", cityTownVillageName="
				+ cityTownVillageName + "]";
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	
}
