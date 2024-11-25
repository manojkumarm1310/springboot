package com.wipro.app;

import java.util.Scanner;

public class ControlsDemo {
//	private Scanner scanner = new Scanner(System.in);
	private static Scanner scanner = new Scanner(System.in);
			
	public static void main(String[] args) {
//		Scanner myScanner = new Scanner(System.in);
//		int number = myScanner.nextInt();
		
//		System.out.println("Enter a number: ");
//		int number = new ControlsDemo().scanner.nextInt();
//		int number = scanner.nextInt();
		
//		if( isEven(number)) {
//			System.out.println(number +" is a even number");
//		}else {
//			System.out.println(number+" is an odd number");
//		}
//		
//		//---------------------------
//		
//		System.out.println("Enter Three Numbers:");
//		int first=scanner.nextInt();
//		int second=scanner.nextInt();
//		int third= scanner.nextInt();
//		System.out.println("Maximum number is "+ getMaximum(first,second,third));
		
		//------------------------
		
		System.out.println("Enter a mark");
		int mark=scanner.nextInt();
		showGrade(mark);

	}
	private static void showGrade(int mark) {
//		if(mark>=80 && mark<=100) {
//			System.out.println("Grade is A+");
//		}
//		else if(mark>=60) {
//			System.out.println("Grade is A");
//		}
//		else if(mark>=50) {
//			System.out.println("Grade is B");
//		}
//		else if(mark>=40) {
//			System.out.println("Grade is C");
//		}
//		else{
//			System.out.println("Fail");
//		}
//		
		System.out.println(mark>=80 && mark<=100 ? 
							"Grade is A+" : 
								mark>=60 ? 
										"Grade is A":
											mark>=50 ?
													"Grade is B":
														mark>=40 ?
																"Grade is C":
																	"Fail");
	}
	
	
	private static boolean isEven(int number) {
		if(number%2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	private static int getMaximum(int first,int second,int third) {
		if(first>second && first > third) {
			return first;
		}
		else if(second>first && second>third) {
			return second;
		}
		
		return third;
	}
	
}

