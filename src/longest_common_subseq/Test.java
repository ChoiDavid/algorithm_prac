package longest_common_subseq;

import static org.junit.Assert.assertEquals;

public class Test {
	
	int[] seq1 = {1,2,4,5,2,3,1};
	int[] seq2 = {2,1,4,5,3,1,2};
	
	int expected = 5;
	
	@org.junit.Test
	public void testRecursive() {
		assertEquals(expected, LongestCommonSubseq.recursive(seq1, seq2, seq1.length-1, seq2.length-1));
	}
	
	@org.junit.Test
	public void testMemoization() {
		assertEquals(expected, LongestCommonSubseq.memoization(seq1, seq2));
	}
	
	@org.junit.Test
	public void testBottomUp() {
		assertEquals(expected, LongestCommonSubseq.memoization(seq1, seq2));
	}
}
