package com.wipro.inheritance;
public class Surgeon extends Doctor{
	@Override
	public void treatPatient() {
		super.treatPatient();
		System.out.println("Preparing for operation tomorrow morning ealry hours");
	}
	
	public void makeIncision() {
		System.out.println("Cut the skin upto 5 cms of forearm biceps..");
	}
	
}


