package com.wipro.inheritance;
/**
* When we create instance of class B, memory ia  allocated for both data members,a and b
*
*
* B bobj = new B();
*
*
*/
public class B extends A {
	private Integer b;
	
	public B() {
		
	}
	
	public B(Integer b) {
		super(); // invokes default constructor method of class B
		this.b=b;
	}
	
	public B(Integer a, Integer b) {
		super(a);//invokes 1-arg constructor method of class A
		this.b=b;
	}
	
	public Integer getB() {
		return this.b;
	}
	
	
	public void showData() {
//		System.out.println(this.b +","+ a);
		System.out.println(this.b +","+ getA());
	}
}
