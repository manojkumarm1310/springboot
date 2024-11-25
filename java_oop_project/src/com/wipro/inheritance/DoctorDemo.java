package com.wipro.inheritance;
public class DoctorDemo {
	public static void main(String[] args) {
		Doctor doctor = new Surgeon();
		doctor.treatPatient();
		
		//The method makeIncision() is undefined for the type Doctor
//		doctor.makeIncision();
		
		
		doctor = new FamilyDoctor();
		doctor.treatPatient();
		doctor = new PediatricDoctor();
		doctor.treatPatient();
		
		System.out.println("-----------------------------------");
		//Array of references of type, Doctor
		Doctor doctors[] = new Doctor[5];
		doctors[0] = new Surgeon();
		doctors[1] = new PediatricDoctor();
		doctors[2] = new Surgeon();
		doctors[3] = new FamilyDoctor();
		doctors[4] = new PediatricDoctor();
		
		for(Doctor d: doctors){
			System.out.println("-------------------");
			if(d instanceof Surgeon) {
				System.out.print("Surgeon: ");
			}else if(d instanceof FamilyDoctor ) {
				System.out.print("Family Doctor: ");
			}else if(d instanceof PediatricDoctor) {
				System.out.print("Pediatric Doctor: ");
			}else {
				System.out.println("Doctor: ");
			}
			d.treatPatient();
			
		}
		
	}
}
