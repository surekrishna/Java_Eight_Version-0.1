package com.krish.predefined.functional.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateFunctionalInterface {
	
	public static void m1(Predicate<Integer> p, int[] x){
		for(int x1: x){	
			if(p.test(x1)) System.out.println(x1);			
		}
		
	}

	public static void main(String[] args) {
		
		Predicate<Integer> ng = number -> number > 10;
		System.out.println("To find Given number greater than 10 or not");
		System.out.println(ng.test(100));
		System.out.println(ng.test(5));
				
		Predicate<String> sl = name -> name.length() > 5;
		System.out.println("To find Given string length greater than 5 or not");
		System.out.println(sl.test("Test"));
		System.out.println(sl.test("Predicate"));
		
		Predicate<Collection> ce = c -> c.isEmpty();
		List<String> l1 = new ArrayList<>();
		l1.add("Some Object");
		List<String> l2 = new ArrayList<>();
		System.out.println("To find given collection is empty or not");
		System.out.println(ce.test(l1));
		System.out.println(ce.test(l2));
		
		
		Predicate<Integer> p1 = number -> number > 10;
		Predicate<Integer> p2 = number -> number%2 ==0;
		System.out.println("To find greater and even conditions(Predicate Joinings)");
		System.out.println("The Numbers Greater than 10 or not");
		int[] x = {0,5,10,15,20,25,30};
		m1(p1,x);
		System.out.println("The Numbers are Even or not");
		m1(p2,x);
		System.out.println("The Numbers not greater than 10");
		m1(p1.negate(),x);
		System.out.println("The Numbers greater than 10 and even");
		m1(p1.and(p2),x);		
		System.out.println("The Numbers greater than 10 or even");
		m1(p1.or(p2),x);
		
		
		Predicate<String> swk = name -> name.startsWith("K");
		String[] names = {"Katrina", "Mallika", "Kareena", "Kajal", "Sunny"};
		System.out.println("Display names starts with k");
		for(String name: names){
			if(swk.test(name)) System.out.println(name);
		}	
		
		Predicate<String> en = name -> null != name && !name.isEmpty();
		String[] names1 = {"Dell","",null,"HP",null,"Apple",""};
		List<String> newnames1 = new ArrayList<>();
		System.out.println("Removing null and empty string from string array");
		for(String name: names1){
			if(en.test(name)) newnames1.add(name);
		}
		System.out.println(newnames1);
		
		
		Predicate<User> auth = user -> user.getUserName().equalsIgnoreCase("krish") && user.getPassword().equalsIgnoreCase("Java");
		System.out.println("Authentication using Predicate");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter UserName::");
		String userName = sc.next();
		System.out.println("Enter Password::");
		String password = sc.next();
		User u = new User(userName,password);
		if(auth.test(u)){
			System.out.println("Congratulations! Valid User");
		}else{
			System.out.println("Invalid User, Please Login again.");
		}
		
		
		Predicate<SoftwareEngineer> allowed = se -> se.getAge() >= 18 && se.isHavingGF;
		SoftwareEngineer[] ses = {
				new SoftwareEngineer("Krish", 28, false),
				new SoftwareEngineer("Ram", 28, false),
				new SoftwareEngineer("Robert", 28, false),
				new SoftwareEngineer("Raheem", 28, false),
				new SoftwareEngineer("Venkat", 32, true),
		};
		System.out.println("Employee allowed into Pub ::");
		for(SoftwareEngineer se: ses){
			if(allowed.test(se)) System.out.println(se+" you are allowed into PUB, Go and Enjoy! Have a Blast.");
		}
				

	}

}

class User {
	String userName;
	String password;	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}

class SoftwareEngineer {
	String name;
	int age;
	boolean isHavingGF;
	public SoftwareEngineer(String name, int age, boolean isHavingGF) {
		super();
		this.name = name;
		this.age = age;
		this.isHavingGF = isHavingGF;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isHavingGF() {
		return isHavingGF;
	}
	public void setHavingGF(boolean isHavingGF) {
		this.isHavingGF = isHavingGF;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
