package com.vxpx.shouldgo.search;

public class Sort012 {

	public static void main(String[] args) {

		int a[] = { 1, 0, 1, 2, 1, 0, 2 };

		int low = 0;
		int high = a.length - 1;
		int mid = 0;
		int temp = 0;

		while (mid <= high) {

			switch (a[mid]) {
			case 0:
				temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				mid++;
				low++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = a[high];
				a[high] = a[mid];
				a[mid] = temp;
				high--;
				break;
			}
		}
		
		System.out.println();
		for(int e: a) {
			System.out.print(" " + e);
		}

	}

}
