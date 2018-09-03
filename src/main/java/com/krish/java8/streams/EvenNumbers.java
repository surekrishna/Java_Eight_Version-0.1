package com.krish.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvenNumbers {

	public static void main(String[] args) {
		
		System.out.println("Without Streams Untill 1.7 getting Even numbers from the list ::");
		List<Integer> numList = new ArrayList<>();
		numList.add(0);
		numList.add(10);
		numList.add(20);
		numList.add(5);
		numList.add(15);
		numList.add(25);
		List<Integer> evenList = new ArrayList<>();
		for(Integer i: numList){
			if(i%2 == 0){
				evenList.add(i);
			}
		}
		System.out.println(evenList);
		System.out.println("With Streams From 1.8 getting Even numbers from the list ::");
		List<Integer> streamList = numList.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
		System.out.println(streamList);
		System.out.println("Original List :: "+numList);
		System.out.println("Without Streams Untill 1.7 generating new objects(double = *2) from the list ::");
		List<Integer> multiTwo = new ArrayList<>();
		for(Integer i: numList){
			multiTwo.add(i*2);
		}		
		System.out.println(multiTwo);
		System.out.println("With Streams From 1.8 generating new objects(double = *2) from the list ::");
		List<Integer> streamTwo = numList.stream().map(i -> i*2).collect(Collectors.toList());
		System.out.println(streamTwo);
		System.out.println("With Streams filter names whose length >= 9 ::");
		List<String> nameList = new ArrayList<>();
		nameList.add("Pavan");
		nameList.add("RaviTeja");
		nameList.add("Chiranjeevi");
		nameList.add("Venkatesh");
		nameList.add("Nagurjuna");
		System.out.println(nameList);
		List<String> streamNames = nameList.stream().filter(name -> name.length() >= 9).collect(Collectors.toList());
		System.out.println(streamNames);
		System.out.println("With Streams filter and convert to toUpperCase() ::");
		List<String> toUpper = nameList.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
		System.out.println(toUpper);
		System.out.println("With Streams filter objects whose lenght >=9 ::");
		long count = nameList.stream().filter(name -> name.length()>=9).count();
		System.out.println(count);
		System.out.println("With Streams Default natural soring order ::");
		List<Integer> naturalSort = numList.stream().sorted().collect(Collectors.toList());
		System.out.println(naturalSort);
		System.out.println("With Streams Customized soritng order ::");
		List<Integer> custSort = numList.stream().sorted((n1,n2) -> -n1.compareTo(n2)).collect(Collectors.toList());
		System.out.println(custSort);
		System.out.println("With Streams finding min value of a list using min(Comparator c) ::");
		Integer min = numList.stream().min((n1,n2) -> n1.compareTo(n2)).get();
		System.out.println(min);
		System.out.println("With Streams finding min value of a list using max(Comparator c) ::");
		Integer max = numList.stream().max((n1,n2) -> n1.compareTo(n2)).get();
		System.out.println(max);
		System.out.println("With Streams using forEach() method ::");
		//nameList.stream().forEach(name -> System.out.println(name));
		nameList.stream().forEach(System.out::println);
		System.out.println("With Streams coping elements from stream to array using toArray() ::");
		Integer[] numbers = numList.stream().toArray(Integer[]::new);
		for(Integer n: numbers){
			System.out.println(n);
		}
		System.out.println("With Streams applying streams concept to other than collection objects :: ");
		System.out.println("Applying Streams concepts to some random numbers :: ");
		Stream<Integer> numers = Stream.of(9,99,999,9999,99999);
		numers.forEach(System.out::println);
		System.out.println("Applying Streams concepts to doble[] numbers :: ");
		Double[] nums = {10.1,10.2,10.3,10.4,10.5};
		Stream<Double> dNum = Stream.of(nums);
		dNum.forEach(System.out::println);
		
	}

}
