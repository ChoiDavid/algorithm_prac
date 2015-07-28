package shortest_path;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

import node.Node;
import node.Node_uw;

public class Graph {
	
	public static void bfs(Node_uw root, List<Node_uw> graph) {
		for (Node_uw n : graph)
			n.visited = false;
		LinkedList<Node_uw> queue = new LinkedList<Node_uw>();
		queue.add(root);
		while(queue.peek() != null) {
			Node_uw u = queue.poll();
			for (Node v : u.adj_nodes) {
				if(v.visited == false) {
					v.visited = true;
					queue.add((Node_uw)v);
				}
			}
			System.out.println(u.key);
			u.visited = true;
		}
	}
	
	private static int time;
	
	public static <T extends Node> ArrayDeque<T> dfs(T root, List<T> graph) {
		time = 0;
		for (Node n : graph)
			n.visited = false;
		ArrayDeque<T> queue = new ArrayDeque<T>();
		dfs_aux(root, queue);
		return queue;
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Node> void dfs_aux(T u, ArrayDeque<T> result) {
		u.start_time = ++time; 
		u.visited = true;
		for (Node v : u.adj_nodes)
			if(v.visited == false)
				dfs_aux((T) v, result);
		u.finish_time = ++time;
		result.addFirst(u);
	}
}


