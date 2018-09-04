package com.krish.predefined.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionalInterfaces {
	
	public static void main(String[] args) {
		
		BiPredicate<Integer,Integer> isEven = (a,b) -> (a+b) % 2 == 0;
		System.out.println("BiPredicate to check two input numbers even or not :: ");
		System.out.println("10+20 = 30(Even) :: "+isEven.test(10, 20));
		System.out.println("10+15 = 25(Even) :: "+isEven.test(10, 25));
		BiFunction<Integer,Integer,Integer> multiply = (a,b) -> a * b;
		System.out.println("Multiply two input numbers :: ");
		System.out.println("10 * 20 = "+multiply.apply(10, 20));
		System.out.println("10 * 5 = "+multiply.apply(10, 5));
		BiFunction<Integer,String,Studentt> stu = (rollNo,name) -> new Studentt(rollNo,name);
		List<Studentt> stuList = new ArrayList<>();
		System.out.println("Creating student object by providing two inputs to bifunction :: ");
		stuList.add(stu.apply(1, "John"));
		stuList.add(stu.apply(2, "Mike"));
		stuList.add(stu.apply(3, "Linda"));
		stuList.add(stu.apply(4, "Lucy"));
		for(Studentt student: stuList){
			System.out.println(student);
		}		
		var e1 = new Emplooye(1,"John",1300);
		var t1 = new TimeSheet(1,25);
		BiFunction<Emplooye,TimeSheet,Double> sal = (e,t) -> e.getDailyWage() * t.getDays();
		System.out.println("Calculating Employee monthly sal using daily wage and Woring days :: ");
		System.out.println("Salary :: "+sal.apply(e1, t1));
		BiConsumer<String,String> concat = (firstName,lastName) -> System.out.println(firstName.concat(" "+lastName));
		System.out.println("BiConsumer String concatination ::");
		concat.accept("Krishna", "Sure");
		List<Emp> empList = new ArrayList<>();			
		BiFunction<String,Double,Emp> emp = (name,salary) -> new Emp(name,salary);
		empList.add(emp.apply("John", 1200.00));
		empList.add(emp.apply("Mike", 1800.00));
		empList.add(emp.apply("Jack", 1000.00));
		empList.add(emp.apply("Jim", 1900.00));
		System.out.println("Incrementing Employee salary using BiFunction,BiConsumer :: ");
		System.out.println("Before Increment :: "+empList);
		BiConsumer<Emp,Double> dalInc = (employee,inc) -> employee.setSalary(employee.getSalary()+inc);
		for(Emp e: empList){
			dalInc.accept(e, 600.00);
		}
		System.out.println("After Increment :: "+empList);
				
	}

}

class Studentt {
	int rollNo;
	String name;
	public Studentt(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}	
}

class Emplooye {
	int eno;
	String name;
	double dailyWage;
	public Emplooye(int eno, String name, double dailyWage) {
		super();
		this.eno = eno;
		this.name = name;
		this.dailyWage = dailyWage;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDailyWage() {
		return dailyWage;
	}
	public void setDailyWage(double dailyWage) {
		this.dailyWage = dailyWage;
	}
	@Override
	public String toString() {
		return "Emplooye [eno=" + eno + ", name=" + name + ", dailyWage=" + dailyWage + "]";
	}	
}

class TimeSheet {
	int eno;
	double days;
	public TimeSheet(int eno, double days) {
		super();
		this.eno = eno;
		this.days = days;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public double getDays() {
		return days;
	}
	public void setDays(double days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "TimeSheet [eno=" + eno + ", days=" + days + "]";
	}		
}

class Emp {
	String name;
	double salary;
	public Emp(String name, double salary) {
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
		return "Emp [name=" + name + ", salary=" + salary + "]";
	}
	
}
