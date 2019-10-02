package com.vxpx.shouldgo.thread;

public class OddEvenThreadCommunication {
	
	
	public static void main(String[] args) {
		
		Printer print = new Printer();
		
		Thread evenThread = new Thread(new Handle(print,10,true));
		Thread oddThread = new Thread(new Handle(print,10,false));
		
		evenThread.start();
		oddThread.start();
		
	}

}


class Handle implements Runnable{
	
	Printer print;
	int max;
	boolean isEvenNumber;
	
	Handle(Printer print, int max, boolean isEvenNumber) {
		this.print = print;
		this.max = max;
		this.isEvenNumber = isEvenNumber;
	}
	
	@Override
	public void run() {
	
		int number = (isEvenNumber)?2:1;
		
		while(number < max) {
			
			if (number%2==0) {
				print.printEven(number);
			} else {
				print.printOdd(number);
			}
			number+=2;
		}
	}
}


class Printer {
	
	boolean isOdd = false;

	public synchronized void printEven(int number) {
	
		while(!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Even " + number);
		isOdd = false;
		notify();
	
	}

	public synchronized void printOdd(int number) {
		
		while(isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Odd " + number);
		isOdd = true;
		notify();
	
	}
		

}