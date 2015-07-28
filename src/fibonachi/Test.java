package fibonachi;

import static org.junit.Assert.*;

public class Test {
	
	@org.junit.Test
	public void test() {
		assertEquals(Fibo.recursive(5), 5);
		assertEquals(Fibo.top_down(5), 5);
		assertEquals(Fibo.bottom_up(5), 5);
		assertEquals(Fibo.topological(5), 5);
	}
}
