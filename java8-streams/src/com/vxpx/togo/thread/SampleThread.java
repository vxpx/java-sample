package com.vxpx.togo.thread;

public class SampleThread extends Thread {

	@Override
	public void run() {
		System.out.println("Running Thread");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		SampleThread t = new SampleThread();
		t.start();
		System.out.println("Running Main for another");
		//Illegal Thread State Exception
		//t.start();
		
		t.join();
		
	}
	
}
