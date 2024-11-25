package com.wipro.app;
import java.util.Scanner;
import com.wipro.model.GenderType;
public class GenderDemo {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		GenderType gender =  GenderType.FEMALE;
		System.out.println(gender);//MALE
		
		System.out.println("---------------------------------");
		for(GenderType g: GenderType.values()) {
			System.out.println(g.ordinal()+","+g.name());
		}
		System.out.println("Enter gender");
		String genderAsString = scanner.nextLine();
		//compare String and enum value
		if(genderAsString.equals(GenderType.MALE.toString())) {
			System.out.println("Male");
		}
		
		System.out.println("-----------------------------");
		
		switch(gender) {
			case MALE:
						System.out.println("Male");
						break;
			case FEMALE:
						System.out.println("Female");
						break;	
		}
	}
}
