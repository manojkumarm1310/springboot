
package com.wipro.app;
/*
* Anonymous Inner class
*/
public class AnonymousDemo {
	public static void main(String[] args) {
		(new Object(){
			public void greeting(){
				System.out.println("Welcome to anonymous inner class");
			}
		}).greeting();
		
		
		(new Object(){
			public void greeting(){
				System.out.println("ThanQ");
			}
		}).greeting();
	}
}
