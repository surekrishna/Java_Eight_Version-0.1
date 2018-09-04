package com.krish.java8;

public class defaultMethodAmbiguityMultipleInheritance implements Left, Right {

	public void m1(){
		System.out.println("My own implementation");
	}
	public static void main(String[] args) {
		var dai = new defaultMethodAmbiguityMultipleInheritance();
		dai.m1();
	}

}

class defaultMethodAmbiguityMultipleInheritance1 implements Left, Right {

	public void m1(){
		Left.super.m1();
	}
	public static void main(String[] args) {
		var dai1 = new defaultMethodAmbiguityMultipleInheritance1();
		dai1.m1();
	}

}

class defaultMethodAmbiguityMultipleInheritance2 implements Left, Right {

	public void m1(){
		Right.super.m1();
	}
	public static void main(String[] args) {
		var dai2 = new defaultMethodAmbiguityMultipleInheritance2();
		dai2.m1();
	}

}


interface Left {
	default public void m1(){
		System.out.println("Left default method");
	}
}

interface Right {
	default public void m1(){
		System.out.println("Right default method");
	}
}
