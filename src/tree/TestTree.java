package tree;

import static org.junit.Assert.*;

public class TestTree {

	@org.junit.Test
	public void test() {
		Node root = new Node();
		root.left = new Node();
		root.right = new Node();
		root.left.left = new Node();
		root.left.right = new Node();
		assertEquals(Tree.countNodeNum(root), 5);
	}

}
