package com.krish.predefined.functional.interfaces;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class PrimitiveFunctionalInterface {

	public static void main(String[] args) {
		
		int[] x = {0,5,10,15,20,25};
		IntPredicate even = num -> num % 2 == 0;
		System.out.println("Primitive Functional Interfaces are IntPredicate,LongPredicate,DoublePredicate :: ");
		System.out.println("IntPredicate with respect to performance :: ");
		for(int e: x){
			if(even.test(e)){
				System.out.println(e);
			}
		}
		DoublePredicate addIt = num -> num+num == 10.50;
		System.out.println("DoublePredicate check :: ");
		System.out.println("Adding Double value :: "+addIt.test(5.25));		
		IntFunction<Integer> intInput = i -> i*i;
		System.out.println("Performance Decreases :  AutoBoxing required only @Returning value :: "+intInput.apply(5));
		Function<String,Integer> autoboxReturn = s -> s.length();
		System.out.println("Performance Decreases : AutoBoxing required only @Returning value :: "+autoboxReturn.apply("Krish"));
		ToIntFunction<String> noBox = s -> s.length();
		System.out.println("Performance Increases : Autoboxing unboxing not required :: "+noBox.applyAsInt("krish"));
		Function<Integer,Double> sq = i -> Math.sqrt(i);
		System.out.println("Performance Decreases : Autobxoing from int to Integer and Autobxing from double to Double :: ");
		System.out.println(sq.apply(5));
		IntToDoubleFunction sqr = i -> Math.sqrt(i);
		System.out.println("Performance Increases : No AutoBoxing and unboxing required :: ");
		System.out.println(sqr.applyAsDouble(5));
		Consumer<Integer> c1 = i -> System.out.println(i * i);
		System.out.println("Performance Decreases : Autobxoing is required from int to Integer ::");
		c1.accept(10);
		IntConsumer c2 = i -> System.out.println(i * i);
		System.out.println("Performance Increase not boxing requried :: ");
		c2.accept(5);
		ObjDoubleConsumer<Emp> si = (e,d) -> e.setSalary(e.getSalary()+d);
		Emp e = new Emp("krish",1200);
		si.accept(e, 500.00);
		System.out.println("Performance Increases : No boxing required ObjDoubleConsumer :: ");
		System.out.println(e);
		IntSupplier rdm = () -> (int)(Math.random()*10);
		System.out.println("Performance Increases : No boxing required IntSupplier :: ");		
		String otp = "";
		for(int i = 1; i <= 6; i++){
			otp = otp+rdm.getAsInt();
		}
		System.out.println(otp);
		UnaryOperator<Integer> uo = i -> i*i;
		System.out.println("Performance Decreases : When input and return type same use UnaryOpertor<T> === Function<Integer,Integer> :: ");
		System.out.println(uo.apply(5));
		System.out.println("Performance Increases : use IntUnaryOperator instaead of UnaryOperator<Integer> :: ");
		IntUnaryOperator iuo = i -> i*i;
		System.out.println(iuo.applyAsInt(3));
		BinaryOperator<String> bo = (s1,s2) -> s1+" "+s2;
		System.out.println("Performance Increases : When two inputs and return type is same :: ");
		System.out.println(bo.apply("Kishna", "Sure"));
		IntBinaryOperator ibo = (i1,i2) -> i1+i2;
		System.out.println("Performance Increases : When two inputs are return type is same :: ");
		System.out.println(ibo.applyAsInt(10, 20));
	}

}
