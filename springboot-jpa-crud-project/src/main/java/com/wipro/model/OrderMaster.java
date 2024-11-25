package com.wipro.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OrderMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderId;
	private Integer orderAmount;
	private LocalDate orderDate;
	private LocalDate shipmentDate;
	private String status;
	
	@OneToMany(mappedBy="orderMaster")
	List<OrderDetail> orderDetails;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="custId")
	private Customer customer;
	public OrderMaster() {
		
	}
	

	public List<OrderDetail> getOrderDetail() {
		return orderDetails;
	}


	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetails = orderDetail;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public OrderMaster(Integer orderAmount, String orderDate, String shipmentDate, String status,
			Customer customer) {
		super();
		this.orderAmount = orderAmount;
		this.orderDate = LocalDate.parse(orderDate);
		this.shipmentDate = LocalDate.parse(shipmentDate);
		this.status = status;
		this.customer = customer;
	}


	public OrderMaster(String orderDate, String shipmentDate, String status,
			List<OrderDetail> orderDetail, Customer customer) {
		super();
		this.orderAmount = orderAmount;
		this.orderDate = LocalDate.parse(orderDate);
		this.shipmentDate = LocalDate.parse(shipmentDate);
		this.status = status;
		this.orderDetails = orderDetail;
		this.customer = customer;
	}


	public OrderMaster(Integer orderAmount, LocalDate orderDate, LocalDate shipmentDate, String status,
			List<OrderDetail> orderDetail, Customer customer) {
		super();
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.shipmentDate = shipmentDate;
		this.status = status;
		this.orderDetails= orderDetail;
		this.customer = customer;
	}


	public OrderMaster(Integer orderId, Integer orderAmount, LocalDate orderDate, LocalDate shipmentDate,
			String status) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.shipmentDate = shipmentDate;
		this.status = status;
	}

	public OrderMaster(Integer orderAmount, LocalDate orderDate, LocalDate shipmentDate, String status) {
		super();
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.shipmentDate = shipmentDate;
		this.status = status;
	}

	public OrderMaster(Integer orderAmount, String orderDate, String shipmentDate, String status) {
		super();
		this.orderAmount = orderAmount;
		this.orderDate = LocalDate.parse(orderDate);
		this.shipmentDate = LocalDate.parse(shipmentDate);
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "OrderMaster [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderDate=" + orderDate
				+ ", shipmentDate=" + shipmentDate + ", status=" + status + ", orderDetails=" + orderDetails
				+ "]";
	}

	
	
}
