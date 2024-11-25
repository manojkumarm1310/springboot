package com.wipro.Lab6;



import java.util.ArrayList;

import java.util.Collections;

import java.util.HashMap;

import java.util.Map;

import java.util.Scanner;



public class Lab6 {

	private static Scanner in=new Scanner(System.in);

public static void main(String[] args) {



	HashMap<Integer,Integer> map=new HashMap<>();

	int N=Integer.parseInt(in.nextLine());

	setMap(map,N);

	System.out.println(sortedList(map));

	char[] charArr=new char[N];

	setCharArr(charArr);

	countCharacter(charArr);

	System.out.println("value and their Square hashMap");

	int[] arr=new int[N];

	getSquares(arr);

	getStudents();

}

public static void getStudents() {

	System.out.println("Enter the number of students:");

	int N=Integer.parseInt(in.nextLine());

	System.out.println("Enter the students Id and marks:");

	HashMap<String,Integer> stdIdMark=new HashMap<>();

	for(int i=0;i<N;i++) {

		System.out.println("Student "+i+ " Details");

		System.out.print("Student ID "+i+ " : ");

		String key=in.nextLine();

		System.out.print("Student Mark"+i+" : ");

		int value=Integer.parseInt(in.nextLine());

		stdIdMark.put(key,value);

	}

	System.out.println(stdIdMark);

	HashMap<String,String> stdIdMedal=new HashMap<>();

	for(String Id:stdIdMark.keySet()) {

		if(stdIdMark.get(Id)>=90) {

			stdIdMedal.put(Id, "Gold");

		}else if(stdIdMark.get(Id)>=80) {

			stdIdMedal.put(Id, "Silver");

		}else if(stdIdMark.get(Id)>=70) {

			stdIdMedal.put(Id, "Bronze");

		}

	}

	System.out.println(stdIdMedal);

}

public static void getSquares(int arr[]) {

	System.out.println("Enter keys");

	Map<Integer,Integer> map=new HashMap<>();

	for(int i=0;i<arr.length;i++) {

		arr[i]=Integer.parseInt(in.nextLine());

	}

	for(int i=0;i<arr.length;i++) {

		map.put(arr[i],arr[i]*arr[i]);

	}

	System.out.println(map);

	

}

public static void countCharacter(char[] charArr) {

	HashMap<Character,Integer> map=new HashMap<>();

	

	for(int i=0;i<charArr.length;i++) {

		if(map.containsKey(charArr[i])) {

			map.put(charArr[i], map.get(charArr[i])+1);

		}else {

			map.put(charArr[i],1);

		}

	}

	System.out.println(map);

}



public static void setCharArr(char[] charArr) {

	System.out.println("Enter a characters:");

	for(int i=0;i<charArr.length;i++){

		System.out.print("Enter a character "+i+"th : ");

		charArr[i]=in.nextLine().charAt(0);

	}

}

public static ArrayList<Integer> sortedList(HashMap<Integer,Integer> map){

	ArrayList<Integer> values = new ArrayList<>(map.values());

    Collections.sort(values);

    return values;

}

public static void setMap(HashMap<Integer,Integer> map,int N) {

	System.out.println("Enter a map values");

	for(int i=0;i<N;i++) {

		System.out.print("Key is "+i+ " value is ");

		map.put(i, Integer.parseInt(in.nextLine()));

	}

	

}

}

