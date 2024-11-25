package com.wipro.lab3;

import java.util.Scanner;
public class Lab3 {

	private static Scanner in=new Scanner(System.in);

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		System.out.println("Enter a string (exercise 1)");

		String str=in.nextLine();

		displayInteger(str);

		System.out.println("Enter string (Mirror Image)");

		str=in.nextLine();

		mirrorImage(str);

		

		System.out.println("Enter a string (Replace all consonants in the string with next alphabet: )");

		str=in.nextLine();

		replaceAlphabet(str);

		

		System.out.println("Enter a string(modifyNumber): )");

		str=in.nextLine();

		modifyNumber(str);

	

		



	}

	

	public static void modifyNumber(String str) {

		StringBuffer sb=new StringBuffer();

		for(int i=0;i<str.length()-1;i++) {

			int first=str.charAt(i)-'0';

			int second=str.charAt(i+1)-'0';

			int diff=Math.abs(second-first);

			sb.append(Integer.toString(diff));

		}

		sb.append(str.charAt(str.length()-1));

		System.out.println(sb);

	}

	public static void replaceAlphabet(String str) {

		 	StringBuffer result = new StringBuffer();

	        for (char ch : str.toCharArray()) {

	            if (isConsonant(ch)) {

	                char nextChar = (char) (ch + 1);

	                result.append(nextChar);

	            } else {

	               result.append(ch);

	            }

	        }

	        System.out.println(result.toString());

	}

	public static boolean isConsonant(char ch) {

        ch = Character.toLowerCase(ch);

        return (ch >= 'a' && ch <= 'z') && !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');

    }

    


	public static void mirrorImage(String str) {

		StringBuffer sb=new StringBuffer(str);

		System.out.println(str+"|"+sb.reverse());

	}

	public static void displayInteger(String str) {

		String split[]=str.split(" ");

		int total=0;

		for(int i=0;i<split.length;i++) {

			int val=Integer.parseInt(split[i]);

			total+=val;

			System.out.print(val+ " ");

		}

		System.out.println();

		System.out.println("sum of the Integers: "+total);

	}



}