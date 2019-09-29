package com.vxpx.shouldgo.list;

public class LinkedList {

	LinkedList head;

	LinkedList next;
	int data;

	public void addData(int data) {
		LinkedList list = new LinkedList();
		list.data = data;

		if (head == null) {
			head = list;
		} else {
			LinkedList temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = list;
		}

	}

	public void display() {

		System.out.println("");
		LinkedList temp = head;
		while (temp != null) {
			System.out.print(" " + temp.data);
			temp = temp.next;

		}

	}

	public static void main(String[] args) {

		LinkedList caller = new LinkedList();
		caller.addData(1);
		caller.addData(5);
		caller.addData(3);
		caller.addData(2);
		caller.addData(9);
		caller.display();

		caller.reverseInPairs();
		caller.display();

	}

	public LinkedList reverseInPairs() {

		if (head == null || head.next == null)
			return head;

		LinkedList current = head;
		LinkedList nextNode = null;

		// Store head since this will be the new head after swap.
		head = current.next;

		// Considering pairs for exchange.Skip if there is no elements in pairs.
		while (current != null && current.next != null) {

			LinkedList temp = current;
			nextNode = current.next;

			// Current point to Next node and Next node point to current.
			current.next = nextNode.next;
			nextNode.next = current;

			// Current has moved by a place. Increment by 1 moves to the
			// beginning of next pair.
			current = current.next;

			// Verify if pairs ended or has a single element. Temp is at a place
			// prior to current.
			// Point it to the next pair considering a swap.
			if (current.next != null) {
				temp.next = temp.next.next;
			}
		}

		return head;
	}

}
