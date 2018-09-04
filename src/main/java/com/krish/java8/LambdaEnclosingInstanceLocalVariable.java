package com.krish.java8;

public class LambdaEnclosingInstanceLocalVariable {

	int x = 1;
	public void m2(){
		int y = 2; // which acts as final whether we are declaring or not
		ILVariable v = () -> {
			//can access instance and local variable of outer class
			System.out.println(x);
			System.out.println(y);
			x = 3;//fine 
			//y = 4; Local variable y defined in an enclosing scope must be final or effectively final
		};
		v.m1();
	}
	public static void main(String[] args) {
		var l = new LambdaEnclosingInstanceLocalVariable();
		l.m2();

	}

}

interface ILVariable{
	public void m1();
}