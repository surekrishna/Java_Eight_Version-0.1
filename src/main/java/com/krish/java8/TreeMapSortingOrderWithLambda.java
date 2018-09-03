package com.krish.java8;

import java.util.TreeMap;

public class TreeMapSortingOrderWithLambda {

	public static void main(String[] args) {
		
		TreeMap<Integer,String> m = new TreeMap<>();
		m.put(8, "Krishna");
		m.put(1, "King");
		m.put(9, "Jockey");
		m.put(4, "Queen");
		m.put(10, "Lion");
		m.put(2, "John");		
		System.out.println("Default Natural Sorting order :: "+m);
		
		TreeMap<Integer,String> m1 = new TreeMap<>((object1,object2) -> (object1 > object2) ? -1 : (object1 < object2) ? 1 : 0);
		m1.put(8, "Krishna");
		m1.put(1, "King");
		m1.put(9, "Jockey");
		m1.put(4, "Queen");
		m1.put(10, "Lion");
		m1.put(2, "John");		
		System.out.println("Default Natural Sorting order :: "+m1);
		
		
		
	}

}
