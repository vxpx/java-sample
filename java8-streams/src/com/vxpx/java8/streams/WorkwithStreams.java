package com.vxpx.java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.vxpx.model.Employee;

public class WorkwithStreams {

	private static Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0),
			new Employee(2, "Bill Gates", 200000.0), new Employee(3, "Mark Zuckerberg", 300000.0) };

	public static void main(String[] args) {

		// 1. IntegerStrem
		IntStream	.range(1, 10)
					.forEach(System.out::print);

		System.out.println();

		// 2. IntegerStrem with skip
		IntStream	.range(1, 10)
					.skip(5)
					.forEach(System.out::print);

		System.out.println();

		// 3. IntegerStrem with sum
		int sum = IntStream	.range(1, 5)
							.sum();

		System.out.println("Sum " + sum);

		// 4. Sorted
		Stream	.of("vxpx", "sxroy3", "rjayaba", "scnaik")
				.sorted()
				.findFirst()
				.ifPresent(System.out::println);

		Stream	.of("vxpx", "sxroy3", "rjayaba", "scnaik")
				.sorted()
				.findFirst()
				.orElse(null);

		// 5 . Stream from array, filter, sort, print
		String[] names = { "vxpx", "sxroy3", "rjayaba", "scnaik" };
		Stream.of(names);
		Arrays	.stream(names)
				.filter(s -> s.startsWith("s"))
				.sorted()
				.forEach(System.out::println);

		// 6. Average of square in an int array
		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		Arrays	.stream(intArray)
				.map(x -> x * x)
				.average()
				.ifPresent(System.out::println);
		
		//14. Reduction summary statistics
		IntSummaryStatistics stats = IntStream.of(1,2,4,5,6,7).summaryStatistics();
		System.out.println(stats);
		

		/*
		 * Stream .generate(Math::random) .limit(5) .forEach(x -> System.out.print(x));
		 */

	}

}
