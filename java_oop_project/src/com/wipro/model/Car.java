package com.wipro.model;
import java.util.Arrays;
public class Car {
	private String supplierName;
	private String model;
	private Engine engine;
	private Tyre[] tyres;
	
	
	public Car() {
		
	}
	public Car(String supplierName, String model, Engine engine, Tyre[] tyres) {
		super();
		this.supplierName = supplierName;
		this.model = model;
		this.engine = engine;
		this.tyres = tyres;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Tyre[] getTyres() {
		return tyres;
	}
	public void setTyres(Tyre[] tyres) {
		this.tyres = tyres;
	}
	@Override
	public String toString() {
		return "Car [supplierName=" + supplierName + ", model=" + model + ", engine=" + engine + ", tyres="
				+ Arrays.toString(tyres) + "]";
	}
	
	
}
