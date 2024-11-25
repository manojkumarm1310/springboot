package com.wipro.interfac;
public abstract class Animal {
	//Can be enum type, Herbivorous, Carnivorous, Omnivorous
	private String animalType;
	
	public Animal() {
		
	}
	
	public Animal(String animalType) {
		this.animalType = animalType;
	}
	
	
	
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public abstract void makeSound();
}
