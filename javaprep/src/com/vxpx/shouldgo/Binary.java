package com.vxpx.shouldgo;

import java.util.ArrayList;
import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		ArrayList<Integer> list = new ArrayList<Integer>();

		while (n > 0) {

			int remainder = n % 2;
			n = n / 2;

			list.add(remainder);
		}

		int consequtive = 0;
		int current = 0;

		if (list.isEmpty()) {
			for (int data : list) {

				if (data == 1) {
					current++;
				} else {
					current = 0;
				}

				if (current > consequtive) {
					consequtive = current;
				}

				System.out.print(data);
			}
		}
		System.out.println("");
		System.out.println(consequtive);

	}
}
