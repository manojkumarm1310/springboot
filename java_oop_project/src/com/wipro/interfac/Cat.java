package com.wipro.interfac;
public class Cat extends Animal implements Pet {
	private String breed;
	private String name;
	
	public Cat() {
		
	}
	public Cat(String animalType, String breed, String name) {
		super(animalType);
		this.breed = breed;
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void listenToMaster() {
		System.out.println("Drink milk..");
		
	}
	@Override
	public void makeSound() {
		System.out.println("Meou meou...");
		
	}
	
	
}


