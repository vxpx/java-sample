package com.vxpx.shouldgo;

public class Parent {
	
	protected int protectedVal;
	private int privateVal;
	
	Parent() {
		protectedVal = 10;
		privateVal = 20;
	}
	
	protected void print() {
		System.out.println("Printing protected print " + this.protectedVal);
	}
	
	public static void main(String[] args) {
		Parent parent = new Parent();
		System.out.println(parent.privateVal);
	}

}
