package com.krish.java8;

public class DefaultMethodInterface implements DefaultMethod{

	public static void main(String[] args) {
		DefaultMethodInterface dm = new DefaultMethodInterface();
		System.out.println("DefaultMethodInterface.class");
		dm.m1();
	}

}

class DefaultMethodOverride implements DefaultMethod {
	public void m1(){
		System.out.println("My own implementation");
	}
	public static void main(String[] args) {
		DefaultMethodOverride dmo = new DefaultMethodOverride();
		System.out.println("DefaultMethodOverride.class");
		dmo.m1();
	}
}

interface DefaultMethod {
	default void m1(){
		System.out.println("Default method");
	}
}


