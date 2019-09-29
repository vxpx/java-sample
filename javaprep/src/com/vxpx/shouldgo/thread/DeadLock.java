package com.vxpx.shouldgo.thread;

public class DeadLock {

	String str1 = "Java";
	String str2 = "UNIX";

	Thread trd1 = new Thread("My Thread 1") {
		public void run() {
			while (true) {
				synchronized (str1) {
					System.out.println("Thread 1: locked resource 1");
					synchronized (str2) {
						//System.out.println(str1 + str2);
						System.out.println("Thread 1: locked resource 2");
					}
				}
			}
		}
	};

	Thread trd2 = new Thread("My Thread 2") {
		public void run() {
			while (true) {
				synchronized (str2) {
					System.out.println("Thread 2: locked resource 2");
					synchronized (str1) {
						//System.out.println(str2 + str1);
						System.out.println("Thread 2: locked resource 1");
					}
				}
			}
		}
	};

	public static void main(String[] args) {
		DeadLock dLock = new DeadLock();
		dLock.trd1.start();
		dLock.trd2.start();
	}

}
