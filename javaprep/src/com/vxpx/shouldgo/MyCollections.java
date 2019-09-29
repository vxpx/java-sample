package com.vxpx.shouldgo;

import java.util.HashSet;
import java.util.Set;

class Person {

	Person(String name) {
		this.name = name;
	}

	String name;
	
	/*boolean equals(Person p) {
		return this.name.equalsIgnoreCase(p.name);
	}*/
	
	/*@Override
	public String toString() {
		return this.name;
	}*/
}

public class MyCollections {

	public static void main(String[] args) {

		try {

			Set<Person> mySet = new HashSet();

			Person p1 = new Person("vxpx");
			Person p2 = new Person("sxroy3");
			Person p3 = new Person("vxpx");
			
			System.out.println(mySet.add(p1) + " " + p1.hashCode());
			System.out.println(mySet.add(p2) + " " + p2.hashCode());
			System.out.println(mySet.add(p3) + " " + p3.hashCode());
			System.out.println(mySet.add(p3) + " " + p3.hashCode());

			mySet	.stream()
					.forEach(System.out::println);
			
			Person p4 = new Person("vxpx");
			
			System.out.println(mySet.contains(p3));
			
		} catch (NullPointerException npe) {
			System.out.println("Do nothing !!");
		}

	}

}
