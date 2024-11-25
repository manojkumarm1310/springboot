
package com.wipro.app;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DateTester {
	public static Scanner in=new Scanner(System.in);
	private static Scanner scanner = new Scanner(System.in);
	/*
	   2024-07-31
		02:42:23.305478
		2024-07-31T02:42:23.306545400
	 */
	public static void main(String[] args) {
//		LocalDate today= LocalDate.now(); //yyyy-mm-dd
//		System.out.println(today);
//		LocalTime currentTime = LocalTime.now();
//		System.out.println(currentTime);
//		LocalDateTime todayDateAndTime = LocalDateTime.now();
//		System.out.println(todayDateAndTime);
//		LocalDate hiredate = LocalDate.of(2023, 10, 15);
//		LocalTime birthTime = LocalTime.of(10, 16,10);
//		LocalDateTime childBirthDateTime = LocalDateTime.of(2022,12,16,10,15,30);
//		System.out.println(hiredate);
//		System.out.println(birthTime);
//		System.out.println(childBirthDateTime);
//		//get years,months, days etc from the above objects
//		System.out.println(today.getYear());
//		if(hiredate.isAfter(today)) {
//			System.out.println("Invalid hiredate");
//		}else {
//			System.out.println("Hiredate is valid");
//		}
//		try {
//			//converting String object to LocalDate object
//			System.out.println("Enter birthdate(yyyy-mm-dd): ");
//			String birthdateAsString = scanner.nextLine();
//			LocalDate birthdate = LocalDate.parse(birthdateAsString);
//			System.out.println(birthdate);
//			System.out.println("Enter admission date(dd/mm/yyyy): ");
//			String admissionAsString = scanner.nextLine();
//			DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//			LocalDate admissionDate = LocalDate.parse(admissionAsString, formatter);
//			System.out.println(admissionDate);//yyyy-MM-dd
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
		try {
			System.out.println("Enter order date(dd/mm/yyyy): ");
			String orderDateAsString = scanner.nextLine();
			DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate orderDate = LocalDate.parse(orderDateAsString, formatter);
			System.out.println(orderDate);
			
			System.out.println("Enter Shipment date(dd/mm/yyyy): ");
			String shipmentDateAsString = scanner.nextLine();
			formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate shipmentDate = LocalDate.parse(shipmentDateAsString, formatter);
			System.out.println(shipmentDate);
			
			System.out.println("Enter received date(dd/mm/yyyy): ");
			String receivedDateAsString = scanner.nextLine();
			formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate receivedDate = LocalDate.parse(receivedDateAsString, formatter);
			System.out.println(receivedDate);
			
			if(orderDate.isBefore(shipmentDate)|| orderDate.isEqual(shipmentDate)) {
				if(shipmentDate.isBefore(receivedDate) || shipmentDate.isEqual(receivedDate)) {
					System.out.println("Date are in Order");
				}
				else {
					System.out.println("shipment Date is Wrong");
				}
			}else {
				System.out.print("Order Date is wrong");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
