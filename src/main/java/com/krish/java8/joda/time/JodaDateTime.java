package com.krish.java8.joda.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class JodaDateTime {

	public static void main(String[] args) {
		
		var date = LocalDate.now();		
		System.out.println("Printing Current LocalDate :: "+date);
		System.out.println("Printing Current LocalDate in (MM/dd/yyyy) format :: "+date.getMonthValue()+"/"+date.getDayOfMonth()+"/"+date.getYear());
		System.out.println("Printing DayOfMonth :: "+date.getDayOfMonth());
		System.out.println("Printing MonthValue :: "+date.getMonthValue());
		System.out.println("Printing Year Value :: "+date.getYear());
		System.out.println("Printing Day of Week :: "+date.getDayOfWeek());
		var time = LocalTime.now();
		System.out.println("Printing Current LocalTime :: "+time);
		System.out.println("Printing Hours Value :: "+time.getHour());
		System.out.println("Printing Minuites Value :: "+time.getMinute());
		System.out.println("Printing Secondss Value :: "+time.getSecond());
		System.out.println("Printing Nano Value :: "+time.getNano());
		var dt = LocalDateTime.now();
		System.out.println("Printing Current LocalDateTime :: "+dt);
		System.out.println("Printing DayOfMonth :: "+dt.getDayOfMonth());
		System.out.println("Printing MonthValue :: "+dt.getMonthValue());
		System.out.println("Printing Year :: "+dt.getYear());
		System.out.println("Printing Hours Value :: "+dt.getHour());
		System.out.println("Printing Minutes Value :: "+dt.getMinute());
		System.out.println("Printing Seconds Value :: "+dt.getSecond());
		System.out.println("Printing Nano Value :: "+dt.getNano());
		System.out.println("Printing Particular Date using LocalDateTime factory method ::");
		var dt1 = LocalDateTime.of(1995, Month.MAY,28,12,45);
		System.out.println(dt1);
		System.out.println("Printing After 6 Months :: "+dt1.plusMonths(6));
		System.out.println("Printing Before 6 Months :: "+dt1.minusMonths(6));
		System.out.println("Calculating Age from the birthday to todays day using Period ::");
		var bDate = LocalDate.of(1989, 10, 24);
		Period p = Period.between(bDate, date);
		System.out.printf("Your age is %d years, %d months, %d days.",p.getYears(),p.getMonths(),p.getDays());
		System.out.println("Calculating No.of days to till Death Day :: ");
		var dDay = LocalDate.of(1989+60, 10, 24);
		var noDay = Period.between(date, dDay);	
		System.out.printf("You will be on earth only %d days, Hurry up to do more important thing only!",noDay.getYears()*365+noDay.getMonths()*30+noDay.getDays());
		System.out.println("ZoneId and ZoneDateTime Examples :: ");
		var zone = ZoneId.systemDefault();
		System.out.println("Printing Current Zone :: "+zone);
		var la = ZoneId.of("America/Los_Angeles");
		System.out.println("ZoneId of Los_Angels :: "+la);
		var laDate = ZonedDateTime.now(la);
		System.out.println("ZonedDateTime Local Date of Los_Angeles :: "+laDate);
		System.out.println();
		System.out.println("Checking Entered year is leap year or not :: ");
		var sc = new Scanner(System.in);
		System.out.println("Enter Year :: ");
		int y = sc.nextInt();
		var year = Year.of(y);
		if(year.isLeap()){
			System.out.printf("%d year is leap year.",year.getValue());
		}else{
			System.out.printf("%d year is not leap year.",year.getValue());
		}
	}

}
