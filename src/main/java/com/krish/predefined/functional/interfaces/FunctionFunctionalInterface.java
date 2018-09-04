package com.krish.predefined.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionFunctionalInterface {
	
	public static List<Student> populateStudents(){
		List<Student> stuList = new ArrayList<>();
		var s1 = new Student("Bunny", 73);
		var s2 = new Student("Sunny", 81);
		var s3 = new Student("Nimmy", 64);
		var s4 = new Student("Johnny", 31);
		var s5 = new Student("Honey", 26);
		
		stuList.add(s1);
		stuList.add(s2);
		stuList.add(s3);
		stuList.add(s4);
		stuList.add(s5);
		
		return stuList;
	}
	
	public static List<Employeee> getAllEmployees(){
		List<Employeee> empList = new ArrayList<>();
		
		var e1 = new Employeee("Johnny", 34000);
		var e2 = new Employeee("Nanny", 87000);
		var e3 = new Employeee("Rachel", 13000);
		var e4 = new Employeee("Michel", 23000);
		var e5 = new Employeee("Linda", 18000);
		
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		
		return empList;
	}
	
	public static void main(String[] args) {
		
		Function<String,Integer> length = name -> name.length();
		System.out.println("Lenght of the Given string :: ");
		System.out.println("Krish = "+length.apply("Krish"));
		System.out.println("Krishna = "+length.apply("Krishna"));
		Function<Integer,Integer> square = number -> number * number;
		System.out.println("Square of a Given number :: ");
		System.out.println("5 = "+square.apply(5));
		System.out.println("25 = "+square.apply(25));
		Function<String,String> replace = name -> name.replaceAll(" ", "");
		System.out.println("Replace spaces from Given String :: ");
		System.out.println("KrishnaSure = "+replace.apply("Krishna Sure"));
		System.out.println("DurgaSoftware = "+replace.apply("Durga Software"));
		Function<String,Integer> spaceDiff = name -> {
			int space = name.length();
			int noSpace = name.replaceAll(" ", "").length();
			return space - noSpace;
		};
		System.out.println("Length of a Given string from original to removedspace :: ");
		System.out.println("4 = "+spaceDiff.apply("Durga Software Solutions PVT LTD"));
		System.out.println("3 = "+spaceDiff.apply("Mindtree LTD Bangalore India"));				
		Function<Student,String> results = stu -> {	
				int marks = stu.getMarks(); 
				if(marks >= 80){
					return "Grade = A[Distinction]";					
				}else if(marks >= 60){
					return "Grade = B[First Class]";
				}else if(marks >= 50){
					return "Grade = C[Second Class]";					
				}else if(marks >= 35){
					return "Grade = D[Third Class]";					
				}else {
					return "Grade = E[Failed]";
				}
		};
		List<Student> sList = populateStudents();
		System.out.println("Students Results :: ");
		for(Student student: sList){
			System.out.println(student.getName()+" your Result :: "+results.apply(student));
		}
		Predicate<Student> gesixty = student -> student.getMarks() >= 60;
		System.out.println("Finding Marks >= 60 from all students");
		for(Student student: sList){
			if(gesixty.test(student)) System.out.println(student);
		}		
		List<Employeee> empList = getAllEmployees();
		Function<List<Employeee>,Double> totSal = eList -> {
			double totalSalary = 0;
			for(Employeee e: eList){
				totalSalary += e.getSalary();
			}
			return totalSalary;
		};
		System.out.println("Total Employee Salary :: ");
		System.out.println(totSal.apply(empList));
		System.out.println("Incrementing Salary 5000 if salary <= 20000");
		System.out.println("Salary Before Increment :: ");
		System.out.println(empList);
		Predicate<Employeee> leSal = emp -> emp.getSalary() <= 20000;
		List<Employeee> aftInc = new ArrayList<>();
		Function<Employeee,Employeee> incSal = emp -> {
			if(leSal.test(emp)){
				emp.setSalary(emp.getSalary()+5000);
			}			
			return emp;
		};
		
		for(var e: empList){
			aftInc.add(incSal.apply(e));			
		}
		System.out.println("Salary After Increment :: ");
		System.out.println(aftInc);
		System.out.println("Function Chaining :: ");
		Function<String,String> toUpper = name -> name.toUpperCase();
		Function<String,String> subString = name -> name.substring(0,9);
		System.out.println("First Function :: AISHWARYAABHI, Second Function :: aishwarya");
		System.out.println("Using andThen deafult method :: "+toUpper.andThen(subString).apply("Aishwaryaabhi"));
		System.out.println("Using compose default method :: "+toUpper.compose(subString).apply("Aishwaryaabhi"));
		System.out.println("Difference Between andThen() and compose() methods :: ");
		Function<Integer,Integer> add = number -> number + number;
		Function<Integer,Integer> cube = number -> number * number * number;
		System.out.println("andThen() :: "+add.andThen(cube).apply(2));
		System.out.println("compose() :: "+add.compose(cube).apply(2));
		var sc = new Scanner(System.in);
		System.out.println("Enter UserName (Min 5 chars):: ");
		String userName = sc.next();
		System.out.println("Enter Password :: ");
		String password = sc.next();
		Function<String,String> sub = uName -> uName.substring(0,5);
		Function<String,String> lower = uName -> uName.toLowerCase();
		if(sub.andThen(lower).apply(userName).equals("krish") && password.equals("java")){
			System.out.println("Congratulations you are Valid User.");
		}else{
			System.out.println("Please try after some time, Invalid User.");
		}
		Function<String,String> iden = Function.identity();
		System.out.println("identity() method :: ");
		System.out.println(iden.apply("krish"));
		
	}

}

class Student {
	String name;
	int marks;	
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}
	
		
}

class Employeee {
	String name;
	double salary;
	public Employeee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employeee [name=" + name + ", salary=" + salary + "]";
	}
	
	
}
