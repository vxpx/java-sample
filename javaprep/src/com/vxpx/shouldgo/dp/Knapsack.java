package com.vxpx.shouldgo.dp;

//A Dynamic Programming based solution for 0-1 Knapsack problem
public class Knapsack {

	// A utility function that returns maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
				
		/*
		 * val is index adjusted with i-1 counter, K array with i-1 refers to not
		 * including that i item i.e the previous item e.g : when i = 3
		 * val[i-1] = val[2] refers to the third item K[i-1][w] refers to the
		 * current weight and including the i-1 item.
		 */
		
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 1, 2, 3 };
		int W = 5;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}
/* This code is contributed by Rajat Mishra */