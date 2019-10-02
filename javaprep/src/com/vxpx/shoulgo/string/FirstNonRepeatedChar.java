package com.vxpx.shoulgo.string;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		
		//String str = "firstnonrepeatedcharacter";
		FirstNonRepeatedChar ref = new FirstNonRepeatedChar();
		System.out.println(ref.nonRepeatedChar("firstnonrepeatedchar"));
		
	}
	
	public char nonRepeatedChar(String str) {
		
		char [] chara = str.toCharArray();
		int [] hash = new int[256];
		
		char repeated = '$';
		
		for(char c : chara) {
			hash[c]++;
		}
		
		boolean found = false;
		for(char c : chara) {
			if(hash[c] == 1) {
				System.out.println("First non repeated character -- " + c);
				found = true;
				return c;
			}
			
		}
		
		if(!found) {
			System.out.println("All characters are repeated");
			
		}
		
		return '$';
		
	}
	
}
