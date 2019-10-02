package com.vxpx.shouldgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicate {

	public static void main(String[] args) {

		//int a[] = { 4, 4, 4, 5, 4, 3 };
		
		int a[] = { 3, 3, 3, 3, 4, 8 };
		
		int numbers[] = { 3, 3, 3, 3, 4, 8 };

		int sum = 0;

		for (int i = 0; i < a.length; i++) {

			sum += a[i];

			int rev = a.length - 1;
			int revSum = 0;

			while (rev > i) {

				revSum += a[rev];
				rev--;
			}

			if (revSum == sum) {
				System.out.println(i);
			}

		}

		int endIndex = 0;
		int mid = numbers.length / 2;
		int psum = 0;
		int ssum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (i < mid) {
				psum = psum + numbers[i];
			} else {
				ssum = ssum + numbers[i];
			}

			if (psum == ssum) {
				System.out.println((mid - 1));
			}
		}
		
	}

	public int findMiddleIndex(int[] numbers) {
		
		return 0;
	}

}
