package com.krish.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSortingWithLambda {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1,"Deepika"));
		list.add(new Employee(5,"Sunny"));
		list.add(new Employee(3,"Alia"));
		list.add(new Employee(4,"Katrina"));
		list.add(new Employee(2,"Deepika"));
		
		Collections.sort(list, (e1,e2) -> (e1.eno < e2.eno) ? -1 : (e1.eno > e2.eno) ? 1 : 0);
		System.out.println("Sorting Employee Object based on eno using Lambda :: "+list);
	}

}

class Employee {
	int eno;
	String ename;
	public Employee(int eno, String ename) {
		super();
		this.eno = eno;
		this.ename = ename;
	}
	@Override
	public String toString() {
		return eno+":"+ename;
	}
	
	
}
