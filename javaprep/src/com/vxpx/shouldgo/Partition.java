package com.vxpx.shouldgo;

import java.util.ArrayList;
import java.util.Scanner;

public class Partition {

	static void partition(int[] ar) {

		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		ArrayList<Integer> equal = new ArrayList<Integer>();

		int pivot = ar[0];

		for (int n : ar) {
			if (n < pivot) {
				left.add(n);
			} else if (n > pivot) {
				right.add(n);
			} else {
				equal.add(n);
			}

		}

		left.addAll(equal);
		left.addAll(right);
		
		for (int i = 0; i < ar.length ; i++) {
			ar[i] = left.get(i);
		}

		printArray(ar);
	}

	static void printArray(int[] ar) {

		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		partition(ar);
	}
}
