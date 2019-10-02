package com.vxpx.shouldgo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotate {

	public static int[] arrayLeftRotation(int[] a, int n, int k) {
	      
        for (int j=1; j <= k; j++) {
            int element = a[0];
            for (int i = 0; i < n-1; i++) {
                a[i] = a[i+1];
            }
            a[n-1]=element;
        }
        return a;
    }
    
    public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();*/
      
        
        char chararray [] = { 'a', 'e', 'z', 'd', 'c' };
        
        Arrays.sort(chararray);
        
        for(char c : chararray)
        	System.out.print( c + " ");
        
        
    }
}
