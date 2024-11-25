package com.wipro.Lab2;

import java.util.Arrays;
import java.util.Scanner;

import com.wipro.util.Lab2Utils;

public class Lab2 {
	private static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a arr length: ");
		int N=Integer.parseInt(in.nextLine());
		int arr[]=new int[N];
		setArray(arr);
		System.out.println("Second largest element: "+Lab2Utils.secondSmallest(arr));
		String[] strArr=new String[N];
		setStringArray(strArr);
		System.out.println(Arrays.toString(Lab2Utils.sortArray(strArr)));
		System.out.println("reversing an array element and sort");
		setArray(arr);
		System.out.println(Arrays.toString(Lab2Utils.reverseAndSort(arr)));
		System.out.println("Remove duplicate");
		setArray(arr);
		System.out.println(Arrays.toString(Lab2Utils.removeDuplicate(arr)));
		
		
		

	}
	public static void setStringArray(String[] strArr) {
		for(int i=0;i<strArr.length;i++) {
			System.out.print("String arr["+i+"] : ");
			strArr[i]=in.nextLine().trim();
		}
	}
	public static void setArray(int arr[]) {
		System.out.println("Enter a elements");
		for(int i=0;i<arr.length;i++) {
			System.out.print((i+1)+"->");
			arr[i]=Integer.parseInt(in.nextLine().trim());
		}
	}
}
