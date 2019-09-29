package com.vxpx.shouldgo.sort;

public class CountingSort {

	public static void main(String[] args) {

		int a[] =  new int [8];
		
		a[1] = 5;
		a[2] = 3;
		a[3] = 6;
		a[4] = 1;
		a[5] = 7;
		a[6] = 2;
		
		int b[] = new int[a.length];

		int c[] = new int[a.length];

		int i = 1;
		while (i < a.length) {
			b[i] = 0;
			i++;
		}

		int j = 1;
		while (j < a.length) {
			b[a[j]] = b[a[j]] + 1;
			j++;
		}

		for (int k = 1; k < a.length; k++) {
			b[k] = b[k] + b[k - 1];
		}
		
		for (int k = 1; k < a.length; k++) {
			c[b[a[k]]] = a[k];
		}
		
		System.out.println("Printing the sorted list .. ");
		for (int k = 1; k < a.length; k++) {
			System.out.print(c[k] + " ");
		}

	}

}
