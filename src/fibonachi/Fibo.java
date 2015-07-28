package fibonachi;

import java.util.ArrayDeque;
import java.util.Arrays;

import node.Node_uw;
import shortest_path.Graph;

public class Fibo {
	public static int recursive(int n) {
		if(n < 0)  return -1;
		if(n <= 1) return n;
		return recursive(n-1) + recursive(n-2);
	}
	
	public static int top_down(int n) {
		if(n < 0) return -1;
		int[] res = new int[n+1];
		for(int i = 0; i <= n; i++)
			res[i] = -1;
		return top_down_aux(n, res);
	}
	
	private static int top_down_aux(int n, int[] res){
		if(res[n] != -1)
			return res[n];
		if(n < 2)
			res[n] = n;
		else
			res[n] = top_down_aux(n-1, res) + top_down_aux(n-2, res);
		return res[n];
	}
	
	public static int bottom_up(int n) {
		if(n < 0) return -1;
		if(n < 2) return n;
		int[] res = new int[n+1];
		res[0] = 0; res[1] = 1;
		for(int i = 2; i <= n; i++)
			res[i] = res[i-1] + res[i-2];
		return res[n];
	}
	
	public static int topological(int n) {
		int[] res = new int[n+1];
		Node_uw[] problem = new Node_uw[n+1];
		for(int i = 0; i <= n; i++) {
			problem[i] = new Node_uw(i);
			res[i] = -1;
		}
		for(int i = n; i >= 2; i--) {
			problem[i].connect(problem[i-1]);
			problem[i].connect(problem[i-2]);			
		}
		Node_uw root = problem[n];
		ArrayDeque<Node_uw> jobqueue = Graph.dfs(root, Arrays.asList(problem));
		while(jobqueue.isEmpty()==false) {
			Node_uw node = jobqueue.pollLast();
			top_down_aux(node.key, res);
		}
		return res[n];
	}
}
