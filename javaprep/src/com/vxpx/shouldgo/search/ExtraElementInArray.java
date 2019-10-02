package com.vxpx.shouldgo.search;

//Java program to find an extra 
//element present in arr1[]
class ExtraElementInArray {
	// Returns index of extra element in arr1[].
	// n is size of arr2[]. Size of arr1[] is
	// n-1.
	static int findExtra(int arr1[], int arr2[], int n) {
		int index = n; // Initialize result

		// left and right are end points denoting
		// the current range.
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;

			// If middle element is same of both
			// arrays, it means that extra element
			// is after mid so we update left to mid+1
			if (arr2[mid] == arr1[mid])
				left = mid + 1;

			// If middle element is different of the
			// arrays, it means that the index we are
			// searching for is either mid, or before
			// mid. Hence we update right to mid-1.
			else {
				index = mid;
				right = mid - 1;
			}
		}

		// when right is greater than left our
		// search is complete.
		return index;
	}

	public static void main(String[] args) {
		int arr1[] = { 2, 4, 6, 8, 10, 12, 13 };
		int arr2[] = { 2, 4, 6, 8, 10, 12 };
		int n = arr2.length;

		// Solve is passed both arrays
		System.out.println(findExtra(arr1, arr2, n));
	}
}

/* This code is contributed by Harsh Agarwal */