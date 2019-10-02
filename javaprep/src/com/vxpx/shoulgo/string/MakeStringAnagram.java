package com.vxpx.shoulgo.string;

public class MakeStringAnagram {

	public static void main(String[] args) {
		
		String s1 = "bcadeh";
		String s2 = "hea";
		
		int result = 0;
		
		int count1[] = new int[26];
		int count2[] = new int[26];
		
		for(int i=0; i< s1.length(); i++){
			count1[s1.charAt(i)-'a']++;
		}
		
		for(int i=0; i< s2.length(); i++){
			count2[s2.charAt(i)-'a']++;
		}
		
		for(int i=0; i< s1.length(); i++){
			count1[s1.charAt(i)-'a']++;
		}
		
		for(int i=0; i< s1.length(); i++){
			result += Math.abs(count1[i] - count2[i]);
		}
		
		
		System.out.println(result +" characters need to be removed");
	}
	
}
