package com.wipro.app;
/**
* StringBuffer methods:
* Methods that are common between String and StringBuffer class:
* 		charAt(), indexOf(), lastIndexOf(), isEmpty(), isBlank(), matches(),
* 		contains(), length(), substring(), equals(), hashCode() etc
* Methods specific to StringBuffer:
* 		append(), insert(), delete() and reverse()
*/
public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		
		StringBuffer sb2 = new StringBuffer("Good Day");
		String s1 = "Hello, How Are You";
		//String -> StringBuffer
		StringBuffer sb3 = new StringBuffer(s1);
		
		//StringBuffer -> String
		String s2 = sb2.toString();
		
		StringBuffer sb4 = sb1.append("Welcome");
		//there 2 references sb1 and sb4 to the StringBuffer object that contains "Welcome"
		System.out.println(sb1+","+sb2+","+sb3+","+sb4);
		
		sb2=null;
		System.out.println(sb2);
		sb1=null;
		System.out.println(sb4);
		sb4=null;
		System.out.println(sb4);
		
		sb3.insert(6, "Hi,");
		System.out.println(sb3);
		
		sb3.deleteCharAt(8);
		System.out.println(sb3);
		
		sb3.delete(6, 8);
		System.out.println(sb3);
		//checking for palindrome
		String str = "malayalaM";
//		String str1 = new StringBuffer(str).reverse().toString();
		if(str.equalsIgnoreCase(new StringBuffer(str).reverse().toString())) {
			System.out.println(str+" is a palindrome");
		}else {
			System.out.println(str+" is not a palindrome");
		}
		
	}
}
