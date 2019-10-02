package com.vxpx.shouldgo.stack;

public class SpanAdhoc {

	static int a[] = { 2, 1, 3, 4, 3, 2 };
	
	
	public static void main(String[] args) {
		
		
		int maxSpan = 0;
		
		for(int i=1; i < a.length; i++) {
			
			//int element = a[i];
			
			int j = i;
			int span = 1;
			
			while (j >0 && a[i] >= a[j-1]) {
				j--;
				span++;
			}
			
			if (span > maxSpan) maxSpan = span;
		}
		
		
		System.out.println("Span " + maxSpan);
	}
	
}
