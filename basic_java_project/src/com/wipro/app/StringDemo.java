package com.wipro.app;

public class StringDemo {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3= new String("Hello");
		String s4 = new String("Hello");
		System.out.println(s1==s2); //true
		System.out.println(s3==s4); //false
		/*
	* They return same hashcodes because the String class has overridden equals()
		 * and hashCode() methods.
		 */
		System.out.println(s1.hashCode()+","+s2.hashCode()+","+s3.hashCode()+","+s4.hashCode());
		System.out.println(s1.equals(s2)+","+s1.equals(s3)+","+s2.equals(s4));
	}
}
