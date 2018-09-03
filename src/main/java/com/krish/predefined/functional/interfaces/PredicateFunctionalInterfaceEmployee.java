package com.krish.predefined.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunctionalInterfaceEmployee {
	
	public static void populateEmployees(List<Employee> eList){
		Employee e1 = new Employee("John","CEO",1000000,"Bangalore");
		Employee e2 = new Employee("Jack","Manager",40000,"Hyderabad");
		Employee e3 = new Employee("Linda","Develper",23000,"Hyderabad");
		Employee e4 = new Employee("Martin","Developer",25000,"Hyderabad");
		Employee e5 = new Employee("James","Module Lead",500000,"Hyderabad");
		Employee e6 = new Employee("Sun","Manager",800000,"Bangalore");
		Employee e7 = new Employee("Venus","QA Manager",900000,"Bangalore");
		Employee e8 = new Employee("Mars","Developer",20000,"Bangalore");
		Employee e9 = new Employee("Sam","Lead",40000,"Bangalore");
		Employee e10 = new Employee("Rita","QA",30000,"Hyderabad");
		eList.add(e1);
		eList.add(e2);
		eList.add(e3);
		eList.add(e4);
		eList.add(e5);
		eList.add(e6);
		eList.add(e7);
		eList.add(e8);
		eList.add(e9);
		eList.add(e10);				
	}
	
	public static void displayEmployees(List<Employee> eList, Predicate<Employee> p){
		for(Employee e: eList){
			if(p.test(e)) System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		
		List<Employee> eList = new ArrayList<>();
		populateEmployees(eList);
		Predicate<Employee> managerp = employee -> employee.getDesignation().equalsIgnoreCase("Manager");
		System.out.println("Managers List ::");
		displayEmployees(eList, managerp);
		Predicate<Employee> bangalorep = employee -> employee.getCity().equalsIgnoreCase("Bangalore");
		System.out.println("Bangalore List ::");
		displayEmployees(eList, bangalorep);
		System.out.println("Display Who are not Managers ::");
		displayEmployees(eList, managerp.negate());
		System.out.println("Display who are not from Bangalore ::");
		displayEmployees(eList, bangalorep.negate());
		System.out.println("Display who are Managers and not from Bangloare");
		displayEmployees(eList, managerp.and(bangalorep.negate()));
		System.out.println("Display who are Managers or from bangalore");
		displayEmployees(eList, managerp.or(bangalorep));
		Predicate<Employee> lSal = employee -> employee.getSalary() < 40000;
		System.out.println("All Employess whos salary less than 40000");
		displayEmployees(eList, lSal);
		System.out.println("Pink slip for Bangalore and Manager ::");
		displayEmployees(eList, managerp.and(bangalorep));
		Predicate<String> sequal = Predicate.isEqual("krish");
		System.out.println("Given string is equal or not :: ");
		System.out.println("isEqual = krish :: "+sequal.test("krish"));
		System.out.println("isEqual = krish :: "+sequal.test("krishna"));
		Predicate<Employee> oequal = Predicate.isEqual(new Employee("Krish","CEO",1000000,"Bangalore"));
		Employee e1 = new Employee("Krish","CEO",1000000,"Bangalore");
		Employee e2 = new Employee("Neetu","QA Manager",900000,"Bangalore");
		System.out.println("Display two objects are equal or not(To do need to ovveride equals method in pojo)");
		System.out.println("isEqual = CEO :: "+oequal.test(e1));
		System.out.println("isEqual = CEO :: "+oequal.test(e2));
		
	}

}

class Employee {
	String name;
	String designation;
	double salary;
	String city;
	public Employee(String name, String designation, double salary, String city) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee (name=" + name + ", designation=" + designation + ", salary=" + salary + ", city=" + city
				+ ")";
	}	
}