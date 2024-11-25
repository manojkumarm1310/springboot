package com.wipro.app;

import java.util.Scanner;

import com.wipro.model.GenderType;
import com.wipro.model.Person;
import com.wipro.model.Professor;
import com.wipro.model.Student;

import java.util.Scanner;
public class PersonManagement {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter number of persons: ");
		final int N = Integer.parseInt(scanner.nextLine());
		
		Person persons[] = new Person[N];
		
		getPersons(persons);
		
		showDetails(persons);
	}
	
	private static void getPersons(Person[] persons) {
		for(int i=0;i<persons.length;i++) {
			System.out.println("Is the person (s)tudent or (p)rofessor: ");
			if(scanner.nextLine().equalsIgnoreCase("s")) {
				Student student = new Student();
				System.out.println("Enter student details seperated with commas in the order of"
						+ " Adhar Card,Name,Gender,Birthdate,Address,Mobile,Class Studying,Section, Roll Number,ranking,email\n");
				String details = scanner.nextLine();
				student.setAdharCard(  Long.parseLong(details.split(",")[0]));
				student.setName(details.split(",")[1]);
				student.setGender(GenderType.valueOf(details.split(",")[2]));
				//TO DO
				
				persons[i] = student;
			}else {
				Professor professor = new Professor();
				//TO DO
				
				
				persons[i] = professor;
				
			}
			
		}
		
	}
	
	private static void showDetails(Person[] persons) {
		for(Person p: persons) {
			if( p instanceof Student) {
				System.out.println("Student details are ..");
			}else {
				System.out.println("Professor details are ..");
			}
			p.showDetails();
		}
		
	}
}
