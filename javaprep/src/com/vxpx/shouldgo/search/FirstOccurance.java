package com.vxpx.shouldgo.search;

public class FirstOccurance {

	private static int findFirstOccurance(int a[], int left, int right, int element) {

		int mid = left + (right - left) / 2;

		if (left < right) {

			if (a[mid] == element && (mid == left || a[mid - 1] < a[mid])) {
				return mid;
			} else if (a[mid] >= element) {
				return findFirstOccurance(a, left, mid, element);
			} else {
				return findFirstOccurance(a, mid + 1, right, element);
			}
		} else {
			return -1;
		}

	}

	private static int findLastOccurance(int a[], int left, int right, int element) {

		int mid = left + (right - left) / 2;

		if (left < right) {

			if (a[mid] == element && (mid == right || a[mid + 1] > a[mid])) {
				return mid;
			} else if (a[mid] <= element) {
				return findLastOccurance(a, mid + 1, right, element);
				//Since its about the last occurance when the element is equal you need
				//to move right searching for the next element.
				//return findLastOccurance(a, left, mid, element);
			} else {
				return findLastOccurance(a, left, mid, element);
				//return findLastOccurance(a, mid + 1, right, element);
			}
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {

		int a[] = { 0, 2, 3, 7, 7, 7, 8, 9 };

		int foundFirst = findFirstOccurance(a, 0, a.length - 1, 7);
		int foundLast = findLastOccurance(a, 0, a.length - 1, 7);

		System.out.println("Found first at " + foundFirst);
		System.out.println("Found last at " + foundLast);

	}

}
