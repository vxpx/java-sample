package com.vxpx.shoulgo.string;

public class Anagram {
	
	private static void permutate( char[] str, int index )
	{
	    int i = 0;
	    if( index == str.length-1 )
	    { // We have a permutation so print it
	        System.out.println(str);
	        return;
	    }
	    for( i = index; i < str.length; i++ )
	    {
	        swap( str, index, i); // It doesn't matter how you swap.
	        permutate( str, index + 1 );
	        swap( str, index, i); //backtracking
	    }
	}
	
	private static void swap (char [] str, int index, int i) {
		char temp = str[index];
		str[index] = str[i];
		str[i] = temp;
	}
	
	public static void main(String[] args) {
		char [] str = {'c', 'a', 't'};
		permutate(str,0);
	}

}
