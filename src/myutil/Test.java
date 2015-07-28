package myutil;

import static myutil.BasicOperation.init_array;
import static myutil.BasicOperation.max;
import static org.junit.Assert.*;

public class Test {

	int a = 5; int b = 3; int c = 4;
	int[] array = new int[10];
	int[][] array2D = new int[4][4];
	
	@org.junit.Test
	public void testMax() {
		assertEquals(5, max(a,b,c));
	}
	
	@org.junit.Test
	public void testInitArray() {
		init_array(array, 3);
		for (int i : array) {
			assertEquals(i, 3);
		}
	}
	
	@org.junit.Test
	public void testInit2dArray() {
		init_array(array2D, 3);
		for (int[] row : array2D) {
			for (int val : row) {
				assertEquals(val, 3);
			}
		}
	}
}
