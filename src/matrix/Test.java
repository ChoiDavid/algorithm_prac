package matrix;

import static org.junit.Assert.assertEquals;
import myutil.BasicOperation;

import org.junit.Before;

public class Test {

	Matrix[] m_chain;
	int expected;
	
	@Before
	public void setup() {
		m_chain = new Matrix[4];
		m_chain[0] = new Matrix(4, 2);
		m_chain[1] = new Matrix(2, 10);
		m_chain[2] = new Matrix(10, 4);
		m_chain[3] = new Matrix(4, 6);
		
		expected = BasicOperation.min(
						      4*10*6+4*2*10+10*4*6,
							  4*2*6+2*10*4+2*4*6,
							  4*2*6+10*4*6+2*10*6,
							  4*4*6+4*2*10+4*10*4,
							  4*4*6+2*10*4+4*2*4);
	}
	
	@org.junit.Test
	public void testBottomUp() {
		assertEquals(expected, MatrixChain.bottom_up(m_chain));
	}
	
	@org.junit.Test
	public void testMemoization() {
		int[][] res = new int[m_chain.length][m_chain.length];
		assertEquals(expected, MatrixChain.memoization(m_chain, 0, m_chain.length-1, res));
	}
	
	@org.junit.Test
	public void testRecursive() {
		assertEquals(expected, MatrixChain.recursive(m_chain, 0, m_chain.length-1));
		MatrixChain.print_paranthesis(m_chain);
	}
}
