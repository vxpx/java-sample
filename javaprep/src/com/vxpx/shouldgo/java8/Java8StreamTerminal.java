package com.vxpx.shouldgo.java8;

import java.util.Optional;
import java.util.stream.Stream;

public class Java8StreamTerminal {

	
	public static void main(String[] args) {
		
		Stream<Integer> numbers = Stream.of(1,2,3,4,5);
		
		Optional<Integer> multiplication = numbers.reduce((i,j)->i*j);
		if (multiplication.isPresent()) {
				System.out.println("multiplication :: " + multiplication.get());
		}
		
		Stream<Integer> numbers2 = Stream.of(1,2,3,4,5);
		System.out.println(numbers2.count());
		
		
		Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
		System.out.println("Stream contains 4 ? " + numbers3.anyMatch(i -> i>=4));
		
		Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
		System.out.println("Stream contains < 10 ? " + numbers4.allMatch(i -> i<10));
		
		Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
		System.out.println("Stream contains == 10 ? " + numbers5.noneMatch(i -> i==10));
	}
}
