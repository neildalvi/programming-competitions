package codechef.challenge.dec2016;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

public class KiritoInLabyrinthTest {

	@Test
	public void testSieve() {
		assertArrayEquals(new int[] {},
				new KiritoInLabyrinth().getPrimesBySieve(1));
		assertArrayEquals(new int[] { 2 },
				new KiritoInLabyrinth().getPrimesBySieve(2));
		assertArrayEquals(new int[] { 2, 3, 5, 7, 11 },
				new KiritoInLabyrinth().getPrimesBySieve(12));
	}

	@Test
	public void testSolve() {

		// Ones
		assertEquals(1, new KiritoInLabyrinth().solve(new int[] { 1 }));
		assertEquals(1, new KiritoInLabyrinth().solve(new int[] { 1, 1, 1, 1 }));
		assertEquals(1, new KiritoInLabyrinth().solve(new int[] { 2 }));

		// only primes
		assertEquals(1, new KiritoInLabyrinth().solve(new int[] { 2, 3, 5, 7 }));
		assertEquals(1, new KiritoInLabyrinth().solve(new int[] { 5, 7, 2, 3 }));
		assertEquals(1, new KiritoInLabyrinth().solve(new int[] { 5, 3, 7, 2 }));

		// two primes with repetitions
		assertEquals(3,
				new KiritoInLabyrinth().solve(new int[] { 2, 2, 3, 3, 3 }));
		assertEquals(3,
				new KiritoInLabyrinth().solve(new int[] { 2, 3, 3, 3, 2 }));
		assertEquals(3,
				new KiritoInLabyrinth().solve(new int[] { 3, 3, 3, 2, 2 }));
		assertEquals(3,
				new KiritoInLabyrinth().solve(new int[] { 3, 2, 3, 2, 3 }));
		assertEquals(2, new KiritoInLabyrinth().solve(new int[] { 2, 3, 2 }));
		assertEquals(2, new KiritoInLabyrinth().solve(new int[] { 2, 2, 3 }));
		assertEquals(2, new KiritoInLabyrinth().solve(new int[] { 3, 2, 2 }));

		assertEquals(4, new KiritoInLabyrinth().solve(new int[] { 2, 4, 6, 9 }));

		// division
		assertEquals(2,
				new KiritoInLabyrinth().solve(new int[] { 3, 256 * 3, 7 }));
		assertEquals(2,
				new KiritoInLabyrinth().solve(new int[] { 3, 7, 256 * 3 }));
		assertEquals(2,
				new KiritoInLabyrinth().solve(new int[] { 2, 5, 81 * 2 }));

		// count same as result link
		assertEquals(4, new KiritoInLabyrinth().solve(new int[] { 49, 49, 14,
				3, 15, 10 }));

		// break color
		assertEquals(4,
				new KiritoInLabyrinth().solve(new int[] { 2, 6, 9, 4, 4 }));

		// given examples
		assertEquals(5, new KiritoInLabyrinth().solve(new int[] { 13, 2, 8, 6,
				3, 1, 9 }));
		assertEquals(2,
				new KiritoInLabyrinth().solve(new int[] { 1, 2, 2, 3, 3, 1 }));
		assertEquals(4,
				new KiritoInLabyrinth().solve(new int[] { 7, 5, 35, 20, 28 }));

	}

	int[] primes = new KiritoInLabyrinth().getPrimesBySieve(10000000);

	@Test(timeout = 1000)
	public void testAllPrimeSmall() {
		int[] input = new int[1000];
		for (int i = 0; i < input.length; i++) {
			input[i] = primes[i];
		}
		assertEquals(1, new KiritoInLabyrinth().solve(input));
	}

	@Ignore
	@Test(timeout = 5000)
	public void testAllPrimeBig() {
		int[] input = new int[100000];
		for (int i = 0; i < input.length; i++) {
			input[i] = primes[i];
		}
		assertEquals(1, new KiritoInLabyrinth().solve(input));
	}

	@Test(timeout = 1000)
	public void testCommonDivBig() {
		int[] input = new int[100000];
		for (int i = 0; i < input.length; i++) {
			input[i] = 2 * (i + 1);
		}
		assertEquals(input.length, new KiritoInLabyrinth().solve(input));
	}

	@Test(timeout = 5000)
	public void testSubTask3() {
		// System.out.println(randomInput);
		new KiritoInLabyrinth().solve(randomInput);
	}

	int[] randomInput = new int[20000];

	public KiritoInLabyrinthTest() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < randomInput.length; i++) {
			randomInput[i] = random.nextInt(10000000) + 1;
			sb.append(randomInput[i]).append("\t");
		}
		// System.out.println(sb);
	}

	@Test
	public void testIso() {
		assertEquals(3,
				new KiritoInLabyrinth().solve(new int[] { 3, 2, 3, 2, 3 }));

	}

	@Test
	public void testIsGcdMoreThanOne() {
		assertEquals(false, new KiritoInLabyrinth().isGcdMoreThanOne(1, 4));
		assertEquals(true, new KiritoInLabyrinth().isGcdMoreThanOne(6, 4));
		assertEquals(false, new KiritoInLabyrinth().isGcdMoreThanOne(13, 7));
		assertEquals(true, new KiritoInLabyrinth().isGcdMoreThanOne(4, 4));
	}

}
