package com.vxpx.shouldgo.thread;

public class ThreadInterrupt {

	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new BlockingThread());
		thread.start();
		
		thread.interrupt();
		
	}
	
	private static class BlockingThread implements Runnable {
		
		@Override
		public void run() {
			try {
				Thread.sleep(500000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// in case the thread doesnt handle the interrupt and explict check needs to be 
				// added to verify
				System.out.println(Thread.currentThread().isInterrupted());
			}
		}
	}
	
}
