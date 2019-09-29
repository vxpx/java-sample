package com.vxpx.shoulgo.string;

public class FirstRepeatedChar {

	public static void main(String[] args) {
		
		String str = "newstringrepeated";
		char [] aChar = str.toCharArray();
		
		int [] hash = new int[256];
		
		for(int i=0; i < aChar.length; i++) {
			System.out.print(" " + (int)aChar[i]);
		}
		
		for(int i=0; i < aChar.length; i++) {
			if (hash[aChar[i]] == 1) {
				System.out.println("\n First repeated character is -- " + aChar[i]);
				break;
			}
			hash[aChar[i]]++;
		}
		
	}
	
}
