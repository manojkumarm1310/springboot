package com.wipro.model;

import java.util.LinkedList;

public class ShoppingCart {
	private LinkedList<Product> cart;
	
	public ShoppingCart() {
		this.cart=new LinkedList<>();
	}
	
	public void addItem(Product product) {
		cart.add(product);
	}
	
	public void removeItem(String productName) {
		cart.removeIf(product -> product.getName().equalsIgnoreCase(productName));
	}
	
	public void viewCart() {
		for(Product product:cart) {
			System.out.println(product);
		}
	}
	
	public LinkedList<Product> getCart() {
	     return new LinkedList<>(cart);
	 }

	public void clearCart() {
        cart.clear();
    }

    public void setCart(LinkedList<Product> newCart) {
        cart = new LinkedList<>(newCart);
    }
}
