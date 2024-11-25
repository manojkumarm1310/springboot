package com.wipro.app;
import com.wipro.model.Addition;
/**
* Compiler will first look for exact match, if not perform implicit conversion, still not possibel,'
* compile error
*/
public class MethodOverloadDemo {
	public static void main(String[] args) {
		Addition addition = new Addition();
		
		System.out.println(addition.add(5, 10)); //exact match
		
		// implicit conversion takes place, char -> int
		System.out.println(addition.add('A', 10));
		
		System.out.println(addition.add(3.5f,10));//exact match
		//double -> float is an explicit conversion, compiler will not do this, hence compiler error
//		System.out.println(addition.add(3.5,10));
	}
}
