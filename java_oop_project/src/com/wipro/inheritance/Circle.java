package com.wipro.inheritance;
public class Circle extends Shape {
	public static final double PI=3.14;
	private Integer radius;
	public Circle() {
	}
	public Circle(Integer radius) {
		this.radius=radius;
	}
	public Integer getRadius() {
		return radius;
	}
	public void setRadius(Integer radius) {
		this.radius = radius;
	}
	@Override
	public double getArea() {
		return  PI*this.radius*this.radius;
	}
	
	
}


