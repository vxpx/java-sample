package com.vxpx.shoulgo.string;

public class Solution {

	public char nonRepeatedChar(String str) {

		char[] chara = str.toCharArray();
		int[] hash = new int[256];

		char repeated = '$';

		for (char c : chara) {
			hash[c]++;
		}

		boolean found = false;
		for (char c : chara) {
			if (hash[c] == 1) {
				System.out.println("First non repeated character -- " + c);
				found = true;
				break;
			}
			if (found == true) {
				return c;
			}
		}

		if (!found) {
			System.out.println("All characters are repeated");

		}

		return '$';

	}

}
