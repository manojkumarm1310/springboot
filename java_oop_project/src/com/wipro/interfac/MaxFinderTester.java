package com.wipro.interfac;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MaxFinderTester {
	public static void main(String[] args) {
		//instance of implementation class can be referred by the interface
		MaxFinder maxFinder = new MaxFinderImpl();
		System.out.println(maxFinder.maximum(100,110));
		//FunctionalInterfaceName objectName = (argument list) -> { implementation }
		MaxFinder maxFinder1 = (int a, int b) -> {
													return (a>b)?a:b;
												};
		
		
		/*
		 * If lamda expression has only one statement then return keyword and
		 * curly braces are optional
		 *
		 */
		MaxFinder maxFinder2 = (a, b) -> (a>b)?a:b;
		System.out.println(maxFinder1.maximum(100,110));
		
		FactorialInterfac fact=(a) -> {
			int factorial=1;
			for(int i=a;i>=1;i--) {
				factorial*=i;
			}
			return factorial;
		};
		System.out.println("Facctorial of 5 : "+fact.findFactorial(5));
		
		Function<Integer,Long> factObj1 = n -> {
			long f=1;
			while(n>0) {
				f *= n--;
			}
			return f;
		};
		System.out.println(factObj1.apply(5));
		
		Predicate<Integer> isPrime= n->{
			for(int i=2;i<=n/2;i++) {
				if(n%i==0) {
					return false;
				}
			}
			return true;
		};
		
		System.out.println("Is Prime : "+isPrime.test(9));
		
		BiConsumer<String ,String> str=(s1,s2)->{
			System.out.println(s1+" "+s2);
		};
		
		str.accept("Hello" , "world");
		
		Consumer<String> consumer1 = System.out::println;
		consumer1.accept("Good Afternoon");
		
	}
}

