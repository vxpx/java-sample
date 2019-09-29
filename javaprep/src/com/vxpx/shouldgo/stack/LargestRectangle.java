package com.vxpx.shouldgo.stack;

import java.util.Stack;

public class LargestRectangle {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();

		// int [] hist = new int[] {3,2,5,6,1,4,4};
		int [] hist = new int[] {3,1,5,6,2,4,4};
		//int[] hist = new int[] { 8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116 };

		int i = 0;
		int maxarea = 0;

		while (i < hist.length) {

			if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
				stack.push(i);
				System.out.println("Pushed " + i);
				i++;
			} else {
				int top = stack.pop();

				int area = hist[top] * (stack.empty() ? i : (i - stack.peek() - 1));
				System.out.println("Top " + top + "| Area " + area);

				if (area > maxarea)
					maxarea = area;
			}
		}

		while (!stack.isEmpty()) {

			int top = stack.pop();

			/* The value of i used when the strech involves complete array */
			int area = hist[top] * (stack.empty() ? i : (i - stack.peek() - 1));
			System.out.println("Top " + top + "| Area " + area);

			if (area > maxarea)
				maxarea = area;
		}

		System.out.println("---------------------");
		System.out.println("Max Area " + maxarea);
	}

}
