package com.vxpx.shouldgo.sort;

public class MergeSort {

	private static void printArray(int a[]) {

		for (int i : a) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

	private void mergeSort(int a[], int temp[], int left, int right) {

		int mid = (left + right) / 2;
		if (left < right) {
			mergeSort(a, temp, left, mid);
			mergeSort(a, temp, mid + 1, right);
			merge(a, temp, left, mid + 1, right);
		}

	}

	private void merge(int a[], int temp[], int left, int mid, int right) {

		int left_end = mid - 1;
		int pos = left;
		int size = right-left + 1;

		while (left <= left_end && mid <= right) {

			if (a[left] < a[mid]) {
				temp[pos] = a[left];
				pos++;
				left++;
			} else {
				temp[pos] = a[mid];
				pos++;
				mid++;
			}

		}
		
		while (left <= left_end) {
			temp[pos] = a [left];
			pos++;
			left++;
		}
		
		while (mid <= right) {
			temp [pos] = a[right];
			pos++;
			mid++;
		}
		
		for (int i = 0; i < size; i ++) {
			a[right] = temp[right];
			right--;
		}
		
		System.out.print(" left:" + left + " mid:" + mid + " right:" + right + "|");
		printArray(a);
	}

	public static void main(String[] args) {
		MergeSort mSort = new MergeSort();
		int a[] = { 5, 8, 1, 3, 2, 7, 6, 4 };
		int temp[] = new int[a.length];

		mSort.mergeSort(a, temp, 0, (a.length - 1));
		System.out.println("*********************");
		printArray(a);
	}

}
