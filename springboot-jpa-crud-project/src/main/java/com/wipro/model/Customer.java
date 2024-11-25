package com.wipro.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer custId;
	private String adharCard;
	private String customerName;
	private String address;
	private String email;
	private Long mobile;
	
	@OneToMany(mappedBy="customer")
	private List<OrderMaster> orderMaster;
	
	public Customer() {
		
	}

	public Customer(Integer custId, String adharCard, String customerName, String address, String email, Long mobile) {
		super();
		this.custId = custId;
		this.adharCard = adharCard;
		this.customerName = customerName;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}

	public Customer(Integer custId, String adharCard, String customerName, String address, String email, Long mobile,
			List<OrderMaster> orderMaster) {
		super();
		this.custId = custId;
		this.adharCard = adharCard;
		this.customerName = customerName;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.orderMaster = orderMaster;
	}

	public List<OrderMaster> getOrderMaster() {
		return orderMaster;
	}

	public void setOrderMaster(List<OrderMaster> orderMaster) {
		this.orderMaster = orderMaster;
	}

	public Customer(String adharCard, String customerName, String address, String email, Long mobile) {
		super();
		this.adharCard = adharCard;
		this.customerName = customerName;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}

	public Customer(String adharCard, String customerName, String address, String email, Long mobile,
			List<OrderMaster> orderMaster) {
		super();
		this.adharCard = adharCard;
		this.customerName = customerName;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.orderMaster = orderMaster;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(String adharCard) {
		this.adharCard = adharCard;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", adharCard=" + adharCard + ", customerName=" + customerName
				+ ", address=" + address + ", email=" + email + ", mobile=" + mobile + ", orderMaster=" + orderMaster
				+ "]";
	}

	
	
}
