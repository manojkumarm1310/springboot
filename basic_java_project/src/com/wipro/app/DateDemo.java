package com.wipro.app;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
public class DateDemo {
	public static void main(String[] args) {
		Date today = new Date();
		//Tue Jul 30 15:32:45 IST 2024
		System.out.println(today);
		LocalDate todayAgain = LocalDate.now();
		//2024-07-30
		System.out.println(todayAgain);
		LocalTime timeNow = LocalTime.now();
		//15:35:22.514347
		System.out.println(timeNow);
		
		LocalDateTime todayIncludingTime = LocalDateTime.now();
		//2024-07-30T15:36:55.902156
		System.out.println(todayIncludingTime);
		
		System.out.println(timeNow.getHour());
		System.out.println(todayIncludingTime.getHour());
		
		greeting(timeNow.getHour());
	}
	private static void greeting(int currentTime) {
		if(currentTime<12) {
			System.out.print("Good Morning");
		}
		else if(currentTime<17) {
			System.out.print("Good afternoon");
		}
		else if(currentTime<22) {
			System.out.print("Good Evening");
		}else
		{
			System.out.print("Good Night");
		}
	}
}
