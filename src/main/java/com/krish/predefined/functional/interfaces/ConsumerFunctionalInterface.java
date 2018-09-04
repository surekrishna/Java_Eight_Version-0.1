package com.krish.predefined.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerFunctionalInterface {
	
	public static List<Movie> getMoviesList(){
		List<Movie> mList = new ArrayList<>();
		var m1 = new Movie("Bahubali", "Prabhas", "Anushka", "RajaMouli");
		var m2 = new Movie("Race Gurram", "Bunny", "Shruthi Hasan", "Surender Reddy");
		var m3 = new Movie("Business", "Mahesh", "Kajal", "Puri Jaganath");
		var m4 = new Movie("Tammudu", "Pawan Kalyan", "Preeti Jangani", "Arun Prasad");
		
		mList.add(m1);
		mList.add(m2);
		mList.add(m3);
		mList.add(m4);
		
		return mList;
	}
	
	public static List<Student> getStudentsList(){
		List<Student> sList = new ArrayList<>();
		
		var s1 = new Student("Bunny", 73);
		var s2 = new Student("Sunny", 81);
		var s3 = new Student("Nimmy", 64);
		var s4 = new Student("Johnny", 31);
		var s5 = new Student("Honey", 26);
		
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);
		
		return sList;
	}

	public static void main(String[] args) {

		Consumer<String> print = name -> System.out.println("Consumed Value is :: "+name);
		print.accept("krish");
		print.accept("krishna");
		Consumer<Movie> pMovie = movie -> {
			System.out.println();
			System.out.println("Movie Name :: "+movie.getName());
			System.out.println("Hero Name :: "+movie.getHero());
			System.out.println("Heroine Name :: "+movie.getHeroine());
			System.out.println("Director Name :: "+movie.getDirector());
			System.out.println();
		};
		List<Movie> mv = getMoviesList();
		for(var m: mv){
			pMovie.accept(m);
		}
		
		List<Student> sList = getStudentsList();
		Predicate<Student> geMarks = student -> student.getMarks() >= 60;
		Function<Student,String> getGrade = student -> {
			int marks = student.getMarks();
			if(marks >= 80){
				return "A";
			}else if(marks >= 60){
				return "B";
			}else if(marks >= 50){
				return "C";
			}else if(marks >= 35){
				return "D";
			}else{
				return "E";
			}
		};
		Consumer<Student> display = student -> {
			System.out.println();
			System.out.println("Name :: "+student.getName());
			System.out.println("Marks :: "+student.getMarks());
			System.out.println("Grade :: "+getGrade.apply(student));
			System.out.println();
		};
		System.out.println("Functional Interfaces - Predicate,Function,Consumer Example :: ");
		for(var s: sList){
			if(geMarks.test(s)){
				display.accept(s);
			}
		}
		System.out.println("Consumer Chaining :: ");
		Consumer<Moviee> c1 = movie -> System.out.println("Movie "+movie.getName()+" is ready to release.");
		Consumer<Moviee> c2 = movie -> System.out.println("Movie "+movie.getName()+" just released and talk is "+movie.getResult()+".");
		Consumer<Moviee> c3 = movie -> System.out.println("Movie "+movie.getName()+" is stroing in database.");
		Consumer<Moviee> cChain = c1.andThen(c2).andThen(c3);
		var m1 = new Moviee("Bahubali", "Hit");
		cChain.accept(m1);
		System.out.println();
		var m2 = new Moviee("Spyder", "Flop");
		cChain.accept(m2);
	}

}

class Movie {
	String name;
	String hero;
	String heroine;
	String director;
	public Movie(String name, String hero, String heroine, String director) {
		super();
		this.name = name;
		this.hero = hero;
		this.heroine = heroine;
		this.director = director;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHero() {
		return hero;
	}
	public void setHero(String hero) {
		this.hero = hero;
	}
	public String getHeroine() {
		return heroine;
	}
	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
}

class Moviee {
	String name;
	String result;
	public Moviee(String name, String result) {
		super();
		this.name = name;
		this.result = result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}	
}
