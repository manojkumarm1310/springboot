package com.wipro.model;
import java.util.Arrays;
/*
* One-to-Many relationship between Customer and Order, A Customer can place many orders
*/
public class Customer {
	private Integer customerId;
	private String name;
	private String address;
	private Long mobile;
	//Customer has placed one or more orders
	private Order[] orders;
	
	public Customer() {
		
	}
	public Customer(Integer customerId, String name, String address, Long mobile, Order[] orders) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.orders = orders;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Order[] getOrders() {
		return orders;
	}
	public void setOrders(Order[] orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", mobile=" + mobile
				+ ", orders=" + Arrays.toString(orders) + "]";
	}
	
	
	
	
	
}
