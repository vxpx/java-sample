package com.vxpx.shouldgo;

public class Singleton {
	
	private Singleton() {
		instance = new Singleton();
	}
	
	private static Singleton instance;
	
	public static Singleton  getInstance() {
		if (instance == null) {

		}
		
		return instance;
	}

}
