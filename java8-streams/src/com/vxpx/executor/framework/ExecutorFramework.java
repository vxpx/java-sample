package com.vxpx.executor.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFramework {

	public static void main(String[] args) {

		int core = Runtime	.getRuntime()
							.availableProcessors();
		System.out.println("Available core " + core);
		ExecutorService service = Executors.newFixedThreadPool(core);

		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}

		System.out.println("Thread Name : " + Thread.currentThread()
													.getName());

	}
}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread Name : " + Thread.currentThread()
													.getName());

	}

}