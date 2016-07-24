
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
}
