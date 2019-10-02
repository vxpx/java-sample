package com.vxpx.shouldgo.greedy;

public class MeetingScheduler {

	public static void main(String[] args) {
		
		// initial array
		// int s [] = {9,10,11,14,16};
		// int f [] = {10,12,12,15,17};
		
		//Use double array sort based on finish times
		int f [] = {10,12,12,15,17,17};
		int s [] = {9,10,11,14,14,16};
		
		int mtg = 1;
		int i, j;
		i = j = 0;
		
		System.out.println("Accepted meeting " + s[0] + " to " + f[0]);
		
		for (i = 1; i < f.length; i++) {
			
			if (s[i] >= f[j]) {
				mtg++;
				System.out.println("Accepted meeting " + s[i] + " to " + f[i]);
				j = i;
			}
		}
		
		System.out.println("Total meetings scheduled " + mtg);
		
		
	}
	
}
