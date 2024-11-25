package com.wipro.interfac;
/**
* The instances the implementation classes of an interfaces can be
* stored in array of references of interface type
*/
public class AnimalDemo {
	public static void main(String[] args) {
		//Array of references of class, Animal
		Animal animals[] = new Animal[4];
		//Array of references of interface, Pet
		Pet pets[] = new Pet[4];
		
		animals[0] = new Dog("Omnivorous","Labrador","King");
		animals[1] = new Tiger("Carnivorous", "Bengal Tiger");
		animals[2] = new Dog("Omnivorous","Pomaranion","Steffi");
		animals[3] = new Cat("Omnivorous","Persian Cat","Lilly");
		
		
		System.out.println("List of animals ..");
		for(Animal a: animals) {
			System.out.println("==============================");
			System.out.println(a.getAnimalType());
			a.makeSound();
			System.out.println("---------------");
			if(a instanceof Dog) {
			
				Dog d = (Dog) a;
				System.out.println(d.getBreed()+","+ d.getName());
			}else if( a instanceof Cat) {
				Cat c = (Cat)a;
				System.out.println(c.getBreed()+","+c.getName());
			}else {
				Tiger t = (Tiger)a;
				System.out.println(t.getBreed());
			}
		}
		
		//Error since Tiger is not a Pet
//		pets[0] = new Tiger("Carnivorous", "Bengal Tiger");
		
		pets[0] =  new Dog("Omnivorous","Labrador","King");
		pets[1] =  new Cat("Omnivorous","Persian Cat","Lilly");
		pets[2] =  new Dog("Omnivorous","Labrador","King");
		pets[3] =  new Cat("Omnivorous", "Siamese Cat","jhonny");
		
		
		System.out.println("\n\nI have the following pets...");
		System.out.println();
		for(Pet p: pets) {
			if(p instanceof Dog) {
				Dog d = (Dog)p;
				System.out.println(d.getAnimalType()+","+d.getBreed()+","+d.getName());
			}else {
				Cat c = (Cat)p;
				System.out.println(c.getAnimalType()+","+c.getBreed()+","+c.getName());
			}
			p.listenToMaster();
			
		}
	}
}
