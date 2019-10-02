package com.vxpx.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vxpx.model.Employee;

public class SortWithStreams {

	public static void main(String[] args) {

		List<Employee> eList = new ArrayList<>();

		eList.add(new Employee(1, "vxpx", 200));
		eList.add(new Employee(3, "sxroy3", 300));

		List<Employee> sortedList;

		sortedList = eList	.stream()
							.sorted((l, r) -> l	.getName()
												.compareTo(r.getName()))
							.collect(Collectors.toList());

		sortedList.forEach(e -> System.out.println(e));

	}

}
