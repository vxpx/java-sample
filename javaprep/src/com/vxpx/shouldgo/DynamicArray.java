package com.vxpx.shouldgo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DynamicArray {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();

		int[][] seqList = new int[n][];

		/*
		 * for (int i = 0; i < n; i++) { seqList[i] = new int[1]; }
		 */

		int lastAns = 0;

		for (int i = 0; i < q; i++) {
			int operation = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();

			switch (operation) {

			case 1:
				int seq = (x ^ lastAns) % n;
				int[] temp = seqList[seq];

				int length = (temp != null) ? temp.length : 0;

				seqList[seq] = new int[length + 1];
				if (length != 0) {
					System.arraycopy(temp, 0, seqList[seq], 0, length);
					seqList[seq][length] = y;
				} else {
					seqList[seq][0] = y;
				}
				

				break;

			case 2:
				int seq1 = (x ^ lastAns) % n;
				lastAns = seqList[seq1][(y % seqList[seq1].length)];
				System.out.println(lastAns);
				break;

			default:
				System.out.println("Error !!");
			}

		}

		in.close();
	}
}
