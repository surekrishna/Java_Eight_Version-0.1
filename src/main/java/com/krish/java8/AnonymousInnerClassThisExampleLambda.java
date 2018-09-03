package com.krish.java8;

public class AnonymousInnerClassThisExampleLambda {

	int x = 100;
	
	public void m2(){
		This1 t1 = () ->{
			int x = 111;//as a local variable can use
			System.out.println("Lambda instance varible is always outer class :: "+this.x);
			System.out.println("Lambda local variable :: "+x);
		};
		t1.m1();
	}
	
	public static void main(String[] args) {
		AnonymousInnerClassThisExampleLambda a = new AnonymousInnerClassThisExampleLambda();
		a.m2();

	}

}

interface This1{
	public void m1();
}