package com.vxpx.shouldgo.list;

public class RemoveRepeated {

	public static void main(String[] args) {
		
		//int stack [] = {3,8,8,8,3};
		
		int stack [] = {1,5,6,8,8,8,0,1,1,0,6,5};
		
		int stkPtr = -1;
		
		for(int i = 0; i < stack.length; i++) {
			
			if (stkPtr == -1 || stack[i] != stack[stkPtr]) {
				stkPtr++;
				stack[stkPtr] = stack[i];
			} else {
				while(i < stack.length && stack[i] == stack[stkPtr]) {
					i++;
				}
				stkPtr--;
			}
		}
		
		for(int i = 0; i < stkPtr; i ++)
			System.out.print(stack[i] + " ");
		
	}
	
	
	
}
