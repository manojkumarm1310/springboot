package com.wipro.model;

import java.util.LinkedList;
import java.util.Stack;

public class PurchaseHistory {
	private Stack<LinkedList<Product>> purchaseHistory;
	
	public PurchaseHistory() {
		this.purchaseHistory = new Stack<>();
    }
	
	public void saveCurrentCart(LinkedList<Product> cart) {
        purchaseHistory.push(new LinkedList<>(cart));
	}
	
	public LinkedList<Product> undoingLastPurchase() {
        if (!purchaseHistory.isEmpty()) {
            return purchaseHistory.pop();
        } else {
            return null;
        }
    }
	
	 public void viewPurchaseHistory() {
	        for (LinkedList<Product> purchase : purchaseHistory) {
	            System.out.println(purchase);
	        }
	    }
}
