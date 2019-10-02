package com.vxpx.shouldgo;

public class TestCB {
	
	public static void main(String[] args) {
		String correlationId = "FBPPREP-22475-180406242";
		
		if(correlationId.contains("FBPPREP")) {
			correlationId = correlationId.substring(correlationId.indexOf("-") + 1, correlationId.length());
		}
		
		System.out.println(correlationId);
	}

}
