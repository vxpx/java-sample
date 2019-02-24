package com.vxpx.mockito.impl;

import com.vxpx.mockito.CalculatorService;

public class Calculator {
	
	CalculatorService service;

	public int addInteger(int a, int b) {
		return service.addNumbers(a, b);
	}
	
}
