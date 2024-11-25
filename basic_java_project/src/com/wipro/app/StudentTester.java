package com.wipro.app;
import java.util.Arrays;
import java.util.Scanner;
public class StudentTester {
	private static Scanner scanner  = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter number of students: ");
		int n = Integer.parseInt(scanner.nextLine());
		
//		int marks[] = new int[n];
//		
//		enterMarks(marks);
//		showMarks(marks);
//		
//		Arrays.sort(marks); //ascending order by default
//		
//		System.out.println("After sorting..");
//		System.out.println(Arrays.toString(marks));
		
		String name[]=new String[n];
		acceptNames(name);
		
		System.out.println(Arrays.toString(name));
//		displayName(name);
		
	}
	public static void acceptNames(String names[]) {
		for(int i=0;i<names.length;i++) {
			System.out.println("Enter Names of student: " + (i+1));
			names[i]= scanner.nextLine();
		}
	}
	public static void displayName(String names[]) {
		for(String name:names) {
			System.out.println(name);
		}
	}
	

	
	private static void enterMarks(int[] marks) {
		for(int i=0;i<marks.length;i++) {
			System.out.println("Enter marks of student: " + (i+1));
			marks[i]= Integer.parseInt(scanner.nextLine());
		}
		
	}
	private static void showMarks(int[] marks) {
		for(int m: marks) {
			System.out.println(m);
		}
		
	}
	
	
}

