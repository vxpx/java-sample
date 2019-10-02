package com.vxpx.shouldgo.tree;

import com.vxpx.shouldgo.tree.LLToBstBottomUp.TNode;

class Node1 {
	Node1 next;
	Node1 prev;

	int data;

	Node1(int x) {
		data = x;
		next = prev = null;
	}
}

class LinkedList {
	
	/* A Binary Tree Node */
    class TNode 
    {
        int data;
        TNode left, right;
 
        TNode(int d) 
        {
            data = d;
            left = right = null;
        }
    }

	Node1 head;

	void push(int data) {

		Node1 newItem = new Node1(data);

		newItem.prev = null;
		newItem.next = head;

		if (head != null) {
			head.prev = newItem;
		}

		head = newItem;
	}

	void printList(Node1 head) {
		Node1 node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public Node1 FindTheMiddleNode(Node1 head) {

		Node1 temp1x = head;
		Node1 temp2x = head;

		if (head == null)
			return head;

		while (temp2x != null && temp2x.next != null) {
			temp1x = temp1x.next;
			temp2x = temp2x.next.next;
		}

		return temp1x;
	}

	public int FindLength(Node1 head) {

		Node1 temp1x = head;

		if (head == null)
			return 0;

		int count = 0;

		while (temp1x != null) {
			temp1x = temp1x.next;
			count++;
		}

		return count;
	}

	public Node1 getHead() {
		return head;
	}

	public TNode convertToBstTopDown(Node1 head) {

		if (head == null || head.next == null)
			return null;

		Node1 temp = head;
		Node1 p = FindTheMiddleNode(head);

		while (temp != null && temp.next != p) {
			temp = temp.next;
		}

		TNode tnode = new TNode(p.data);
		
		Node1 q = p.next;
		p.next = null;

		tnode.left = convertToBstTopDown(head);
		tnode.right = convertToBstTopDown(q);

		return tnode;
	}

	public Node1 convertToBstBottomUp(int n) {

		if (n <= 0)
			return null;
		
		System.out.println("Value of N " + n);

		Node1 leftchild = convertToBstBottomUp(n / 2);

		Node1 root = head;
		root.prev = leftchild;

		head = head.next;

		root.next = convertToBstBottomUp(n - (n / 2) - 1);

		return root;

	}
	
	public void inOrder(Node1 root) {
		
		if (root != null) {
			inOrder(root.prev);
			System.out.print(root.data + " ");
			inOrder(root.next);
		}
	}

}

public class LLToBST {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.push(7);
		list.push(6);
		list.push(5);
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

		Node1 head = list.getHead();

		System.out.println("Given Linked List ");
		list.printList(head);
		System.out.println("\n-----------------");

		System.out.println("Middle Node " + list.FindTheMiddleNode(head).data);

		list.convertToBstTopDown(head);
		
		/*System.out.println("Length " + list.FindLength(head));

		Node1 root = list.convertToBstBottomUp(list.FindLength(head));
		
		list.inOrder(root);	*/	

	}

}
