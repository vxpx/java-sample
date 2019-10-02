package com.vxpx.shouldgo.stack;

import java.util.Stack;

import com.vxpx.shouldgo.list.StackLL;

public class FindingSpans {

	public static void main(String[] args) {

		int a[] = { 2, 1, 3, 4, 3, 2 };
		int spans[] = new int[a.length];

		Stack<Integer> stack = new Stack<Integer>();

		int p = 0;

		for (int i = 0; i < a.length; i++) {

			while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				p = -1;
			} else {
				p = stack.peek();
			}

			spans[i] = i - p;

			stack.push(i);

		}

		for (int k = 0; k < spans.length; k++)
			System.out.print(spans[k] + " ");
		
		FindingSpans findingSpans = new FindingSpans();
		//findingSpans.thisTestMethod();
	}
	
	private void thisTestMethod() {
		System.out.println(new Throwable().getStackTrace()[0].getMethodName());
	}

}
