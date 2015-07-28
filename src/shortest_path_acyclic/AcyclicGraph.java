package shortest_path_acyclic;

import static myutil.BasicOperation.min;

import java.util.ArrayDeque;
import java.util.List;

import node.Edge;
import node.Node_w;
import shortest_path.Graph;

public class AcyclicGraph {
	
	private final static int INFINITY = Integer.MAX_VALUE;
		
	public static int top_down(List<Node_w> graph, Node_w source, Node_w destination){
		for (Node_w node : graph) {
			node.distance = INFINITY;
		}
		source.distance = 0;
		return top_down_aux(destination);
	}
	
	private static int top_down_aux(Node_w node) {
		if(node.distance != INFINITY) {
			return node.distance;
		}
		for (Edge edge : node.ingoing_edge) {
			int prev_distance = top_down_aux(edge.source);
			if(prev_distance != INFINITY) {
				node.distance = min(node.distance, edge.weight + prev_distance);
			}
		}
		return node.distance;
	}
	
	public static int topological(List<Node_w> graph, Node_w source, Node_w destination) {
		for (Node_w node : graph)
			node.distance = INFINITY;
		source.distance = 0;
		for (Node_w node : graph) {
			for (Edge edge : node.ingoing_edge) {
				node.connect(edge.source);
			}
		}
		ArrayDeque<Node_w> job_queue = Graph.dfs(destination, graph);
		while(job_queue.isEmpty()==false) {
			Node_w node = job_queue.pollLast();
			for (Edge edge : node.ingoing_edge) {
				node.distance = min(node.distance, edge.weight + edge.source.distance);
			}
		}
		return destination.distance;
	}
}