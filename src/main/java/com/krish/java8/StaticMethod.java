package com.krish.java8;

public class StaticMethod {

	public static void main(String[] args) {
		StaticMethod1.m1();

	}

}

interface StaticMethod1 {
	public static void m1(){
		System.out.println("Static method.");
	}
}
