package com.vxpx.shoulgo.string;

public class ExtractMaximumFromString {

	public static void main(String[] args) {

		String str = "100klh564abc365bg";
		System.out.println(extractMaximum(str));
		
		char c1 = '3';
		char c2 = '4';
		
		int num = c1; 
		
		System.out.println(c1);
		System.out.println(num + c1);

	}

	private static int extractMaximum(String str) {
		
		int res = 0;
		int num = 0;
		
		for (int i =0; i < str.length(); i ++) {
			
			char c = str.charAt(i);
			
			if (Character.isDigit(c)) {
				num = num * 10 + (c-'0') ;
			} else {
				res = Math.max(res, num);
				num = 0;
			}
			
		}
		
		return res;
	}
}
