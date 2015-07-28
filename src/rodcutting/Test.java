package rodcutting;

import static org.junit.Assert.*;
import org.junit.Before;

public class Test {

	int[] price;
	int[] cut_point;
	int n;
	
	@Before
	public void setUp() {
		n = 7;
		price = new int[n+1];
		price[1] = 3;
		price[2] = 6;
		price[3] = 8;
		price[4] = 11;
		price[5] = 16;
		price[6] = 18;
		price[7] = 21;
		cut_point = new int[n+1];
	}
	
	@org.junit.Test
	public void TestFindMaxPrice() {
		int res = RodCutting.recursive(n, price);
		assertEquals(res, 22);
	}
	
	@org.junit.Test
	public void TestFindMaxPriceByDynamic() {
		int res = RodCutting.top_down(n, price);
		assertEquals(res, 22);
	}
	
	@org.junit.Test
	public void TestFindMaxPriceByBottomUp() {
		int res = RodCutting.bottom_up(n, price, cut_point);
		assertEquals(res, 22);
	}
	
	@org.junit.Test
	public void TestCuttingPosition() {
		RodCutting.bottom_up(n, price, cut_point);
		int point = n;
		String result = "";
		while( point > 0) {
			result += cut_point[point] + " ";
			point -= cut_point[point];
		}
		assertEquals("1 1 5 ", result);
	}
}
