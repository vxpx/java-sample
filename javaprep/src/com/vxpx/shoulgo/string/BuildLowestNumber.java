package com.vxpx.shoulgo.string;

public class BuildLowestNumber {

	public static void buildLowestNumberRec(String str, int n, StringBuffer res)
	{
	    // If there are 0 characters to remove from str,
	    // append everything to result
	    if (n == 0)
	    {
	        res.append(str);
	        return;
	    }
	 
	    int len = str.length();
	 
	    // If there are more characters to remove than string
	    // length, then append nothing to result
	    if (len <= n)
	        return;
	 
	    // Find the smallest character among first (n+1) characters
	    // of str.
	    int minIndex = 0;
	    for (int i = 1; i<=n ; i++)
	        if (str.charAt(i)< str.charAt(minIndex))
	            minIndex = i;
	 
	    // Append the smallest character to result
	    res.append(str.charAt(minIndex));
	    
	    System.out.println(str+"---minindex---" + minIndex + "---char---" + str.charAt(minIndex));
	 
	    // substring starting from minIndex+1 to str.length() - 1.
	    String new_str = str.substring(minIndex+1, len-minIndex);
	 
	    // Recur for the above substring and n equals to n-minIndex
	    buildLowestNumberRec(new_str, n-minIndex, res);
	}

	// A wrapper over buildLowestNumberRec()
	public static StringBuffer buildLowestNumber(String str, int n) {
		StringBuffer res = new StringBuffer("");

		// Note that result is passed by reference
		buildLowestNumberRec(str, n, res);

		return res;
	}

	// Driver program to test above function
	public static void main(String[] args) {

		String str = "121198";
		int n = 2;
		System.out.println(buildLowestNumber(str, n).toString());

	}

}
