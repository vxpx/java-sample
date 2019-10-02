package com.vxpx.shouldgo.search;

public class ClosestSumToZero {

	public static void main(String[] args) {

		int a[] = { -10, -6, -3, 1, 5, 7, 8 };

		
		int i = 0, j = a.length -1;
		int minsum = Integer.MAX_VALUE;
		int min_l = 0, min_r = 0;

		
		while (i < j ) {
			
			int sum = a[i] + a[j];
			
			if (Math.abs(sum) < Math.abs(minsum)) {
				minsum = sum;
				min_l = i;
				min_r = j;
			} 
			
			if(sum > 0) {
				j--;
			} else {
				i++;
			}
		}
		
		System.out.println("Minsum " + minsum + "\t left " + min_l + " \t right " + min_r);
		
		int postiveclosest = Integer.MAX_VALUE;
		int negetiveclosest = Integer.MIN_VALUE;
		
		i = 0;
		j = a.length -1;
		
		while(i<j){
			
			int temp = a[i] + a[j];
			
			if(temp > 0) {
				if(temp < postiveclosest) postiveclosest = temp;
				j--;
			} else if (temp < 0) {
				if(temp > negetiveclosest ) negetiveclosest = temp;
				i++;
			} else {
				System.out.println("its a zero");
			}
		}
		
		System.out.println("postiveclosest " + postiveclosest + "\t negetiveclosest " + negetiveclosest);
		
	}

}
