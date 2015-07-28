package node;

public class Edge {
	public int weight;
	public Node_w source;
	public Node_w destination;
	
	public Edge(Node_w node, Node_w target, int w) {
		source = node;
		destination = target;
		weight = w;
	}
}
