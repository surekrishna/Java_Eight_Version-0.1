package com.krish.java8;

import java.util.TreeSet;

public class TreeSetSortingOrderWithLambda {

	public static void main(String[] args) {
		
		TreeSet<Integer> t = new TreeSet<>();
		t.add(10);
		t.add(0);
		t.add(20);
		t.add(5);
		t.add(25);
		t.add(15);
		System.out.println("TreeSet default natural Sorting order :: "+t);
		TreeSet<Integer> t1 = new TreeSet<>((object1,object2) -> (object1 > object2) ? -1 : (object1 < object2) ? 1 : 0);
		t1.add(10);
		t1.add(0);
		t1.add(20);
		t1.add(5);
		t1.add(25);
		t1.add(15);
		System.out.println("TreeSet Customized Sorting order with Lambda :: "+t1);
		

	}

}
