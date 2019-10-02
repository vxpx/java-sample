package com.vxpx.shouldgo;

import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int q = Integer.valueOf(in.nextLine());

		int n = 0, e = 0;

		for (int i = 0; i < q; i++) {
			String line1 = in.nextLine();
			String[] str = line1.split(" ");

			n = Integer.valueOf(str[0]);
			e = Integer.valueOf(str[1]);
			
			System.out.println("Nodes " + n + " Edges " + e);

			while (true) {
				String line2 = in.nextLine();
				String [] edges = line2.split(" ");
				if (edges.length > 1) {
					System.out.println(" Edge " + edges[0] + " " + edges[1]);
				} else {
					System.out.println("Start Node " + edges[0]);
					break;
				}
			}
			
		}

	}
}