package com.vxpx.shouldgo;

public class BitOperation {
	
	public static void main(String[] args) {
		
		
		long l = 0b001101L;
		System.out.println(l);
		
		l |= 0b10;
		l |= 0x4;
		
		System.out.println(l);
		
	}

}
