package com.vxpx.shoulgo.string;

public class LengthEncoding {
	
	public static void main(String[] args) {
		
		String encode = "wwwwaaadexxxxxx";
		StringBuffer output = new StringBuffer();
		
		char prev = '!';
		int length = 1;
		
		for (int i = 0; i < encode.length(); i++) {
			
			if (i == 0) {
				output.append(encode.charAt(0));
				prev = encode.charAt(0);
			} else if (encode.charAt(i) == prev) {
				length ++;
				prev = encode.charAt(i);
			} else {
				output.append(length);
				output.append(encode.charAt(i));
				prev = encode.charAt(i);
				length = 1;
			}
			
			if (i == encode.length() -1) {
				output.append(length);
			}
			
		}
		
		System.out.println(output.toString());
		
	}

}
