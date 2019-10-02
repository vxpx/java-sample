package com.vxpx.shouldgo.sort;

public class InsertionSort {

	private static void printArray(int a[]) {
		
		for(int i : a) {
			System.out.print(" " + i);
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Sorting begins !! ");
		int a[] = {6,3,8,1,2,5,7};
		
		for (int i=1; i <= (a.length-1); i++) {
			
			int v = a[i];
			int j = i;
			while (j >= 1 && a[j-1] > v) {
				a[j] = a[j-1];
				j--;
			System.out.print("+ i:" + i + " j:" + j + " || ");
			printArray(a);
			}
			
			a[j] = v;
			
			System.out.print("i:" + i + " j:" + j + " || ");
			printArray(a);
		}
		
		System.out.println("Final Sorted Array");
		System.out.println("******************");
		printArray(a);
		
	}
}
