package com.wipro.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String itemName;
	private Double unitPrice;
	private Integer quantity;
	private Double itemTotal;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="orderId")
	private OrderMaster orderMaster;
	
	public OrderDetail() {
		
	}
	

	public OrderDetail(Integer id, String itemName, Double unitPrice, Integer quantity, Double itemTotal) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	
	public OrderDetail(String itemName, Double unitPrice, Integer quantity, Double itemTotal, OrderMaster orderMaster) {
		super();
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
		this.orderMaster = orderMaster;
	}


	public OrderDetail(String itemName, Double unitPrice, Integer quantity, Double itemTotal) {
		super();
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(Double itemTotal) {
		this.itemTotal = itemTotal;
	}


	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", itemName=" + itemName + ", unitPrice=" + unitPrice + ", quantity="
				+ quantity + ", itemTotal=" + itemTotal;
	}
	
	
}
