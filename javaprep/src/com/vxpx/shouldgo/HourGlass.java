package com.vxpx.shouldgo;

import java.util.Arrays;
import java.util.Scanner;

public class HourGlass {

	public static void main(String[] args) {

		/*
		 * int[][] matrix = new int[][] { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0,
		 * 0 }, { 1, 1, 1, 0, 0, 0 }, {0, 0, 2, 4, 4, 0}, { 0, 0, 0, 2, 0, 0 },
		 * { 0, 0, 1, 2, 4, 0 } };
		 */

		/* 
		-1 -1 0 -9 -2 -2
		-2 -1 -6 -8 -2 -5
		-1 -1 -1 -2 -3 -4
		-1 -9 -2 -4 -4 -5
		-7 -3 -3 -2 -9 -9
		-1 -3 -1 -2 -4 -5
		*/
		
		Scanner in = new Scanner(System.in);
		int matrix[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				matrix[i][j] = in.nextInt();
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println("");
		}

		int h = 0, max = 0;
		int[] sum = new int[16];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sum[h] = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] + matrix[i + 1][j + 1] + matrix[i + 2][j]
						+ matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

				// i is a loop element and will be 0 mutiple time thru j. h is the only
				// option for identifying the first element so that max can initialized.
				if (h == 0 || sum[h] > max ) {
					max = sum[h];
				}

				h++;
			}

		}

		Arrays.sort(sum);
		System.out.println(sum[15]);

		System.out.println(max);
	}

}
