package com.wipro.app;
import java.util.Arrays;

import com.wipro.model.Car;
import com.wipro.model.Engine;
import com.wipro.model.Tyre;
public class CarDemo {
	public static void main(String[] args) {
		Engine engine = new Engine(123456789L,"Petrol",2000.0);
		Tyre tyres[] = new Tyre[] {
									new Tyre("MRF",21),
									new Tyre("MRF",21),
									new Tyre("MRF",21),
									new Tyre("MRF",21)
								};
		
		
		//constructor injection
		Car myCar = new Car("Maruti","Swift DeZire",engine,tyres);
		System.out.println("My Car Details..\n"+ myCar);
		
		//setter injection
		Car myAnotherCar = new Car();
		myAnotherCar.setSupplierName("BMW");
		myAnotherCar.setModel("X3");
		myAnotherCar.setEngine(new Engine(768768789L,"Petrol",3500.50));
		myAnotherCar.setTyres(new Tyre[] {
									new Tyre("APPOLLO",23),
									new Tyre("APPOLLO",23),
									new Tyre("APPOLO",23),
									new Tyre("APPOLO",23)
							});
		
		
		System.out.println(myAnotherCar);
		Engine oldEngine=myCar.getEngine();
		myCar.setEngine(null);
		myCar.getTyres()[3]=null;
		System.out.println(Arrays.toString(myCar.getTyres()));
		System.out.println(myCar);
		
	}
}
