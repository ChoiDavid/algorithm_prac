package shortest_path.cyclic;

import static myutil.BasicOperation.init_array;
import static myutil.BasicOperation.min;

import java.util.ArrayDeque;
import java.util.List;

public class CyclicGraph {
	
	final static int INFINITY = Integer.MAX_VALUE;
	
	public static int top_down(List<Node> graph, Node source, Node destination) {
		int node_num = graph.size();
		int layer_num = node_num;
		int source_idx = source.key;
		int[][] res = new int[node_num][layer_num];
		init_array(res, INFINITY);
		init_array(res[source_idx], 0);	
		return top_down_aux(graph, destination, layer_num-1 , res);
	}
	
	private static int top_down_aux(List<Node> graph, Node destination, int layer, int[][] res) {
		int k = destination.key;
		if(res[k][layer] != INFINITY || layer == 0)
			return res[k][layer];
		int q = INFINITY;
		for(Edge edge : destination.ingoing_edge) {
			int prev_shortest = top_down_aux(graph, edge.source, layer - 1, res);
			if(prev_shortest != INFINITY) {
				q = min(q, edge.weight + prev_shortest);
			}
		}
		q = min(q, res[k][layer-1]);
		res[k][layer] = q;
		return q;
	}
	
	public static int bottom_up(List<Node> graph, Node source, Node end) {
		int node_num = graph.size();
		int layer_num = node_num;
		int source_idx = source.key;
		int[][] res = new int[node_num][layer_num];
		init_array(res, INFINITY);
		init_array(res[source_idx], 0);
		for(int layer = 1; layer < layer_num; layer++) {
			for(int k = 0; k < node_num; k++) {
				int q = INFINITY;
				for (Edge edge : graph.get(k).ingoing_edge) {
					int indicator_row = edge.source.key;
					if(res[indicator_row][layer-1] != INFINITY)
						q = min(q, edge.weight + res[indicator_row][layer-1]);
				}
				if(res[k][layer-1] < q)
					q = res[k][layer-1];
				res[k][layer] = q;
			}
		}
		return res[end.key][layer_num-1];
	}
	
	public static int topological(List<Node> graph, Node source, Node destination) {
		int node_num = graph.size();
		int layer_num = node_num;
		int source_idx = source.key;
		int[][] res = new int[node_num][layer_num];
		init_array(res, INFINITY);
		init_array(res[source_idx], 0);
		Node[][] problems = new Node[node_num][layer_num];
		for(int l = 0; l < layer_num; l++)
			for(int k = 0; k < node_num; k++)
				problems[k][l] = new Node(k, l, graph.get(k).outgoing_edge);				
		topological_aux(graph, problems, problems[source.key][0]);
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		simple_dfs(problems[source.key][layer_num-1], queue);
		while(queue.isEmpty() == false) {
			Node n = queue.pollLast();
			top_down_aux(graph, n, n.layer, res);
		}
		return res[destination.key][layer_num-1];
	}
	
	private static void topological_aux(List<Node> graph, Node[][] problems, Node node) {
		if(node.layer == graph.size()-1)
			return;
		for(Edge edge : node.outgoing_edge) {
			Node target = problems[edge.destination.key][node.layer+1];			
			target.adj_nodes.add(node);
			topological_aux(graph, problems, target);
		}
	}
	
	private static ArrayDeque<Node> simple_dfs(Node u, ArrayDeque<Node> queue) {
		u.visited = true;
		for (Node v : u.adj_nodes)
			if(v.visited == false)
				simple_dfs(v, queue);
		queue.addFirst(u);
		return queue;
	}
}