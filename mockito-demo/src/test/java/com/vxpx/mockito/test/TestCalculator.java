package com.vxpx.mockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.vxpx.mockito.CalculatorService;
import com.vxpx.mockito.impl.Calculator;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class TestCalculator {
	
	//@InjectMocks annotation is used to create and inject the mock object
	//Alternatively this mock object will have to passed as an argument to the constructor
	@InjectMocks
	Calculator calculator = new Calculator();
	
	@Mock
	CalculatorService service;
	
	@Before
	public void setUp() {
		System.out.println("Called setup only after the @Before was added");
	}
	
	@After
	public void tearDown() {
		System.out.println("Called teardown only after the @After was added");
	}
	
	@Test
	public void testAddNumbers() {
		
		when(service.addNumbers(3, 5)).thenReturn(8);
		
		assertEquals(calculator.addInteger(3, 5), 8);
		
		verify(service).addNumbers(3, 5);
		
		verify(service,times(1)).addNumbers(3, 5);
		
		verify(service,atLeastOnce()).addNumbers(3, 5);
		
		verify(service, never()).subractNumbers(3, 5);
	}

}
