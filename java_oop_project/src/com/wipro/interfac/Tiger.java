package com.wipro.interfac;
public class Tiger extends Animal{
	private String breed;
	
	public Tiger() {
		
	}
	public Tiger(String animalType, String breed) {
		super(animalType);
		this.breed = breed;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	@Override
	public void makeSound() {
		System.out.println("Roaring..");
		
	}
	
	
}



