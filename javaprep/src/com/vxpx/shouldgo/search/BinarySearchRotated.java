package com.vxpx.shouldgo.search;

public class BinarySearchRotated {

	public static int binarySearch(int a[], int left, int right, int data) {

		if (left > right)
			return -1;

		int mid = (left + right) / 2;

		if (a[mid] == data)
			return mid;

		if (a[left] < a[mid]) {

			if (data > a[left] && data < a[mid]) {
				return binarySearch(a, left, mid - 1, data);
			} else {
				return binarySearch(a, mid + 1, right, data);
			}
		} else {

			if (data > a[mid] && data < a[right]) {
				return binarySearch(a, mid + 1, right, data);
			} else {
				return binarySearch(a, left, mid - 1, data);
			}
		}
	}

	public static void main(String args[]) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = arr.length;
		int key = 6;
		int i = binarySearch(arr, 0, n - 1, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}

}
