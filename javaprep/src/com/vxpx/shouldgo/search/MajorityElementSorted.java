package com.vxpx.shouldgo.search;

public class MajorityElementSorted {

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		MajorityElement majorelement = new MajorityElement();
		int a[] = new int[] { 1, 1, 2, 3, 3, 8, 8, 8, 8, 8, 8 };
		int size = a.length;
		int x = 8;
		int pos = binarySearch(a, 0, size-1, x);
		
		if (pos == -1) {
			System.out.println("Element not present");
		}
		
		/* check if the element is present more than n/2 times */
		if((pos+size/2) <= (size-1) && a[pos+size/2] == x) {
			System.out.println("Element is a majority");
		} else {
			System.out.println("Element is not a majority");
		}
		
	}

	public static int binarySearch(int a[], int low, int high, int x) {

		int mid = (low + high) / 2;

		/* Check if arr[mid] is the first occurrence of x.
         * arr[mid] is first occurrence if x is one of the following
         * is true:
         * (i)  mid == 0 and arr[mid] == x
         * (ii) arr[mid-1] < x and arr[mid] == x
		 */
		
		
		if (low < high) {

			if ((mid == 0 || a[mid - 1] < x) && a[mid] == x) {
				return mid;
			} else if (a[mid] >= x) {
				return binarySearch(a, low, mid - 1, x);
			} else {
				return binarySearch(a, mid + 1, high, x);
			}
		} else {
			return -1;
		}
			
	}

}
