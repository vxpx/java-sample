package com.vxpx.shouldgo.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MisingSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1, 2, 4, 5, 6, 8, 9 };

		int count[] = new int[10];

		for (int i = 1; i < 10; i++) {
			boolean numberFound = false;

			for (int j = 0; j < a.length; j++) {

				if (a[j] == i) {
					numberFound = true;
				}
			}

			if (!numberFound) {
				System.out.print(" " + i);
			}
		}

		for (int i = 0; i < count.length; i++) {

			count[i] = 0;
		}

		for (int ele : a) {

			count[ele] = 1;
		}
		System.out.println("\n");

		for (int ele : count) {
			System.out.print(ele + " ");
		}

		int start = -1;
		int end = 0;

		System.out.println("\n");

		for (int i = 0; i < count.length; i++) {
			if (count[i] == 1) {
				if (start == -1) {
					start = i;
					continue;
				}
				if (i == count.length-1) {
					end = i;
					System.out.println(start + "-" + end);
				}
			} else {
				if (start != -1) {
					end = i - 1;
					System.out.println(start + "-" + end);
					start = -1;
				}
			}
		}

		System.out.println("\n");
		
		List<Integer> vlanList = new ArrayList<>();
		
		vlanList.add(6);
		vlanList.add(8);
		vlanList.add(9);
		vlanList.add(4);
		vlanList.add(2);
		vlanList.add(1);
		vlanList.add(5);
		
		
		Collections.sort(vlanList);
		List rangeList = new ArrayList();
		
		start = -1;
		end =0;
		int previous = -1;
			
		for (int i = 0; i < vlanList.size(); i++) {
			
			int current = vlanList.get(i);
			if (start == -1) {
				start = current;
				previous = current;
			} else {
				if (previous + 1 != current) {
					end = previous;
					System.out.println(start + "-" + end);
					previous = start = current;
				} else {
					end = previous = current;
				}
				
				if (i == vlanList.size()-1) {
					System.out.println(start + "-" + end);	
				}
				
			}
		}
		
		
	}

}
