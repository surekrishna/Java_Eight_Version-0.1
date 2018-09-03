package com.krish.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomizedSortingOrderForNumbersWithLambda {

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
		Collections.sort(list, (object1,object2) -> (object1>object2) ? -1 : (object1<object2) ?  +1 : 0);
		System.out.println("List After Customized Sorting Order using Lambda Expression :: "+list);

	}

}
