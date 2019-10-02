package com.vxpx.shouldgo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ShootingPalindrome {
	
	public static void main(String[] args) {
		
		int [] bottle = {1,4,3,1,5};
		
		int j = bottle.length;
		boolean palindrome = true;
		
		for (int i = 0; i < (bottle.length/2); i++) {
			
			if (bottle[i] != bottle[j]) {
				palindrome = false;
				break;
			}
			j--;
		}
		
		
		
	}

}
