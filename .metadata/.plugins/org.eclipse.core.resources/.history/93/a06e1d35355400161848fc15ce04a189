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
}
