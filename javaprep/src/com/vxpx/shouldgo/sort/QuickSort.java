package com.vxpx.shouldgo.sort;

public class QuickSort {

	private static int partition(int a[], int low, int high) {

		int pivot = a[high];
		int right = high;
		high = high - 1;

		while (low < high) {

			printArray(a);

			while (a[low] <= pivot) {
				low++;
			}

			while (a[high] > pivot) {
				high--;
			}

			if (low < high) {
				int temp = a[low];
				a[low] = a[high];
				a[high] = temp;
			}
		}

		// The low exactly points where the number starts incrementing and is the 
		// right spot for the pivot. Swap the right low pointer with the right and copy the pivot to 
		// low pointer.
		a[right] = a[low];
		a[low] = pivot;

		System.out.println("------------");
		return low;
	}

	private static void quickSort(int a[], int low, int high) {

		if (low <= high) {
			int pivot = partition(a, low, high);
			System.out.println(" Pivot " + pivot + " | " + a[pivot]);
			printArray(a);
			quickSort(a, low, pivot - 1);
			quickSort(a, pivot + 1, high);
		}
	}

	public static void main(String[] args) {
		int a[] = { 2, 5, 6, 8, 9, 1, 3 };
		quickSort(a, 0, a.length - 1);
		printArray(a);
	}

	private static void printArray(int a[]) {

		for (int i : a) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

}
