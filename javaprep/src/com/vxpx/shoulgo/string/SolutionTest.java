package com.vxpx.shoulgo.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SolutionTest extends TestCase{

	Solution ref;
	
 	@Before
 	public void setup() {
 		ref = new Solution();
 	}
	
 	@ReverseStack
 	public void testNonRepeated1() {
 		//ref = new FirstNonRepeatedChar();
 		Assert.assertEquals('f', ref.nonRepeatedChar("firstnonrepeatedchar"));
 	}
 	
 	@ReverseStack
 	public void testNonRepeated2() {
 		//ref = new FirstNonRepeatedChar();
 		Assert.assertEquals('r', ref.nonRepeatedChar("allrepeateda"));
 	}
 	
 	@ReverseStack
 	public void testNonRepeated3() {
 		//ref = new FirstNonRepeatedChar();
 		Assert.assertEquals('$', ref.nonRepeatedChar("aabbccdd"));
 	}
 	
 	@ReverseStack
 	public void testNonRepeated4() {
 		//ref = new FirstNonRepeatedChar();
 		Assert.assertEquals('r', ref.nonRepeatedChar("thisisalongstringbutifyouhavenotusedhashingitsgoingtobeanonoptimalone"));
 	}
 	
 	@ReverseStack
 	public void testNonRepeated5() {
 		//ref = new FirstNonRepeatedChar();
 		Assert.assertEquals('q', ref.nonRepeatedChar("thequickbrownfoxjumpesoverthelazydog"));
 	}
 	
 	@ReverseStack
 	public void testNonRepeated6() {
 		//ref = new FirstNonRepeatedChar();
 		Assert.assertEquals('$', ref.nonRepeatedChar("ababccdede"));
 	}
 	
}
