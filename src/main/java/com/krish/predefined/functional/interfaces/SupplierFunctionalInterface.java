package com.krish.predefined.functional.interfaces;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierFunctionalInterface {

	public static void main(String[] args) {
		
		Supplier<LocalDateTime> getDateTime = () -> LocalDateTime.now();
		System.out.println("Current LocalDateTime :: "+getDateTime.get());
		System.out.println("Current LocalDateTime :: "+getDateTime.get());
		System.out.println();
		Supplier<String> randomString = () -> {
			String[] names = {"Java","Spring","Angular","Hibernate","ReactJS","JQuery","JavaScript","SCSS"};
			int rNumber = (int) (Math.random() * names.length);
			return names[rNumber];
		};
		System.out.println("Get Random Name :: ");
		System.out.println(randomString.get());
		System.out.println(randomString.get());
		Supplier<String> getOTP = () -> {
			String otp = "";
			for(int i = 0; i < 6; i++){
				otp = otp + (int) (Math.random() * 10);				
			}
			return otp;
		};
		System.out.println("Get Random OTP :: ");
		System.out.println(getOTP.get());
		System.out.println(getOTP.get());
		System.out.println();
		Supplier<String> randomPwd = () ->{
			String pwd = "";
			String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#$@";
			Supplier<Integer> zeroToNineNumbers = () -> (int) (Math.random() * 10);
			Supplier<Integer> zeroToTwentyEightNumbers = () -> (int) (Math.random() * 29);
			for(int i = 1; i <= 8; i++){
				if(i%2 == 0){
					pwd = pwd + zeroToNineNumbers.get();
				}else{
					pwd = pwd + chars.charAt(zeroToTwentyEightNumbers.get());
				}
			}
			return pwd;
		};
		System.out.println("Generating random password Even places should be numbers and odd places should be chars");
		System.out.println(randomPwd.get());
		System.out.println(randomPwd.get());
	}

}
