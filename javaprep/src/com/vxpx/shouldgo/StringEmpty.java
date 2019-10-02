package com.vxpx.shouldgo;

public class StringEmpty {

	
	public static void main(String[] args) {
		
		String name = "vijeeth";
		
		StringBuilder builder = new StringBuilder();
		builder.append(name.replace("e", ""));
		System.out.println(builder.reverse());
		
		
	
	}
}
