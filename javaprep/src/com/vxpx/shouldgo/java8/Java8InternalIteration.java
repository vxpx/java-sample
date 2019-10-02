package com.vxpx.shouldgo.java8;

import java.util.ArrayList;
import java.util.List;

public class Java8InternalIteration {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			myList.add(i);
		}

		System.out.println(myList	.stream()
									.filter(p -> p > 10)
									.mapToInt(f -> f)
									.sum());

	}

}
