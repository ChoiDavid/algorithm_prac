package matrix;

import static myutil.BasicOperation.*;

public class MatrixChain {
	
	public static final int INFINITE = Integer.MAX_VALUE;
	
	public static int recursive(Matrix[] chain, int start, int end) {
		if(start == end)
			return 0;
		int q = INFINITE;
		for(int pivot = start; pivot < end; pivot++) {
			int val = recursive(chain, start, pivot) + recursive(chain, pivot+1, end) + 
					chain[start].row * chain[pivot].col * chain[end].col;
			q = min(q, val);
		}
		return q;
	}

	public static int memoization(Matrix[] chain, int start, int end, int[][] res) {
		if(res[start][end] != 0)
			return res[start][end];
		if(start == end)
			return 0;
		int q = INFINITE;
		for(int pivot = start; pivot < end; pivot++) {
			int val = recursive(chain, start, pivot) + recursive(chain, pivot+1, end) + 
					chain[start].row * chain[pivot].col * chain[end].col;
			q = min(q, val);
		}
		res[start][end] = q;
		return q;
	}
	
	public static int bottom_up(Matrix[] matrix) {
		int n = matrix.length;
		int[][] res = new int[n][n];
		
		for(int start = n-1; start >= 0; start--) {
			for(int end = start; end < n; end++) {
				if(start == end) {
					res[start][end] = 0;
				}
				else {
					int q = INFINITE;
					for(int pivot = start; pivot < end ; pivot++) {
						q = min(q, res[start][pivot] + res[pivot+1][end] + matrix[start].row * matrix[pivot].col * matrix[end].col);
					}
					res[start][end] = q;
				}
			}
		}
		return res[0][n-1];
	}
	
	public static void print_paranthesis(Matrix[] matrix) {
		int[][] pivot = get_pivot(matrix);
		print_paranthesis_aux(pivot, 0, matrix.length-1);
	}
	
	public static int[][] get_pivot(Matrix[] matrix) {
		int n = matrix.length;
		int[][] res = new int[n][n];
		int[][] paranthesis_info = new int[n][n];
		
		for(int start = n-1; start >= 0; start--) {
			for(int end = start; end < n; end++) {
				if(start == end) {
					res[start][end] = 0;
				}
				else {
					int q = INFINITE;
					for(int pivot = start; pivot < end ; pivot++) {
						int temp = res[start][pivot] + res[pivot+1][end] + matrix[start].row * matrix[pivot].col * matrix[end].col;
						if(temp < q){
							q = temp;
							paranthesis_info[start][end] = pivot;
						}
					}
					res[start][end] = q;				
				}
			}
		}
		return paranthesis_info;
	}
	private static void print_paranthesis_aux(int[][] pivot, int start, int end) {
		if(start == end)
			System.out.print("A" + start+end);
		else {
			System.out.print("(");
			print_paranthesis_aux(pivot, start,  pivot[start][end]);
			print_paranthesis_aux(pivot, pivot[start][end] + 1, end);
			System.out.print(")");
		}
	}
}

class Matrix {
	int row;
	int col;
	
	public Matrix(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
