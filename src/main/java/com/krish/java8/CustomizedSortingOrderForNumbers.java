package com.krish.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomizedSortingOrderForNumbers {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(0);
		list.add(5);
		list.add(20);
		list.add(15);
		System.out.println("List Before Sorting Order :: "+list);
		Collections.sort(list);
		System.out.println("List After Natural Sorting Order :: "+list);
		Collections.sort(list, new MyComparator());
		System.out.println("List After Customized Sorting Order :: "+list);

	}

}

class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 > o2 ? -1 : o1 < o2 ? +1 : 0;
	}
	
}