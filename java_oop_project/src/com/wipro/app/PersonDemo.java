package com.wipro.app;
import java.time.LocalDate;

import java.util.Scanner;

import com.wipro.model.Person;
public class PersonDemo {
	private static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter number of person");
		int N=Integer.parseInt(in.nextLine());
		Person person[]=new Person[N];
		getPerson(person);
		showPerson(person);

	}
	public static void showPerson(Person person[]) {
		for(Person p:person) {
			System.out.println(p);
		}
	}
	public static void getPerson(Person person[]) {
		for(int i=0;i<person.length;i++) {
			System.out.println("Enter adhaar Number of person "+(i+1));
			Long adharCard=in.nextLong();
			in.nextLine();
			System.out.println("Enter Name of person "+(i+1));
			String name=in.nextLine().trim();
			
			System.out.println("Enter gender person "+(i+1));
			String gender=in.nextLine().trim();
			
			System.out.println("Enter birth of date of person (yyyy-mm-dd)"+(i+1));
			String birthdate = in.nextLine();
			LocalDate birthDate=LocalDate.parse(birthdate);
			
			System.out.println("Enter Address of person "+(i+1));
			String address=in.nextLine().trim();
			
			System.out.println("Enter mobile number of person "+(i+1));
			Long mobile=in.nextLong();
			
//			person[i]=new Person(adharCard,name,gender,birthDate,address,mobile);
			
		}
	}

}

//
//package com.wipro.app;
//import java.time.LocalDate;
//import java.util.Scanner;
//import com.wipro.model.GenderType;
//import com.wipro.model.Person;
//public class PersonDemo {
//	private static Scanner scanner = new Scanner(System.in);
//	public static void main(String[] args) {
//		System.out.println("Enter number of persons: ");
//		int size = Integer.parseInt(scanner.nextLine());
//		Person persons[] = new Person[size];
//		getPersons(persons);
//		
//		System.out.println("The following persons belong to "+ Person.getCountry());
//		showPersons(persons);
//	}
//	private static void getPersons(Person[] persons) {
//		for(int i=0;i<persons.length;i++) {
//			Person person =  new Person();
//			System.out.println("Enter adhar card of person:"+ (i+1));
//			person.setAdharCard(Long.parseLong(scanner.nextLine()));
//			System.out.println("Enter name: ");
//			person.setName(scanner.nextLine());
//			try {
//				System.out.println("Enter birthdate(yyyy-mm-dd): ");
//				person.setBirthdate(LocalDate.parse(scanner.nextLine()));
//			} catch(Exception e) {
//				System.out.println("Invalid date");
//				person.setBirthdate(null);
//			}
//			System.out.println("Enter gender(MALE/FEMALE/TRANSGENDER/UNKNOWN): ");
//			String genderAsString = scanner.nextLine();
//			person.setGender(Enum.valueOf(GenderType.class,genderAsString));
//			
//			System.out.println("Enter address: ");
//			person.setAddress(scanner.nextLine());
//			
//			System.out.println("Enter 10-digit  mobile number: ");
//			person.setMobile(Long.parseLong(scanner.nextLine()));
//			
//			persons[i] = person;
//		}
//		
//	}
//	private static void showPersons(Person[] persons) {
//		for(Person p: persons) {
//			System.out.println(p);
//		}
//		
//	}
//}
