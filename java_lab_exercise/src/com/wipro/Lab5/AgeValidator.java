package com.wipro.Lab5;

public class AgeValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            validateAge(10); 
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        try {
            validateAge(20);  
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
	}
	 public static void validateAge(int age) throws InvalidAgeException {
	        if (age <= 15) {
	            throw new InvalidAgeException("Age must be above 15.");
	        } else {
	            System.out.println("Age is valid.");
	        }
	    }
}
