package com.wipro.app;

import java.util.LinkedList;
import java.util.Scanner;

import com.wipro.model.CustomerService;
import com.wipro.model.Product;
import com.wipro.model.PurchaseHistory;
import com.wipro.model.ShoppingCart;

public class ShoppingApp {
	private static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {  
		
		
		
		ShoppingCart shoppingCart = new ShoppingCart();
		PurchaseHistory purchaseHistory = new PurchaseHistory();
		CustomerService customerService = new CustomerService();
		
		// Below commented code is for my testing purpose

		//shoppingCart.addItem(new Product("Laptop", 65000.0));
		//shoppingCart.addItem(new Product("mobile", 25000.0));
		//
		//shoppingCart.viewCart();
		//shoppingCart.removeItem("Laptop");
		//
		//System.out.println("List the items after removing");
		//shoppingCart.viewCart();
		//
		//System.out.println("New product added (Laptop2)");
		//shoppingCart.addItem(new Product("Laptop2", 75000.0));
		//shoppingCart.viewCart();
		//
		//System.out.println("------------Purchase History-------------");
		//LinkedList<Product> currentCart = shoppingCart.getCart();
		//purchaseHistory.saveCurrentCart(currentCart);
		//shoppingCart.clearCart();
		//
		//
		//purchaseHistory.viewPurchaseHistory();
		//
		//LinkedList<Product> lastCart = purchaseHistory.undoingLastPurchase();
		//if (lastCart != null) {
		//  shoppingCart.setCart(lastCart);
		//  System.out.println("Last purchase undone.");
		//} else {
		//  System.out.println("No purchase history available to undo.");
		//}
		//
		//System.out.println("View cart after undoing");
		//shoppingCart.viewCart();
		//
		//System.out.println("------------Customer Request-------------");
		//customerService.addRequest("My laptop keyboard is not working");
		//customerService.viewPendingRequests();
		//customerService.processRequest();
		
		
		System.out.println("-------------User Input-----------------");
		
        while(true) {
             
        	 System.out.println("Choose an option:");
             System.out.println("1. Add item to cart");
             System.out.println("2. Remove item from cart");
             System.out.println("3. View cart");
             System.out.println("4. Checkout");
             System.out.println("5. Undo last purchase");
             System.out.println("6. View purchase history");
             System.out.println("7. Add customer service request");
             System.out.println("8. Process customer service request");
             System.out.println("9. View pending customer service requests");
             System.out.println("0. Exit");
             
             
             int choice=Integer.parseInt(in.nextLine().trim());
             switch (choice) {
             case 1:
                 System.out.print("Enter product name: ");
                 String productName = in.nextLine();
                 System.out.print("Enter product price: ");
                 double productPrice = in.nextDouble();
                 in.nextLine();  
                 Product product = new Product(productName, productPrice);
                 shoppingCart.addItem(product);
                 System.out.println("Product is added");
         
                 break;
             case 2:
                 System.out.print("Enter product name to remove: ");
                 String removeProductName = in.nextLine();
                 shoppingCart.removeItem(removeProductName);
                 break;
             case 3:
                 System.out.println("Items in cart:");
                 shoppingCart.viewCart();
                 break;
             case 4:
                 LinkedList<Product> currentCartChoice = shoppingCart.getCart();
                 purchaseHistory.saveCurrentCart(currentCartChoice);;
                 shoppingCart.clearCart();
                 System.out.println("Checked out successfully!");
                 break;
             case 5:
                 LinkedList<Product> lastCartChoice = purchaseHistory.undoingLastPurchase();
                 if (lastCartChoice != null) {
                     shoppingCart.setCart(lastCartChoice);
                     System.out.println("Last purchase undone.");
                 } else {
                     System.out.println("No purchase history available to undo.");
                 }
                 break;
             case 6:
                 System.out.println("Purchase history:");
                 purchaseHistory.viewPurchaseHistory();
                 break;
             case 7:
                 System.out.print("Enter customer service request: ");
                 String request = in.nextLine();
                 customerService.addRequest(request);
                 break;
             case 8:
                 System.out.println("Processing customer service request:");
                 customerService.processRequest();
                 break;
             case 9:
                 System.out.println("Pending customer service requests:");
                 customerService.viewPendingRequests();
                 break;
             case 0:
                 break;
             default:
                 System.out.println("Invalid choice");
                 break;
         }
        }
	}
}


