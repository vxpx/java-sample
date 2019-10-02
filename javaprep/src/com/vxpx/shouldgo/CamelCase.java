package com.vxpx.shouldgo;

public class CamelCase {
	
	public static void main(String[] args) {
		
		String string = "thisIsCamelCase";
		
		
		//String [] split = string.split("(?=\\p{Upper})");
		
		String [] split = string.split("[A-Z]");
		
		for(String s : split) {
			System.out.println(s);
		}
		
	}

}
