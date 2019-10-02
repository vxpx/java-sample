package com.vxpx.shouldgo.search;

public class CountLessOrEqual {

	public static void countLessOrEqual(int arr1[], int arr2[], int m, int n) {

		for (int i = 0; i < m; i++) {
			int index = binary_search(arr2, 0, n - 1, arr1[i]);

			// required count for the element arr1[i]
			System.out.println((index + 1) + " " + arr1[i]);
		}

	}

	private static int binary_search(int[] arr2, int i, int j, int k) {

		int low = i, high = j;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr2[mid] <= k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return high;
	}

	public static void main(String[] args) {

		int arr1[] = { 1, 2, 3, 4, 7, 9 };
		int arr2[] = { 0, 1, 1, 1, 2, 4 };
		countLessOrEqual(arr1, arr2, arr1.length, arr2.length);
	}

}
