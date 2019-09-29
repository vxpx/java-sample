package com.vxpx.shouldgo.sort;

public class HeapSort {

	int array[] = { 2, 5, 6, 8, 9, 1, 3 };
	int count = array.length - 1;

	// Need a delete max
	// Heap Structure

	private int leftChild(int index) {

		int pos = (2 * index + 1);
		if (pos > (array.length - 1))
			return -1;
		else
			return pos;
	}

	private int rightChild(int index) {
		int pos = (2 * index + 2);
		if (pos > (array.length - 1))
			return -1;
		else
			return pos;
	}

	private void percolateDown(int index) {

		int lChild = leftChild(index);
		int rChild = rightChild(index);

		int max = index;

		if (lChild != -1 && array[lChild] > array[max]) {
			max = lChild;
		}
		if (rChild != -1 && array[rChild] > array[max]) {
			max = rChild;
		}

		if (max != index) {
			int temp = array[index];
			array[index] = array[max];
			array[max] = temp;
		}

		// percolateDown(max);
	}

	private void buildMaxHeap(int[] array) {

		for (int i = (array.length - 1) / 2; i >= 0; i--) {
			percolateDown(i);
		}
	}

	private static void printArray(int a[]) {

		for (int i : a) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

	private void arrayResize() {

		int size = array.length * 2;
		int[] newArray = new int[size];

		System.arraycopy(array, 0, newArray, 0, array.length);

		array = newArray;

	}

	private void insertIntoHeap(int element) {

		int i = ++count;

		if (count >= array.length)
			arrayResize();

		while (i != 0 && element > this.array[(i - 1)/ 2]) {
			this.array[i] = this.array[(i - 1) / 2];
			i = (i - 1) / 2;
			System.out.println("-----------------------");
			printArray(this.array);
		}

		this.array[i] = element;

	}

	public static void main(String[] args) {
		HeapSort heap = new HeapSort();

		heap.printArray(heap.array);
		heap.buildMaxHeap(heap.array);
		heap.printArray(heap.array);
		heap.insertIntoHeap(7);
		heap.printArray(heap.array);
		heap.insertIntoHeap(10);
		heap.printArray(heap.array);
	}
}
