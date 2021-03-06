
public class Linked_lists {
	Linked_lists() { }
	
	public void run() {
		// for tests
	}
	
	/*
	You have two numbers represented by a linked list, where each node contains a single digit.
	The digits are stored in reverse order, such that the 1’s digit is at the node of the list.
	Write a function that adds the two numbers and returns the sum as a linked list.
	EXAMPLE
	Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
	Output: 8 -> 0 -> 8
	*/
	private LN addList(LN node1, LN node2, int carry) {
		if(node1 == null && node2 == null) {
			return null;
		}
		int value = carry;
		LN result = new LN(0);
		if(node1 != null ) {
			value += node1.getValue();
		}
		if(node2 != null) {
			value += node2.getValue();
		}
		result.setValue(value % 9);
		LN more = addList(node1.getNext(), node2.getNext(), value > 9 ? 1 : 0);
		result.setNext(more);
		return result;
	}
	 
	// Implement an algorithm to find the n-th last element of a singly linked list
	// Simple solution using 1 pointer to the node of the list
	private LN nthToLast(LN list, int index) {
		int len = 0;
		LN node = list;
		while(list.getNext() != null) {
			len++;
			node = list.getNext();
		}
		int nth = len - index - 1; // -1 for 0 offset
		node = list;
		for(int i = 0; i < nth; i++) {
			node = list.getNext();
		}
		return node;
	}
	
	// Better solution utilizing the space between two pointers.
	private LN nthToLast2(LN list, int index) {
		if(list == null || index < 1) {
			return null;
		}
		LN p1 = list;
		LN p2 = list;
		for(int i = 0; i < index - 1; i++) {
			if(p2.getNext() == null) {
				return null;
			}
			p2 = p2.getNext();
		}
		while(p2 != null) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		return p1;
	}
	
	// Reverse a linked list recursively
	private LN reverse(LN node) {
		if(node == null || node.getNext() == null) {
			return node;
		}
		LN next = reverse(node.getNext());
		next.setNext(node);
		node.setNext(null);
		return next;
	}
	
	// Reverse a linked list iteratively
	private LN reverse_i(LN node) {
		LN prev = null;
		LN next;
		while(node.getNext() != null) {
			next = node.getNext();
			node.setNext(prev);
			prev = node;
			node = next;
		}
		return node;
	}
	
	
}
