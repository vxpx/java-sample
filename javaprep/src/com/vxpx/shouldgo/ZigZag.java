package com.vxpx.shouldgo;

import java.util.Scanner;

public class ZigZag {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int matrix[][] = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = in.nextInt();
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		int evenRow = 0;
		int oddRow = 1;
		int row = 3;
		int col = 3;

		while (evenRow < row) {
			for (int i = 0; i < col; i++) {
				System.out.print(matrix[evenRow][i] + " ");
			}

			evenRow += 2;

			/*
			 * if (oddRow < row) { for (int i=col-1; i>=0; i--) {
			 * System.out.print(matrix[oddRow][i]); } }
			 */

			if (oddRow < row) {
				System.out.print(matrix[oddRow][col - 1] + " ");
			}
			oddRow += 2;
		}

		/*
		 * while (evenRow < row) { for (int i = 0; i < col; i++) { // evenRow will be
		 * printed in the same direction System.out.print(matrix[evenRow][i] + " "); }
		 * 
		 * // Skipping next row so as to get the next evenRow evenRow = evenRow + 2;
		 * 
		 * if(oddRow < row) { for (int i = col - 1; i >= 0; i--) { // oddRow will be
		 * printed in the opposite direction System.out.print(matrix[oddRow][i] + " ");
		 * } }
		 * 
		 * // Skipping next row so as to get the next oddRow oddRow = oddRow + 2; }
		 */

	}

}
