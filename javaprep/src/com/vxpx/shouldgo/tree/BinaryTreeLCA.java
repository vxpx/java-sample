package com.vxpx.shouldgo.tree;

import java.io.IOException;
import java.util.Stack;

//Recursive Java program to print lca of two nodes

//A binary tree node
class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTreeLCA {
	Node root;
	int count;

	/*
	 * Function to find LCA of n1 and n2. The function assumes that both n1 and
	 * n2 are present in BST
	 */
	Node lca(Node node, int n1, int n2) {
		if (node == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (node.data > n1 && node.data > n2)
			return lca(node.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (node.data < n1 && node.data < n2)
			return lca(node.right, n1, n2);

		return node;
	}

	// every call will have a local stack and its being made use here
	// array will contain all the details but the pathlength is the one which
	// governs the flow.
	public void pathToLeaf(Node root, int[] path, int pathlength) {

		if (root == null)
			return;

		path[pathlength] = root.data;
		pathlength++;

		if (root.left == null && root.right == null) {
			printPath(path, pathlength);
		} else {
			pathToLeaf(root.left, path, pathlength);
			pathToLeaf(root.right, path, pathlength);
		}

	}

	public void printSumToLeaf(Node root, int sum) {

		if (root == null)
			return;

		sum = sum + root.data;

		if (root.left == null && root.right == null) {
			System.out.println("Sum at leaf " + root.data + " = " + sum);
		}

		printSumToLeaf(root.left, sum);
		printSumToLeaf(root.right, sum);
	}

	private void printPath(int[] path, int pathlength) {

		for (int i = 0; i < pathlength; i++) {
			System.out.print(path[i] + "->");
		}
		System.out.println("\n");
	}

	private void inOrder(Node node) {

		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	private void secondLargestPostOrder(Node node) {

		if (node == null || count >= 2)
			return;

		secondLargestPostOrder(node.right);
		count++;
		if (count == 2) {
			System.out.println("Second largest element " + node.data);
		}
		secondLargestPostOrder(node.left);
	}

	private void kLargestPostOrder(Node node, int k) {

		if (node == null)
			return;

		kLargestPostOrder(node.right, k);
		count++;
		if (k == count) {
			System.out.println("k largest element " + node.data);
		}
		kLargestPostOrder(node.left, k);
	}

	private void postOrder(Node node) {

		if (node == null)
			return;

		inOrder(node.left);
		inOrder(node.right);
		System.out.print(node.data + " ");
	}

	private void inOrderTraversal(Node node) {

		Stack<Node> stack = new Stack<Node>();

		Node temp = node;

		while (true) {

			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}

			if (stack.isEmpty())
				return;

			temp = stack.pop();
			System.out.print(temp.data + " ");

			temp = temp.right;
		}
	}

	/*
	 * private void postOrderTraversal(Node node) {
	 * 
	 * Stack<Node> stack = new Stack<Node>();
	 * 
	 * Node temp = node;
	 * 
	 * while (true) {
	 * 
	 * while (temp != null) { stack.push(temp); temp = temp.left; }
	 * 
	 * if (stack.isEmpty()) return; else {
	 * 
	 * if (stack.peek().right == temp) { temp = stack.pop();
	 * System.out.print(temp.data + " "); } temp = temp.right; }
	 * 
	 * } }
	 */

	private Node removeNodeWithOneLeaf(Node root) {

		if (root == null)
			return root;

		if (root.left == null && root.right == null)
			return root;

		root.left = removeNodeWithOneLeaf(root.left);
		root.right = removeNodeWithOneLeaf(root.right);

		if (root.left == null)
			return root.right;
		if (root.right == null)
			return root.left;

		return root;

	}

	/**
	 * Assignment to a node from the return type becomes important when the
	 * structure of the tree is being altered. Pruning , deleting leaf nodes are
	 * examples.
	 */

	/**
	 * The leaf node will have null on left and right. The leaf will be returned
	 * back to caller if the leaf node is in the range. (a < root < b) else a
	 * null.
	 *
	 * A non leaf node will be included or removed based on if it meets the
	 * range. When the non leaf is a higher value the left child is returned.
	 * When the non leaf is a lower value the right child is returned. This is
	 * recursively applied to all the nodes in the tree.
	 * 
	 */

	public Node pruneBST(Node root, int a, int b) {

		if (root == null)
			return root;

		Node leftChild = pruneBST(root.left, a, b);
		Node rightChild = pruneBST(root.right, a, b);

		root.left = leftChild;
		root.right = rightChild;

		if (root.data < a)
			return root.right;

		if (root.data > b)
			return root.left;

		return root;

	}

	public boolean isBST(Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * This method recursively narrows down the max and min value by using the
	 * root value as max value when traversing left root value as min value when
	 * traversing right
	 * 
	 * @param root
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	private boolean isBSTUtil(Node root, int minValue, int maxValue) {
		// TODO Auto-generated method stub

		if (root == null)
			return true;

		if (root.data < minValue || root.data > maxValue) {
			return false;
		}

		return (isBSTUtil(root.left, minValue, root.data) && isBSTUtil(root.right, root.data, maxValue));
	}

	/**
	 * Lambda interface.
	 * @author vxpx
	 *
	 */
	interface PrintToConsole {
		void print();
	}

	/**
	 * Recursively run thru the tree. At the bottom when the pointer becomes
	 * null, it is marked as zero The node previous to null becomes 1 since
	 * there is addition. At every level we will calculate max from bottom up
	 * and once the method recurs completely we have the height of the tree.
	 * 
	 * @param root
	 * @return
	 */
	private int heightOfTree(Node root) {

		if (root == null) {
			return 0;
		} else {

			return Math.max(heightOfTree(root.left) + 1, heightOfTree(root.right) + 1);
		}
	}

	
	private void reverseLevelOrder(Node root) {
		int h;
		h = heightOfTree(root);
		System.out.println("Height of Tree " + h);

		for (int i = h; i >= 1; i--)
			levelOrderTraversal(root, i);

	}
	
	/**
	 * Get the height of the tree and invoke the level order method for each
	 * level till height is h.
	 * 
	 * @param root
	 */
	private void callLevelOrder(Node root) {
		int h;
		h = heightOfTree(root);
		System.out.println("Height of Tree " + h);

		for (int i = 1; i <= h; i++)
			levelOrderTraversal(root, i);

	}

	/**
	 * Print a node when level is 1. For the root node this is direct. For nodes
	 * in other levels this condition is met by making level-1 starting from
	 * root. Once the required level is met its then printed. The tree is
	 * traversed in left and right direction for a level specified.
	 * 
	 * 
	 * @param args
	 */
	private void levelOrderTraversal(Node root, int level) {

		if (root == null)
			return;

		if (level == 1) {
			PrintToConsole p = () -> System.out.print(" " + root.data);
			p.print();
		} else if (level > 1){
			levelOrderTraversal(root.left, level - 1);
			levelOrderTraversal(root.right, level - 1);
		}
	}

	/* Driver program to test lca() */
	public static void main(String args[]) {
		// Let us construct the BST shown in the above figure
		BinaryTreeLCA tree = new BinaryTreeLCA();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		tree.root.right.right = new Node(24);

		int n1 = 10, n2 = 14;
		Node t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 8;
		n2 = 10;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		System.out.println("----------------------");
		System.out.println("     PATH TO LEAF     ");
		System.out.println("----------------------");

		tree.pathToLeaf(tree.root, new int[256], 0);

		System.out.println("----------------------");
		System.out.println("     SUM TO LEAF      ");
		System.out.println("----------------------");
		tree.printSumToLeaf(tree.root, 0);

		System.out.println("----------------------");
		System.out.println("     INORDER");
		System.out.println("----------------------");
		tree.inOrder(tree.root);

		System.out.println("\n----------------------");
		System.out.println("Remove node with one Leaf");
		System.out.println("----------------------");
		tree.removeNodeWithOneLeaf(tree.root);
		tree.inOrder(tree.removeNodeWithOneLeaf(tree.root));

		System.out.println("\n----------------------");
		System.out.println("     2nd Largest");
		System.out.println("----------------------");
		tree.secondLargestPostOrder(tree.root);

		System.out.println("\n----------------------");
		System.out.println("     K Largest");
		System.out.println("----------------------");
		tree.kLargestPostOrder(tree.root, 3);

		System.out.println("\n----------------------");
		System.out.println("     INORDER STACK");
		System.out.println("----------------------");
		tree.inOrderTraversal(tree.root);

		System.out.println("\n----------------------");
		System.out.println("     POSTORDER");
		System.out.println("----------------------");
		tree.postOrder(tree.root);

		/*
		 * System.out.println("\n----------------------");
		 * System.out.println("     POSTORDER STACK");
		 * System.out.println("----------------------");
		 * tree.postOrderTraversal(tree.root);
		 */

		System.out.println("\n----------------------");
		System.out.println("     IS BST");
		System.out.println("----------------------");
		System.out.println(tree.isBST(tree.root));

		System.out.println("\n----------------------");
		System.out.println(" LEVEL ORDER WITH NO Q");
		System.out.println("----------------------");
		tree.callLevelOrder(tree.root);
		
		System.out.println("\n----------------------");
		System.out.println("REVERSE LEVEL ORDER WITH NO Q");
		System.out.println("----------------------");
		tree.reverseLevelOrder(tree.root);

		System.out.println("\n----------------------");
		System.out.println("     Prune Tree");
		System.out.println("----------------------");
		tree.root = tree.pruneBST(tree.root, 4, 10);
		tree.inOrder(tree.root);

	}

	class A {
		void method() throws IOException {

		}
	}

	class B extends A {
		void method() throws NullPointerException {

		}
	}

}

// This code has been contributed by Mayank Jaiswal