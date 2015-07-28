package node;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
	public int key;
	public boolean visited;
	public List<Node> adj_nodes;
	public int start_time;
	public int finish_time;
	
	{
		adj_nodes = new ArrayList<Node>();
	}
	
	public Node connect(Node target) {
		adj_nodes.add(target);
		return this;
	}
}
