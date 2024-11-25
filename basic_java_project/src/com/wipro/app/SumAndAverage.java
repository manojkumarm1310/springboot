package com.wipro.app;

public class SumAndAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length==0) {
			System.out.println("Please enter command-line arguments");
		}else {
			try {
				int total=0;
				for(String  x:args) 
					total+=Integer.parseInt(x);
				System.out.println("Sum : "+total+ " || Average : "+(double)total/args.length);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			catch(Exception e) {
				System.out.println("Invalid Data");
			}
		}

	}

}
