package com.vxpx.shouldgo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamIntermediate {

	public static void main(String[] args) {

		Stream<String> names = Stream.of("aBc", "d", "eFg");
		System.out.println(names.map(s -> s.toUpperCase())
								.collect(Collectors.toList()));

		// Stream cannot use primitives
		Stream<Integer> intStream = Stream.of(new Integer[] { 1, 2, 3, 4 });
		Set<Integer> intSet = intStream.collect(Collectors.toSet());
		System.out.println(intSet);

		intStream = Stream.of(new Integer[] { 4, 3, 2, 1 });
		Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
		System.out.println(intMap);

		/*
		 * intStream = Stream.of(4,3,2,1); Integer [] intArray =
		 * intStream.toArray(Integer[]::new);
		 */

		Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
		List<String> naturalSorted = names3	.sorted()
											.collect(Collectors.toList());
		System.out.println(naturalSorted);

		Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("Pankaj"), Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));
		// flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream());

		flatStream.forEach(System.out::println);

		Stream<Integer> intStream1 = Stream.of(new Integer[] { 1, 2, 3, 4, 5 });

		/*
		 * intStream1 .filter(p -> p > 3) .min((a, b) -> Integer.compare(a, b))
		 * .ifPresent(System.out::println);
		 */

		/*
		 * System.out.println(intStream1 .filter(p -> p > 3) .reduce(0, (c, s) -> c +
		 * s));
		 */

		System.out.println(IntStream.range(5, 10)
									.filter(e -> e % 2 != 0)
									.max());

		// Infinite Stream

		Stream<Integer> infiniteStream = Stream.iterate(10, i -> i + 1);
		System.out.println(infiniteStream	.filter(e -> e % 2 == 0)
											.map(e -> e * 2)
											.filter(e -> e > 30)
											.findFirst()
											.orElse(null));

		int minelement = Stream	.iterate(10, e -> e + 1)
								.filter(e -> e % 2 == 0)
								.map(e -> e * 2)
								.filter(e -> e > 40)
								.limit(2)
								.mapToInt(e -> e)
								.sum();

		// .min(Comparator.comparing(Integer::valueOf))
		// .get();

		System.out.println("Infinite Stream - Max of 10 elements doubled " + minelement);

		int minelement1 = Stream.iterate(10, e -> e + 1)
								.filter(e -> e % 2 == 0)
								.map(e -> e * 2)
								.filter(e -> e > 40)
								.limit(2)
								.mapToInt(e -> e)
								.reduce(0, (c, s) -> c + s);

		System.out.println("Infinite Stream - Max of 10 elements doubled - reduce " + minelement1);

		String[] stringArray = new String[] { "vxpx", "sxroy3", "scnaik", "rjayaba" };

		Stream	.of(stringArray)
				.map(String::toUpperCase)
				.forEach(System.out::println);

	}

}
