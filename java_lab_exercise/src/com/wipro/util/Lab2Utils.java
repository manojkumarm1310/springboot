package com.wipro.util;

import java.util.*;

public class Lab2Utils {
	public static int secondSmallest(int arr[]) {
		int min=arr[0];
		int secMin=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>min) {
				secMin=min;
				min=arr[i];
				
			}
			else if(arr[i]<secMin && arr[i]!=min) {
				secMin=arr[i];
			}
		}
		return secMin;
	}

	public static String[] sortArray(String strArr[]) {
		Arrays.sort(strArr);
		String[] resultArr=new String[strArr.length];
		for(int i=0;i<strArr.length;i++) {
			if(i<(strArr.length/2)+1) {
				resultArr[i]=strArr[i].toUpperCase();
			}else {
				resultArr[i]=strArr[i].toLowerCase();
			}
		}
		return resultArr;
	}
	public static int[] reverseAndSort(int arr[]) {
		int resultArr[]=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			int N=arr[i];
			int res=0;
			while(N!=0) {
				res=res*10+(N%10);
				N/=10;
			}
			resultArr[i]=res;
		}
		Arrays.sort(resultArr);
		return resultArr;
	}
	public static int[] removeDuplicate(int arr[]) {
		HashSet<Integer> set=new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			set.add(arr[i]);
		}
		int resultArr[]=new int[set.size()];
		int c=0;
		for(int s:set) {
			resultArr[c++]=s;
		}
		for(int i=0;i<resultArr.length;i++) {
			for(int j=0;j<resultArr.length;j++) {
				if(resultArr[i]<resultArr[j]) {
					int temp=resultArr[i];
					resultArr[i]=resultArr[j];
					resultArr[j]=temp;
				}
			}
		}
		return resultArr;
		
	}
}
