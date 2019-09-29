package com.vxpx.shouldgo.list;

public class StackLL {

	LinkedList head;
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public int top() {
		
		int data = -1;
		if (head != null) {
			data = head.data;
		}
		return data;
	}

	public void push(int data) {
		LinkedList temp = new LinkedList();
		temp.data = data;

		if (head == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
	}

	public void display() {

		System.out.println("----------------");
		LinkedList temp = head;
		while (temp != null) {
			System.out.print(" " + temp.data);
			temp = temp.next;

		}
		System.out.println("\n----------------");
	}

	public int pop() {

		int data = 0;

		if (head != null) {
			data = head.data;
			head = head.next;
		} else {
			System.out.println("Underflow !!");
		}
		return data;
	}

	public static void main(String[] args) {

		StackLL stackll = new StackLL();

		stackll.push(1);
		stackll.push(2);
		stackll.push(3);
		stackll.push(4);
		stackll.push(5);

		stackll.display();
		System.out.println(" " + stackll.pop());
		stackll.display();
		System.out.println(" " + stackll.pop());
		System.out.println(" " + stackll.pop());
		stackll.display();
		
		
		
	

	}

}
