package com.cts.jsedemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String arg[]) {
		
		/*
		SampleFunctionalInterface evenOddCheck = a -> (a%2==0);
		
		SampleFunctionalInterface primeCheck = a -> {
			int count=2;
			
			//to count the factors of a
			
			return count==2;
		};
		
		System.out.println(evenOddCheck.operate(12));
		System.out.println(evenOddCheck.operate(11));
		*/
		
		
		String[] strs = new String[] {"Vamsy","Komal","Vinay","Latha","Savan","Swaroopa","Vinay"};
		
		Arrays.stream(strs).forEach(System.out::println);
		
		List<String> strList = Arrays.stream(strs).collect(Collectors.toList());
		System.out.println(strList);
		
		String longest = Arrays.stream(strs).reduce( (s1,s2) -> s1.length()>s2.length()?s1:s2 ).orElse(null);
		System.out.println(longest);
		
		Arrays.stream(strs).filter( s -> s.startsWith("V")).forEach(System.out::println);;
		
		Arrays.stream(strs).map( str ->  "**"+str+"**").forEach(System.out::println);
	}
}
