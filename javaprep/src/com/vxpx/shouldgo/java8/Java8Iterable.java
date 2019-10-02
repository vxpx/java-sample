package com.vxpx.shouldgo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Java8Iterable {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			list.add(i);
		}

		/**
		 * Consumer interface being used which can be implemented in case any business
		 * logic needs to be implemented. Consumer interface is also a functional
		 * interface i.e one abstract method
		 */
		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.print(t + " ");
			}

		});

		System.out.println("\n***** Lambda *******");

		list.forEach((t) -> System.out.print(t + " "));

		System.out.println();

		System.out.println("\n***** Method Reference *******");
		
		/**
		 * You use lambda expressions to create anonymous methods. Sometimes, however, a
		 * lambda expression does nothing but call an existing method. In those cases,
		 * it's often clearer to refer to the existing method by name. Method references
		 * enable you to do this; they are compact, easy-to-read lambda expressions for
		 * methods that already have a name.
		 */

		list.forEach(System.out::println);

		System.out.println();

		list.forEach(t -> System.out.print(t + " "));

		System.out.println("\n***** Stream *******");
		Stream<Integer> sequenetialStream = list.stream();
		Stream<Integer> parallelStream = list.parallelStream();

		Stream<Integer> highNum = sequenetialStream.filter(p -> (p > 5));

		System.out.println("\n***** Stream filter *******");
		highNum.forEach(t -> System.out.print(t + " "));
		System.out.println();

		System.out.println("\n***** Parallel Stream filter *******");
		Stream<Integer> highNumPar = parallelStream.filter(p -> p > 7);
		highNumPar.forEach(t -> System.out.print(t + " "));
		System.out.println();

	}

}
