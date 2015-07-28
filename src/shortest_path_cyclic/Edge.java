package shortest_path_cyclic;

public class Edge {
	public int weight;
	public Node source;
	public Node destination;
	
	public Edge(Node s, Node d, int w) {
		source = s;
		destination = d;
		weight = w;
	}
}
