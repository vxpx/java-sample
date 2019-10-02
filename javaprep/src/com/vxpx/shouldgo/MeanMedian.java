package com.vxpx.shouldgo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MeanMedian {
	
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
	    	Scanner in = new Scanner(System.in);
	    	int n = in.nextInt();
	        double sum = 0;
	        int a[] = new int[n];
	        
	        
	        Map<Integer,Integer> map =  new TreeMap<Integer,Integer>();
	        
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	            sum = sum + a[a_i];
	        }
	        
	        
	        
	        for(int a_i=0; a_i < n; a_i++){
	           Integer value = map.get(a[a_i]);
	           if (value != null) {
	        	   map.put(a[a_i], value+1);
	           } else {
	        	   map.put(a[a_i], 1);
	           }
	        }
	        
	        double mean = sum/n;
	        
	      
	        double median = 0;
	        
	       
	        
	        
	        Arrays.sort(a);
	        
	        if (n%2==0) {
	            int mid = n/2;
	            median = (double) ((a[mid] + a[mid-1])/2);
	        } else {
	            int mid = n/2;
	            median = a[mid];
	        }
	        
	  
	        Set<Integer> keyset = map.keySet();
	       
	        int value = 0;
	        int mode = 0;
	        
	        for (Integer key : keyset) {
	        	
	        	int count = map.get(key);
	        	if (count > value) {
	        		mode = key;
	        		value = count;
	        	}
	        	
	        }
	    	
	        
	        Iterator<Integer> iter = keyset.iterator();
	        
	        if (value == 1) {
	        	mode = iter.next();
	        }
	        
	        
	        System.out.printf("%.1f\n", mean);
	        System.out.printf("%.1f\n", median);
	        System.out.println(mode);
	        
	    }
	}

