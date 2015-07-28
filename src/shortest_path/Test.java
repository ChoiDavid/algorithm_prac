package shortest_path;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import node.Node_uw;

import org.junit.Before;

public class Test {

	Node_uw root;
	Node_uw[] nodes = new Node_uw[9];
	List<Node_uw> tree = new ArrayList<Node_uw>();
	
	@Before
	public void setup() {
		for(int i = 1; i <= 8; i++)
			nodes[i] = new Node_uw(i);
		nodes[1].connect(nodes[2]).connect(nodes[5]);
		nodes[2].connect(nodes[3]).connect(nodes[5]);
		nodes[3].connect(nodes[4]);
		nodes[4].connect(nodes[2]);
		nodes[5].connect(nodes[4]);
		nodes[6].connect(nodes[7]).connect(nodes[8]);
		nodes[7].connect(nodes[1]).connect(nodes[5]);
		nodes[8].connect(nodes[7]);
		for(int i = 1; i <= 8; i++)
			tree.add(nodes[i]);
		root = nodes[1];
	}
	
	@org.junit.Test
	public void bfsTest() {
		System.out.println("BFS search start");
		Graph.bfs(root, tree);
		System.out.println("BFS search end\n");
	}
	
	@org.junit.Test
	public void dfsTest() {
		System.out.println("DFS search start");
		ArrayDeque<Node_uw> result = Graph.dfs(root, tree);
		for (Node_uw node : result) {		
			System.out.println("key="+ node.key);
		}
		System.out.println("DFS search end\n");
	}
	
	
	@org.junit.Test
	public void topologicalSortTest() {
		System.out.println("Topological sort start");
		ArrayDeque<Node_uw> result = Graph.dfs(root, tree);
		for (Node_uw node : result) {
			System.out.println("key="+ node.key + "  " + node.start_time + ":" + node.finish_time);
		}
		System.out.println("Topological sort end\n");
	}
}
