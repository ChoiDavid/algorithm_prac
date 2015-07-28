package shortest_path.cyclic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Test {

	List<Node> tree;
	Node n1,n2,n3,n4,n5;
	
	@org.junit.Before
	public void setUp() {
		tree = new ArrayList<Node>();
		n1 = new Node(0); n2 = new Node(1); n3 = new Node(2); n4 = new Node(3); n5 = new Node(4);
		tree.add(n1); tree.add(n2); tree.add(n3); tree.add(n4); tree.add(n5);
		n1.link(n2, 6).link(n3, 7);
		n2.link(n3, 8).link(n4, 5).link(n5,-4);
		n3.link(n4,-3).link(n5, 9);
		n4.link(n2,-2);
		n5.link(n1, 2).link(n4,7);
	}
	
	@org.junit.Test
	public void testBottomUp() {
		assertEquals(2, CyclicGraph.bottom_up(tree, n1, n2));
		assertEquals(7, CyclicGraph.bottom_up(tree, n1, n3));
		assertEquals(4, CyclicGraph.bottom_up(tree, n1, n4));
		assertEquals(-2, CyclicGraph.bottom_up(tree, n1, n5));	
	}
	
	@org.junit.Test
	public void testTopDown() {
		assertEquals(2, CyclicGraph.top_down(tree, n1, n2));
		assertEquals(7, CyclicGraph.top_down(tree, n1, n3));
		assertEquals(4, CyclicGraph.top_down(tree, n1, n4));
		assertEquals(-2, CyclicGraph.top_down(tree, n1, n5));
	}
	
	@org.junit.Test
	public void testTopological() {
		fail("Error cause");
		//assertEquals(2, CyclicGraph.topological(tree, n1, n2));
		//assertEquals(7, CyclicGraph.topological(tree, n1, n3));
		//assertEquals(4, CyclicGraph.topological(tree, n1, n4));
		//assertEquals(-2, CyclicGraph.topological(tree, n1, n5));
	}
}
