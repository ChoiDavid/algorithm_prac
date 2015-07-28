package rodcutting;

import static myutil.BasicOperation.*;

public class RodCutting {
	
	public static int recursive(int n, int[] price_table) {
		if(n < 0)  { return -1; }
		if(n == 0) { return 0; }
		int q = -1;
		for(int i = 1; i <= n; i++) {
			int temp = price_table[i] + recursive(n-i, price_table);
			q = max(q,temp);
		}
		return q;
	}
	
	public static int top_down(int n, int[] price_table) {
		int[] res = new int[n+1];
		init_array(res, -1);
		return top_down_aux(n, price_table, res);
	}
	
	private static int top_down_aux(int n, int[] price_table, int[] res) {
		if(n == 0) { return 0; }
		if(res[n] != -1) { return res[n]; }
		int q = -1;
		for(int i = 1; i <= n; i++)
			q= max(q, price_table[i] + top_down_aux(n-i, price_table, res));
		res[n] = q;
		return q;
	}
	
	public static int bottom_up(int n, int[] price_table, int[] cut_point) {
		int[] res = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int q = -1;
			for(int j = 1; j <= i; j++) {
				int temp = res[i-j] + price_table[j];
				if(q < temp) {
 					q = temp;
 					cut_point[i] = j;
				}
			}
			res[i] = q;
		}
		return res[n];
	}
}
