package com.wipro.inheritance;
public class Square extends Shape{
	private Integer side;
	
	public Square() {
		
	}
	
	public Square(Integer side) {
		this.side = side;
	}
	
	
	public Integer getSide() {
		return side;
	}
	public void setSide(Integer side) {
		this.side = side;
	}
	@Override
	public double getArea() {
		return this.side * this.side;
	}
}


