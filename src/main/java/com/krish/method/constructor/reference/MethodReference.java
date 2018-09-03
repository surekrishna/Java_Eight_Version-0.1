package com.krish.method.constructor.reference;

public class MethodReference {
	
	public static void m2(){
		System.out.println("Method Reference.");
	}
	
	public void m3(){
		for(int j = 1; j <= 10; j++){
			System.out.println("Child Thread.");
		}
	}

	public static void main(String[] args) {
		FInterface i = () -> System.out.println("Functional Inteface with Lamdba expression.");
		i.m1();
		System.out.println("Method Reference static method :: ");
		FInterface mReference = MethodReference::m2;
		mReference.m1();
		System.out.println("Lambda implementation for creating thread using Runnable :: ");
		Runnable r = () -> {
			for(int j = 1; j <= 10; j++){
				System.out.println("Child Thread.");
			}
		};
		Thread t = new Thread(r);
		t.start();
		for(int k = 1; k <= 10; k++){
			System.out.println("Main Thread.");
		}
		System.out.println("Method Reference for creating thread using Runnable :: ");
		MethodReference mr = new MethodReference();
		Runnable rm = mr::m3;
		Thread t1 = new Thread(rm);
		t1.run();
		for(int j = 1; j <= 10; j++){
			System.out.println("Main Thread.");
		}
		System.out.println("Lambda implementation for creating object of sample :: ");
		Interf l = () -> new Sample();
		Sample s1 = l.get();
		System.out.println("Construction reference for creating object of sample :: ");
		Interf f = Sample::new;
		Sample s2 = f.get();
	}

}

interface FInterface {
	public void m1();
}

class Sample {
	Sample(){
		System.out.println("Sample class construction reference and object creation.");
	}
}

interface Interf {
	public Sample get();
}