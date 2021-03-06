import java.util.*;

public class Trees_and_graphs {
	Trees_and_graphs() { }
	
	public void run() {
		
	}
	
	public int height(TN root) {
		if(root == null) {
			return -1;
		}
		return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
	}
	
	public int minHeight(TN root) {
		if(root == null) {
			return -1;
		}
		return 1 + Math.min(minHeight(root.getLeft()), minHeight(root.getRight()));
	}
	
	
	// Implement a function to check if a tree is balanced. A balanced tree is a tree
	// such that no two leaf nodes differ in a distance from the root by more than one.
	public boolean isBalanced(TN root) {
		int minHeight = minHeight(root);
		int height = height(root);
		return (height - minHeight) < 2;
	}
	
	
	public TN search(TN root, int value) {
		if(root == null || root.getValue() == value) {
			return root;
		}
		else {
			return search(value < root.getValue() ? root.getLeft() : root.getRight(), value);
		}
	}
	
	public void findSum(TN head, int sum, ArrayList<Integer> buffer, int level) {
		if(head == null) {
			return;
		}
		int temp = 0;
		buffer.add(head.getValue());
		for(int i = level; i > -1; i--) {
			temp += buffer.get(i);
			if(temp == sum) {
				print(buffer, i, level);
			}
		}
		ArrayList<Integer> b1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> b2 = (ArrayList<Integer>) buffer.clone();
		findSum(head.getLeft(), sum, b1, level + 1);
		findSum(head.getRight(), sum, b2, level + 1);
	}
	
	public void print(ArrayList<Integer> buffer, int p, int level) {
		for(int i = p; i < level; i++) {
			System.out.print(buffer.get(i) + " ");
		}
		System.out.println();
	}
	
	// Given a sorted (increasing order) array, write an algorithm 
	// to create a binary tree with minimal height.
	public TN minBinaryTree(int[] array, int start, int end) {
		if(end > start) {
			return null;
		}
		int mid = (start + end)/2;
		TN root = new TN(array[mid]);
		root.setLeft(minBinaryTree(array, start, mid-1));
		root.setRight(minBinaryTree(array, mid+1, end));
		
		return root;
	}

	// Given a binary search tree, design an algorithm which creates a linked list of 
	// all the nodes at each depth (eg, if you have a tree with depth D, you’ll 
	// have D linked lists).
	public ArrayList<LinkedList<TN>> findLevelLinkedList(TN root) {
		ArrayList<LinkedList<TN>> linkedLists = new ArrayList<LinkedList<TN>>();
		int level = 0;
		LinkedList<TN> linkedList = new LinkedList<TN>();
		linkedList.add(root);
		linkedLists.add(linkedList);
		while(true) {
			linkedList = new LinkedList<TN>();
			for(TN node : linkedLists.get(level)) {
				if(node.getLeft() != null) {
					linkedList.add(node.getLeft());
				}
				if(node.getRight() != null) {
					linkedList.add(node.getRight());
				}
			}
			if(linkedList.isEmpty()){
				break;
			}
			linkedLists.add(linkedList);
			level++;
		}
		return linkedLists;
	}



}
