
package com.wipro.inheritance;
public class Tester {
	public static void main(String[] args) {
		//bobj refers to an object in the heap that is allocated memory for both a and b
		B bobj = new B(10);
		System.out.println(bobj.getA()+","+bobj.getB());//null,10
		
		B bobj1 = new B(5,10);
		System.out.println(bobj1.getA()+","+bobj1.getB()); //null,10
		
		
	}
}
