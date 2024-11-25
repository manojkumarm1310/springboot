package com.wipro.util;

public class Lab1Utils {
	public static int findCube(int N) {
		int res=0;
		int rem=0;
		while(N!=0) {
			rem=N%10;
			res+=rem*rem*rem;
			N/=10;
		}
		return res;
	}
	public static void signalCheck(String color) {
		switch(color) {
		case "RED":
			System.out.println("Stop");
			break;
		case "YELLOW":
			System.out.println("Ready");
			break;
		case "GREEN":
			System.out.println("Go");
			break;
		default:
			System.out.println("You have entered wrong color");
		}
	}
	
	public static int fibonacciNonRecursive(int n) {
		int first=0;
		int second=1;
		int third=0;
		for(int i=2;i<=n+1;i++) {
			third=first+second;
			first=second;
			second=third;
		}
		return third;
	}
	public static int fibonacciRecursive(int n) {
		if(n<=1) {
			return n;
		}
		return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
	}
	public static void primeNumbers(int n) {
		for(int i=2;i<=n;i++) {
			boolean isPrime=true;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
					isPrime=false;
				}
				
			}
			if(isPrime) {
				System.out.print(i+" ");
			}
		}
	}
	public static int firstNNaturalNumber(int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			if(i%3==0 || i%5==0) {
				sum+=i;
			}
		}
		return sum;
	}
	public static int difference(int n) { 
		int sum1=0;
		int sum2=(n*(n+1))/2;
		System.out.println(sum2);
		for(int i=1;i<=n;i++) {
			sum1+=i*i;
		}
		return sum1-(sum2*sum2);
		
	}
	public static boolean isIncreasingOrder(int n) {
		
		String num=Integer.toString(n);
		for(int i=0;i<num.length()-1;i++) {
			if(num.charAt(i)>num.charAt(i+1)) {
				return false;
			}
		}
		
		return true;
	}
	public static boolean isPowerOfTwo(int n) {
		if(n<=0) {
			return false;
		}
		return (n & (n-1))==0;
	}
}
