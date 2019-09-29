package com.vxpx.shouldgo.thread;

import java.util.LinkedList;
import java.util.Queue;

public class InterThreadCommunication {

	public static void main(String[] args) {

		Queue<Integer> sharedQueue = new LinkedList<Integer>();

		Thread producer = new Producer(sharedQueue);
		Thread consumer = new Consumer(sharedQueue);

		producer.start();
		consumer.start();

	}

}

class Producer extends Thread {

	private Queue<Integer> sharedQueue;

	Producer(Queue queue) {
		super("Producer");
		this.sharedQueue = queue;

	}

	@Override
	public void run() {

		for (int i = 0; i < 4; i++) {

			synchronized (sharedQueue) {
				while (sharedQueue.size() >= 1) {
					System.out.println("Producer waiting");
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Producing " + i);
				sharedQueue.add(i);
				sharedQueue.notify();
			}
		}

	}

}

class Consumer extends Thread {

	private Queue<Integer> sharedQueue;

	Consumer(Queue queue) {
		super("Consumer");
		this.sharedQueue = queue;

	}

	@Override
	public void run() {

		while (true) {
			synchronized (sharedQueue) {

				while (sharedQueue.size() == 0) {
					System.out.println("Consumer waiting");
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int consume = sharedQueue.poll();
				System.out.println("Consuming " + consume);
				sharedQueue.notify();
			}
		}
	}

}
