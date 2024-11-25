
package com.wipro.app;
/*
* To iterate an array, we can use for loop or for each loop
*
* Syntax of for loop:
* 	for(intialization;condition;updation){
*     --------;
*     --------;
*  }
* 
*  Syntax of for each loop
*  for( datatype identifier: arrayName){
*  	within the loop, identifier contains value
*    1st iteration,  identifier contains value at first position,
*    2nd iteration, identifier contains value at second position, and so on
*  }
*/
public class CommandLineDemo {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("Please enter command-line arguments");
		}else {
			System.out.println("You have entered "+ args.length+" arguments");
			
			System.out.println("Using for loop..");
			for(int i=0 ; i<args.length;i++) {
				System.out.println(args[i]);
			}
			
			System.out.println("Using for each loop...");
			for(String s : args) {
				System.out.println(s);
			}
		}
		try {
			for(String s: args) {
				System.out.println(Integer.parseInt(s));
			}
		}catch(NumberFormatException e) {
			System.out.println("Invalid data");
		}

	System.out.println("End of the program");
}
}

