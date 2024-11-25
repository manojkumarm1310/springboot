package com.wipro.util;

public class MyMath {
	
	public static boolean isPerfectNumber(int number) {
		int total=0;
		for(int i=1;i<=number/2;i++) {
			if(number%i==0) {
				total+=i;
			}
		}
		if(total==number) {
			return true;
		}
		return false;
	}
	
	public static void fibonacci(int number) {
		int first=0;
		int second=1;
		System.out.print(first+" "+second+" ");
		int third=0;
		for(int i=2;i<number;i++) {
			third=first+second;
			if(third>number) {
				break;
			}
			first=second;
			second=third;
			System.out.print(third+" ");
		}
		System.out.println();
	}
	public static long sumOfCubes(int number) {
		int rem=0;
		int res=0;
		while(number!=0) {
			rem=number%10;
			res+=rem*rem*rem;
			number/=10;
		}
		return res;
	}
	
	public static long factorial(int number) {
		if(number==0 || number==1) {
			return 1;
		}
		return number*factorial(number-1);
	}
	public static boolean isPrime(int number) {
		boolean  prime=false;
		for(int i=2;i<=number/2;i++) {
			if(number%i==0) {
				prime=true;
			}
		}
		if(prime) {
			return false;
		}
		return true;
	}
	
	public static long sumOfPrimes(int number) {
		long total=0;
		for(int i=2;i<=number;i++) {
			if(isPrime(i)) {
				total+=i;
			}
		}
		return total;
	}
}
