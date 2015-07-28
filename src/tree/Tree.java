package tree;

public class Tree {
	public static int countNodeNum(Node node) {
		if(node == null) { return 0; }
		return countNodeNum(node.left) + countNodeNum(node.right) + 1;
	}
}

class Node {
	Node left = null;
	Node right = null;
	int key;
	
	public Node() {}
	
	public Node(int key) {
		this.key = key;
	}
}
