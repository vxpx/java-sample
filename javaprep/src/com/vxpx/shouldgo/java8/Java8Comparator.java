package com.vxpx.shouldgo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Comparator {

	public static void main(String[] args) {

		String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };

		// Arrays.sort(stringArray, String::compareToIgnoreCase);

		//Reverses the natural sort order
		Arrays.sort(stringArray, Comparator.reverseOrder());
		
		
		for (String s : stringArray) {
			System.out.println(s);
		}

		List<Employee> empList = new ArrayList<>();

		empList.add(new Employee(1, "vxpx"));
		empList.add(new Employee(3, "sxoy3"));
		empList.add(new Employee(2, "vxpx"));
		empList.add(new Employee(4, "rjayaba"));

		empList.forEach(System.out::println);

		// Collections Sort
		empList.sort((e1, e2) -> e1	.getName()
									.compareTo(e2.getName()));

		empList	.stream()
				.sorted((e1, e2) -> e1	.getName()
										.compareTo(e2.getName()))
				.forEach(System.out::println);

		System.out.println("Sorted List");

		List<Employee> sortedList = empList	.stream()
											.sorted(Employee::compareEmployee)
											.collect(Collectors.toList());
		sortedList.forEach(System.out::println);

	}

}

class Employee {

	private int id;
	private String name;

	Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public static int compareEmployee(Employee e1, Employee e2) {
		if (e1.getName() == e2.getName()) {
			return e2.id - e1.id;
		} else {
			return e1	.getName()
						.compareTo(e2.getName());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}