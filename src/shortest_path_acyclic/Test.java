package shortest_path_acyclic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import node.Node_w;

public class Test {

	Node_w s, d;
	List<Node_w> graph;
	
	@org.junit.Before
	public void setUp() {
		graph = new ArrayList<Node_w>();
		s = new Node_w(1);
		Node_w a2 = new Node_w(2);
		Node_w a3 = new Node_w(3);
		Node_w a4 = new Node_w(4);
		Node_w a5 = new Node_w(5);
		d = new Node_w(6);
		s.link(a2, 3).link(a3, 2);
		a2.link(d, 5).link(a4, 1);
		a3.link(a5, 4);
		a4.link(d, 2).link(a5, 1);
		a5.link(d, 1);
		graph.add(s); graph.add(a2);graph.add(a3);
		graph.add(a4);graph.add(a5);graph.add(d);
	}
	
	@org.junit.Test
	public void TestTopologicalSort() {
		assertEquals(6, AcyclicGraph.topological(graph, s, d));
	}

	@org.junit.Test
	public void TestTopDown() {
		assertEquals(6, AcyclicGraph.top_down(graph, s, d));
	}
	
}
