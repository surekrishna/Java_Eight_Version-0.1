package com.krish.java8;

import com.krish.java8.interfaces.Hello;
import com.krish.java8.interfaces.SquareNumber;
import com.krish.java8.interfaces.StringLength;
import com.krish.java8.interfaces.TwoIntArgs;

public class LambdaExpOne {

	public static void main(String[] args) {
		Hello h = () -> System.out.println("Hello World!");
		h.sayHello();
		
		TwoIntArgs tia = (a,b) -> System.out.println("Sum is :: "+(a+b));
		tia.add(10, 10);
		tia.add(100, 25);
		
		StringLength sl = text -> text.length();
		System.out.println("Lenght of the String :: "+sl.getLength("Hello"));
		System.out.println("Lenght of the String :: "+sl.getLength("oracle corporation"));
		
		SquareNumber sn = number -> number*number;
		System.out.println("Square of Number :: "+sn.getSquare(5));
		System.out.println("Square of Number :: "+sn.getSquare(10));
		
		Runnable r = () -> {
			for(int i = 0; i < 10; i++){
				System.out.println("Child thread.");
			}
		};		
		Thread t = new Thread(r);
		t.start();
		for(int i = 0; i < 10; i++){
			System.out.println("Main thread.");
		}
		
	}	

}
