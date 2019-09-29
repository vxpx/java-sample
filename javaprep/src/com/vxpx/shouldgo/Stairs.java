package com.vxpx.shouldgo;

import java.util.Scanner;

public class Stairs {

	public static void main(String[] args) {

		int n = 6;

		Scanner in = new Scanner(System.in);
		
		
		String str = "#";
		for (int i = 1; i <= n; i++) {
			System.out.printf("%" + (n + 1) + "s", str + "\n");
			str = str + "#";
		}

	}

}
