package com.wipro.app;
/**
* All the wrapper classes have a static method, parsexxx() that
* take String object as an argument and return corresponding numeric type
* Ex.
* String value = "123";
* int x = Integer.parseInt(value);
*
* Ex.
* String str="123.45";
* double v = Double.parseDouble(str);
*/
public class TypecastDemo {
	public static void main(String[] args) {
		//Type mismatch: cannot convert from double to int
//		int x= 3.15;
		//explicit type casting
		int x = (int)3.15;
		System.out.println(x);
		//Type mismatch: cannot convert from int to boolean
//		boolean flag=0;
		boolean flag = false;
		
		Integer iobj = x; //auto-boxing
		iobj = iobj+1;//valid, auto-unboxing takes place
		System.out.println(iobj);
		
		long result = iobj;//un-boxing
		System.out.println(result);
		//Type mismatch: cannot convert from Integer to Long
//		Long lobj = iobj;//error
		//Cannot cast from Integer to Long
//		Long lobj = (Long)iobj;//error
		Long lobj = iobj.longValue();
		System.out.println(lobj);
		
		
		String value = "123";
		int x1 = Integer.parseInt(value);
		
		String str="123.45";
		double v = Double.parseDouble(str);
		
		System.out.println(x1+","+v);
		
		int y1=124;
		//valid
		Boolean f = (x1>y1);
		Boolean f1 = (x1>y1)?true:false;
		System.out.println(f+","+f1);
	}
}
