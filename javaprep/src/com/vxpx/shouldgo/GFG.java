package com.vxpx.shouldgo;

//Java program to find the count
//of positive integer of a
//given number of digits 
//that contain atleast one zero
import java.io.*;

class GFG {

	// Returns count of 'd' digit
	// integers have 0 as a digit
	static int findCount(int d) {
		return 9 * ((int) (Math.pow(10, d - 1)) - (int) (Math.pow(9, d - 1)));
	}

	// Driver Code
	public static void main(String args[]) {
		int d = 1;
		System.out.println(findCount(d));

		d = 2;
		System.out.println(findCount(d));

		d = 4;
		System.out.println(findCount(d));

	}
}

// This code is contributed by Nikita Tiwari.