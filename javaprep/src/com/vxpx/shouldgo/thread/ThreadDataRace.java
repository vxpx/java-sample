package com.vxpx.shouldgo.thread;

public class ThreadDataRace {

	public static void main(String[] args) {
		
		SharedClass sharedClass = new SharedClass();
		
		Thread thread1 = new Thread(() ->  { 
			for (int i =0; i< Integer.MAX_VALUE; i++) {
				sharedClass.increment();
			}
		});
		
		
		Thread thread2 = new Thread(() ->  { 
			for (int i =0; i< Integer.MAX_VALUE; i++) {
				sharedClass.checkForDataRace();
			}
		});
		
		thread1.start();
		thread2.start();
	}

	public static class SharedClass {

		private int x = 0;
		private int y = 0;

		/* No dependency between the variables and execution order is not maintained. 
		 * In a perfect world  x >= y. Data Race is when y > x */
		public void increment() {
			x++;
			y++;
		}

		public void checkForDataRace() {

			if (y > x)
				System.out.println("y > x - Data race detected");
		}

	}

}
