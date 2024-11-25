package com.wipro.inheritance;
public class ShapeDemo {
	public static void main(String[] args) {
		Shape shapes[] =  new Shape[5];
		shapes[0] = new Square(5);
		shapes[1] = new Circle(5);
		shapes[2] = new Square(50);
		shapes[3] = new Circle(50);
		shapes[4] = new Square(1);
		
		for(Shape s: shapes) {
//			System.out.println();
			if( s instanceof Square) {
				System.out.print("Area of square is ");
			}else {
				System.out.print("Area of circle is ");
			}
			System.out.println(s.getArea());
		}
		
	}
}
