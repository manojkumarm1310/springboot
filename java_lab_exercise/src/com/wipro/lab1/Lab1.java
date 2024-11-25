package com.wipro.lab1;

import java.util.Scanner;

import com.wipro.util.Lab1Utils;

public class Lab1 {
	private static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter a number (sum of cubes of the digits)");
		int N=Integer.parseInt(in.nextLine());
		System.out.println("Sum of cube:"+Lab1Utils.findCube(N));
		
		System.out.println("Ensum of square and sqaure of sumter a signal Color");
		String color=in.nextLine().toUpperCase();
		Lab1Utils.signalCheck(color);
		
		System.out.println("Enter a numbe (Fibonacci)");
		N=Integer.parseInt(in.nextLine());
		System.out.println("Non Recursive (Fibonacci): "+Lab1Utils.fibonacciNonRecursive(N));
		System.out.println("Recursive (fibonacci): "+Lab1Utils.fibonacciRecursive(N));
		
		System.out.println("Enter a number to find prime number");
		N=Integer.parseInt(in.nextLine());
		Lab1Utils.primeNumbers(N);
		
		System.out.println("Enter a number (First N number which is divisible by 3 and 5)");
		N=Integer.parseInt(in.nextLine());
		System.out.println("Sum of N natural Number : "+Lab1Utils.firstNNaturalNumber(N));
		
		System.out.println("Enter a number (diff btm sum of square and sqaure of sum )");
		N=Integer.parseInt(in.nextLine());
		System.out.println("Differenece between sum of square and sqaure of sum : "+Lab1Utils.difference(N));
		
		System.out.println("Enter a number (Check if number is increasing order)");
		N=Integer.parseInt(in.nextLine());
		System.out.println("Check if number is increasing order: "+Lab1Utils.isIncreasingOrder(N));
		System.out.println("Enter a number (is power of two): ");
		N=Integer.parseInt(in.nextLine());
		System.out.println(N+ " Is power of Two :"+Lab1Utils.isPowerOfTwo(N));
		
	}

}
