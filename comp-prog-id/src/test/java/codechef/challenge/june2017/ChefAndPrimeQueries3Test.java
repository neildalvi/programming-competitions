package codechef.challenge.june2017;

import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class ChefAndPrimeQueries3Test {

	@Test
	public void test() {
		int[][] sum = new int[78499][4 + 1];
		int[] b = new int[] { 0, 2, 3, 4, 5 };
		int[] primeLoc = new int[78499];
		Map<Integer, Integer> map = ChefAndPrimeQueries3.calc(sum, b, primeLoc);
		int l, r, x, y;
		l = 1;
		r = 3;
		x = 2;
		y = 3;
		int actual = sum[map.get(y)][r] - sum[map.get(x) - 1][l - 1];
		Assert.assertEquals(4, actual);
		l = 1;
		r = 4;
		x = 2;
		y = 5;
		actual = sum[map.get(y)][r] - sum[map.get(x) - 1][l - 1];
		Assert.assertEquals(5, actual);
	}

	@Test
	public void testCorners() {
		int[][] sum = new int[78499][4 + 1];
		int[] b = new int[] { 0, 2, 3, 4, 5 };
		int[] primesLoc = new int[78499];
		Map<Integer, Integer> map = ChefAndPrimeQueries3.calc(sum, b, primesLoc);
		int l, r, x, y;
		l = 1;
		r = 1;
		x = 1;
		y = 1;
		int actual = ChefAndPrimeQueries3.answerQuery(sum, primesLoc, map, l, r, x, y);
		Assert.assertEquals(0, actual);
	}

	@Test
	public void testNonPrimeXY() {
		int[][] sum = new int[78499][4 + 1];
		int[] b = new int[] { 0, 2, 3, 4, 5 };
		int[] primeLoc = new int[78499];
		Map<Integer, Integer> map = ChefAndPrimeQueries3.calc(sum, b, primeLoc);
		int l, r, x, y;
		l = 1;
		r = 3;
		x = 1;
		y = 4;
		int actual = ChefAndPrimeQueries3.answerQuery(sum, primeLoc, map, l, r, x, y);
		Assert.assertEquals(4, actual);
		l = 1;
		r = 4;
		x = 4;
		y = 5;
		actual = ChefAndPrimeQueries3.answerQuery(sum, primeLoc, map, l, r, x, y);
		Assert.assertEquals(1, actual);
	}

	@Test
	public void testAll() {
		int[][] sum = new int[78499][4 + 1];
		int[] b = new int[] { 0, 2, 3, 4, 5 };
		int[] primeLoc = new int[78499];
		Map<Integer, Integer> map = ChefAndPrimeQueries3.calc(sum, b, primeLoc);

		int solnIndex = 0;
		int[] soln = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 1-1 */
				1, 1, 3, 3, 0, 2, 2, 2, 2, 0, /* 1-2 */
				1, 2, 4, 4, 1, 3, 3, 2, 2, 0, /* 1-3 */
				1, 2, 4, 4, 1, 3, 3, 2, 2, 0, /* 1-4 */
				1, 2, 4, 5, 1, 3, 4, 2, 3, 1, /* 1-5 */
				1, 1, 3, 3, 0, 2, 2, 2, 2, 0, /* 2-2 */
				1, 2, 4, 4, 1, 3, 3, 2, 2, 0, /* 2-3 */
				1, 2, 4, 4, 1, 3, 3, 2, 2, 0, /* 2-4 */
				1, 2, 4, 5, 1, 3, 4, 2, 3, 1, /* 2-5 */
				0, 1, 1, 1, 1, 1, 1, 0, 0, 0, /* 3-3 */
				0, 1, 1, 1, 1, 1, 1, 0, 0, 0, /* 3-4 */
				0, 1, 1, 2, 1, 1, 2, 0, 1, 1, /* 3-5 */
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 4-4 */
				0, 0, 0, 1, 0, 0, 1, 0, 1, 1, /* 4-5 */
				0, 0, 0, 1, 0, 0, 1, 0, 1, 1/* 5-5 */

		};

		for (int x = 1; x <= 5; x++) {
			for (int y = x; y <= 5; y++) {
				for (int l = 1; l <= 4; l++) {
					for (int r = l; r <= 4; r++) {
						int actual = ChefAndPrimeQueries3.answerQuery(sum, primeLoc, map, l, r, x, y);
						// System.out.println(printLog(solnIndex, x, y, l, r));
						Assert.assertEquals(printLog(solnIndex, x, y, l, r), soln[solnIndex], actual);
						solnIndex++;
					}
				}
			}

		}
	}

	private String printLog(int solnIndex, int x, int y, int l, int r) {
		return "wrong " + solnIndex + "-" + x + "-" + y + "-" + l + "-" + r;
	}

	@Test(timeout = 5000)
	public void testTime() {
		int[][] sum = new int[78499][100000 + 1];
		int[] a = new int[1000001];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (1000000 * Math.random()) + 1;
		}
		int[] primeLoc = new int[78499];
		Map<Integer, Integer> map = ChefAndPrimeQueries3.calc(sum, a, primeLoc);

		int l, r, x, y;
		l = 1;
		r = 3;
		x = 1;
		y = 4;

		ChefAndPrimeQueries3.answerQuery(sum, primeLoc, map, l, r, x, y);
	}

}
