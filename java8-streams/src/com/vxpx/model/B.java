package com.vxpx.model;

public class B {

	A obj2 = new A();
	
	public static void main(String[] args) {
		
		A obj3 = null;
		obj3.testStatic();
		
		B obj4 = new B();
		
		System.out.println(obj4);
	}
}
