package com.vxpx.shouldgo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperReduced {

	public static void main(String[] args) {

		// Create a Scanner object to read input from stdin.
		Scanner scan = new Scanner(System.in);

		// Read a full line of input from stdin and save it to our variable,
		// inputString.
		String inputString = scan.nextLine();

		// Close the scanner object, because we've finished reading
		// all of the input from stdin needed for this challenge.
		scan.close();

		char[] stack = null;
		if (inputString != null && inputString.length() > 0) {
			stack = inputString.toCharArray();
		}

		int size = stack.length;
		int stackptr = -1;

		for (int i = 0; i < size;) {

			if (stackptr == -1 || stack[stackptr] != stack[i]) {
				stackptr++;
				stack[stackptr] = stack[i];
				i++;
			} else {
				int count = 1;
				while(i < size && stack[i] == stack[stackptr]) {
					i++;
					count++;
				}
				if (count%2==0) {
					stackptr--;
				}
				
			}
			
		}
		
		//System.out.println("Stack Ptr " + stackptr);
		
		if (stackptr > -1) {
			for(int i =0; i < stackptr+1; i++) {
				System.out.print(stack[i]);
			}
		} else {
			System.out.println("Empty String");
		}
		

	}
}