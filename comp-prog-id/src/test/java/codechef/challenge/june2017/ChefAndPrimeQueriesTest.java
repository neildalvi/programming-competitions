package codechef.challenge.june2017;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChefAndPrimeQueriesTest {

	private static final int _1000001 = 1000001;
	static boolean[] primes = new boolean[_1000001];
	static int[] mul = new int[_1000001];
	static int[][] recur = new int[_1000001][2];

	@BeforeClass
	public static void setup() {
		primes = new boolean[_1000001];
		mul = new int[_1000001];
		Arrays.fill(mul, 1);
		recur = new int[_1000001][2];
		ChefAndPrimeQueries.preprocess(primes, mul, recur);
	}

	@Test
	public void testSimple() {
		int[] a = new int[] { 0, 2, 3, 4, 5 };
		assertEquals(4, ChefAndPrimeQueries.calc(primes, mul, recur, a, 1, 3, 2, 4));
		a = new int[] { 0, 2, 3, 4, 5 };
		assertEquals(5, ChefAndPrimeQueries.calc(primes, mul, recur, a, 1, 4, 2, 5));
		a = new int[] { 0, 2, 3, 24, 5 };
		assertEquals(6, ChefAndPrimeQueries.calc(primes, mul, recur, a, 1, 3, 2, 5));
		a = new int[] { 0, 2, 3, 24, 5 };
		assertEquals(6, ChefAndPrimeQueries.calc(primes, mul, recur, a, 1, 3, 1, 5));
	}

	
	@Test//(timeout = 1000)
	public void testTime() {
		int[] a = new int[1001];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (1000000 * Math.random()) + 1;
		}
		for (int i = 0; i < 100000; i++) {
			ChefAndPrimeQueries.calc(primes, mul, recur, a, 1, 1000, 2, 1000);
		}
	}

}
