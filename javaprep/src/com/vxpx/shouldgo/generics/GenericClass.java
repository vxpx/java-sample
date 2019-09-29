package com.vxpx.shouldgo.generics;

public class GenericClass<T> {

	int value;
	String name;

	public T returnGenericClass(T type) {
		return type;
	}

	public static void main(String[] args) {

		GenericClass<String> gClass = new GenericClass<String>();
		String g1Class = gClass.returnGenericClass("vxpx");
		System.out.println(g1Class);

		// Error reported for the GenericClass defined as String
		// gClass.returnGenericClass(12);

	}

}
