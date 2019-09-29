package com.vxpx.shouldgo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiComputation {

	
	public static void main(String[] args) {
		
		int cpus = Runtime.getRuntime().availableProcessors();
		// would keep this of other tasks as well.
		ExecutorService service = Executors.newFixedThreadPool(cpus);

		float[] floats = new float[50];

		List<Future<Double>> tasks = new ArrayList<>();
		int blockSize = (floats.length + cpus - 1) / cpus;
		for (int i=0, i < floats.length, i++) {
		    final start = blockSize * i;
		    final end = Math.min(blockSize * (i+1), floats.length);
		    tasks.add(service.submit(new Callable<Double>() {
		        public Double call() {
		            double d= 0;
		            for(int j=start;j<end;j++)
		                d += floats[j];
		            return d;
		        }
		     });
		}
		double sum = 0;
		for(Future<Double> task: tasks)
		    sum += task.get();
		
	}
	
}
