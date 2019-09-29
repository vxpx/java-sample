package com.vxpx.shouldgo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorFramework {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		/* Has a synchronous queue doesn't buffer any task */
		//ExecutorService service = Executors.newCachedThreadPool();
		
		for(int i=0; i < 10; i++) {
			service.execute(new Task());
		}
		
			
		ExecutorService service1 = Executors.newFixedThreadPool(4);
		
		List<Future> futureList = new ArrayList<>();
		
		for(int i=0; i < 10; i++) {
			Future<Integer> futureVal = service1.submit(new FutureTask());
			futureList.add(futureVal);
		}
		
		//Every get is a blocking call on Future
		for(int i=0; i < 10; i++) {
			try {
				System.out.println(futureList.get(i).get(1, TimeUnit.SECONDS));
			} catch (TimeoutException e) {
				e.printStackTrace();
				continue;
			}
		}
	}

}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
	}
	
}

class FutureTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(3000);
		return new Random().nextInt();
	}


}
