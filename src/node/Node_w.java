package node;

import java.util.ArrayList;
import java.util.List;

public class Node_w extends Node{
	public List<Edge> ingoing_edge;
	public List<Edge> outgoing_edge;
	public int distance;
	public int layer;
	
	{
		ingoing_edge = new ArrayList<Edge>();
		outgoing_edge = new ArrayList<Edge>();
	}
	
	public Node_w(int key) {
		this.key = key;
	}
	
	public Node_w(int key, int layer) {
		this(key);
		this.layer = layer;
	}
	
	public Node_w link(Node_w target, int weight) {
		target.ingoing_edge.add(new Edge(this, target, weight));
		this.outgoing_edge.add(new Edge(this, target, weight));
		return this;
	}
}