package com.wipro.Lab9;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Lab9 {
	public static void main(String[] args) {

		BiFunction<Double, Double, Double> power = (x, y) -> Math.pow(x, y);
		System.out.println(power.apply(2.0, 3.0));

		StringModifier sm=(str)->{
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<str.length();i++) {
				if(i!=str.length()-1) {
					String newStr=str.charAt(i)+" ";
					sb.append(newStr);
				}
				else {
					sb.append(str.charAt(i));
				}
			}
			return sb.toString();
		};
		
		System.out.println(sm.stringmodifier("CG"));

		BiPredicate<String, String> authenticate = (username, password) -> "manojkumar".equals(username) && "1234567890".equals(password);
        System.out.println(authenticate.test("manojkumar", "1234567890"));


	}
}
