package com.wipro.interfac;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import com.wipro.model.GenderType;
import com.wipro.model.Person;
//import com.wipro.model.PersonNameComparator;
public class PersonTester {
	public static void main(String[] args) {
		Person persons[] = new Person[5];
		populatePersons(persons);
		showPersons(persons);
		
		Arrays.sort(persons);
		System.out.println("\nAfter sorting based on adhar cards..");
		showPersons(persons);
		
		System.out.println("After sorting based on names..");
		Arrays.sort(persons, new PersonNameComparator());
		showPersons(persons);
		
		System.out.println("After sorting based on address..");
		Arrays.sort(persons, ( new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAddress().compareTo(o2.getAddress());
			}
		
		}) );
		
		showPersons(persons);
		
	}
	private static void showPersons(Person[] persons) {
		for(Person p: persons) {
			System.out.println(p);
		}
		
	}
	private static void populatePersons(Person[] persons) {
		persons[0] =  new Person(923456789987L,"Smith",
				GenderType.MALE,LocalDate.of(1995, 10,11),"New Delhi",9878986789L);
		persons[1] =  new Person(723456009981L,"Lakshmi",
				GenderType.FEMALE,LocalDate.of(1999, 10,15),"Pune",7871286700L);
		persons[2] =  new Person(523456789900L,"Clarke",
				GenderType.MALE,LocalDate.of(2000, 1,1),"Mumbai",8878900785L);
		persons[3] =  new Person(123456789980L,"Priya",
				GenderType.FEMALE,LocalDate.of(1999, 6,5),"New Delhi",7898986780L);
		persons[4] =  new Person(523456755987L,"Ravi Kumar",
				GenderType.MALE,LocalDate.of(1998, 10,20),"Hyderabad",9123986755L);
		
		
	}
}
