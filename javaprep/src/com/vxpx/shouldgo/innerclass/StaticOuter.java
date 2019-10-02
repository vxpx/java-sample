package com.vxpx.shouldgo.innerclass;

public class StaticOuter {
	
	int instanceval = 10;
	
	static class StaticInner {
		
		int innerinstanceval = 20;
		
		public void testMethod() {
			System.out.println("Inner Method within the class " + innerinstanceval);
			//non static from outer class cannot be accessed from static class
			//System.out.println("Accessing non static outer val " + instanceval);
		}
		
	}

	
	public static void main(String[] args) {
		
		StaticInner inner = new StaticInner();
		inner.testMethod();
		
		
	}
	
}
