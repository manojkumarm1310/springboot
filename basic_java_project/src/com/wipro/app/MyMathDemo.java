package com.wipro.app;

import com.wipro.util.MyMath;

public class MyMathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Factorial : "+MyMath.factorial(5));
		System.out.println("Is Prime : "+MyMath.isPrime(37));
		System.out.println("Sum of prime : "+MyMath.sumOfPrimes(10));
		System.out.println("Is Perfect Number : "+MyMath.isPerfectNumber(6));
		MyMath.fibonacci(15);
		System.out.println("Sum of Cubes : "+ MyMath.sumOfCubes(1234));
	}

}
