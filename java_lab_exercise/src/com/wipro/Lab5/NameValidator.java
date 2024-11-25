package com.wipro.Lab5;

public class NameValidator {



    public static void validateFullName(String firstName, String lastName) throws InvalidNameException {

        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {

            throw new InvalidNameException("First name and last name must not be blank.");

        } else {

            System.out.println("Full name is valid.");

        }

    }



    public static void main(String[] args) {

        try {

            validateFullName("Manoj", "Kumar");

        } catch (InvalidNameException e) {

            System.out.println("Exception caught: " + e.getMessage());

        }



        try {

            validateFullName("kishore", "");

        } catch (InvalidNameException e) {

            System.out.println("Exception caught: " + e.getMessage());

        }



        try {

            validateFullName("John", "");  // This will throw an exception

        } catch (InvalidNameException e) {

            System.out.println("Exception caught: " + e.getMessage());

        }

    }

}