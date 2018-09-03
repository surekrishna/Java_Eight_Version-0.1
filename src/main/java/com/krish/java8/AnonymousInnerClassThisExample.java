package com.krish.java8;

public class AnonymousInnerClassThisExample {
	int x = 100;
	public void m2(){
		This t = new This(){
			int x = 111;//Anonymous inner class instance variable can access by using this keyword
			public void m1(){				
				System.out.println("Anonymous innter class instance variable :: "+this.x);
			}
		};
		t.m1();
	}
	public static void main(String[] args) {
		
		AnonymousInnerClassThisExample a = new AnonymousInnerClassThisExample();
		a.m2();
		
	}
}

interface This{
	public void m1();
}
