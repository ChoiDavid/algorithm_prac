package shortest_path.cyclic;

import java.util.ArrayList;
import java.util.List;

public class Node {
	int key;
	int layer;
	boolean visited;
	List<Node> adj_nodes;
	List<Edge> ingoing_edge;
	List<Edge> outgoing_edge;
	
	{
		adj_nodes = new ArrayList<Node>();
		ingoing_edge = new ArrayList<Edge>();
		outgoing_edge = new ArrayList<Edge>();
	}
	
	public Node(int key) {
		this.key = key;
	}
	
	public Node(int key, int layer, List<Edge> outgoing_edge) {
		this.key = key;
		this.layer = layer;
		this.outgoing_edge = outgoing_edge;
	}
	
	public Node connect(Node target) {
		adj_nodes.add(target);
		return this;
	}
	
	public Node link(Node target, int weight) {
		target.ingoing_edge.add(new Edge(this, target, weight));
		this.outgoing_edge.add(new Edge(this, target, weight));
		return this;
	}
	
}