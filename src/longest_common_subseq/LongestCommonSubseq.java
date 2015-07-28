package longest_common_subseq;

import static myutil.BasicOperation.*;

public class LongestCommonSubseq {
	public static int recursive(int[] seq1, int[] seq2, int fst_end, int snd_end) {
		if(fst_end < 0 || snd_end < 0)
			return 0;
		if(seq1[fst_end] == seq2[snd_end])
			return 1+recursive(seq1, seq2, fst_end-1, snd_end-1);
		int larger = max(recursive(seq1, seq2, fst_end-1, snd_end), recursive(seq1, seq2, fst_end, snd_end-1));
		return larger;
	}
	
	public static int memoization(int[] seq1, int[] seq2) {
		int[][] res = new int[seq1.length][seq2.length];
		init_array(res, -1);
		memoization_aux(seq1, seq2, seq1.length-1, seq2.length-1, res);
		return res[seq1.length-1][seq2.length-1];
	}
	
	private static int memoization_aux(int[] seq1, int[] seq2, int fst_end, int snd_end, int[][] res) {
		if(fst_end < 0 || snd_end < 0)
			return 0;
		if(res[fst_end][snd_end] != -1)
			return res[fst_end][snd_end];
		if(seq1[fst_end] == seq2[snd_end])
			return res[fst_end][snd_end] = 1 + recursive(seq1, seq2, fst_end-1, snd_end-1);
		int larger = max(recursive(seq1, seq2, fst_end-1, snd_end), recursive(seq1, seq2, fst_end, snd_end-1));
		res[fst_end][snd_end] = larger;
		return larger;
	}
	
	public static int bottom_up(int[] seq1, int[] seq2) {
		int[][] res = new int[seq1.length+1][seq2.length+1];
		for(int i = 1; i <= seq1.length; i++) {
			for(int j = 1; j <= seq2.length; j++) {
				if(seq1[i]==seq2[j])
					res[i][j] = res[i-1][j-1]+1;
				else
				    res[i][j] = max(res[i-1][j], res[i][j-1]);
			}
		}
		return res[seq1.length][seq2.length];
	}
}
