package com.vxpx.shouldgo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BufferImplementation {
	
	
	
	public static void main(String[] args) {
		
		char value [] = new char [] {'v','x','p','x'};
		
		System.out.println("char array length " + value.length);
		
		int oldlength = value.length;
		
		for (char c : value) {
			System.out.print(c + " ");
		}
		
		System.out.println("\n*********");
		
		//make a new array and copy contents
		value = Arrays.copyOf(value, ((value.length+1)*2));
		
		System.out.println("char array length " + value.length);
		
		String append = "new";
		
		//System.arraycopy(arg0, arg1, arg2, arg3, arg4);
		
		//append characters from the string to the destination array at the end
		append.getChars(0, append.length(), value, oldlength);
		
		for (char c : value) {
			System.out.print(c + " ");
		}
	}

}
