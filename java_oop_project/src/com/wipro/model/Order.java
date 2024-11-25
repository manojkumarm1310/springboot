package com.wipro.model;
import java.time.LocalDate;
/**
* COnstructor Overloading
*
* To reduce boiler-plate code(duplicate code) within the constructor methods of a class,
* use this() method.
*
* To invoke one constructor method from within another constructor method of same class, use this() method
* Note: this() method if applied should always be the first statement of the constructor method.
*
* this() method can be placed only within a constructor method.
*/
public class Order {
	private Long orderId;
	private LocalDate orderDate;
	private Double orderAmount;
	private LocalDate shipmentDate;
	private String shipmentAddress;
	private OrderStatus status;
	
	public Order() {
		
	}
	public Order(Long orderId) {
//		super();
//		this.orderId = orderId;
		this(orderId,null,null,null,null,null);
	}
	public Order(Long orderId, LocalDate orderDate, Double orderAmount) {
//		super();
//		this.orderId = orderId;
//		this.orderDate = orderDate;
//		this.orderAmount = orderAmount;
		//invoking all-arg constructor
		this(orderId,orderDate,orderAmount,null,null,null);
	}
	public Order(Long orderId, LocalDate orderDate, Double orderAmount, LocalDate shipmentDate,
			String shipmentAddress) {
//		super();
//		this.orderId = orderId;
//		this.orderDate = orderDate;
//		this.orderAmount = orderAmount;
//		this.shipmentDate = shipmentDate;
//		this.shipmentAddress = shipmentAddress;
		//Constructor call must be the first statement in a constructor
//		System.out.println("I'm 5-arg constructor method");
		this(orderId,orderDate,orderAmount,shipmentDate,shipmentAddress,null);
	}
	public Order(Long orderId, LocalDate orderDate, Double orderAmount, LocalDate shipmentDate, String shipmentAddress,
			OrderStatus status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.shipmentDate = shipmentDate;
		this.shipmentAddress = shipmentAddress;
		this.status = status;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public LocalDate getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public String getShipmentAddress() {
		return shipmentAddress;
	}
	public void setShipmentAddress(String shipmentAddress) {
		this.shipmentAddress = shipmentAddress;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderAmount=" + orderAmount
				+ ", shipmentDate=" + shipmentDate + ", shipmentAddress=" + shipmentAddress + ", status=" + status
				+ "]";
	}
	
	
	
	
}
