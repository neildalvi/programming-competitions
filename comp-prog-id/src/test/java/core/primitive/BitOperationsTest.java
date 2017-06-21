package core.primitive;

import java.util.BitSet;
import java.util.Random;

import org.junit.Test;

public class BitOperationsTest {

	@Test
	public void testCountBits() {
		Random r = new Random();
		for (int times = 0; times < 1000; ++times) {
			int x = r.nextInt(Integer.MAX_VALUE);
			BitSet checker = BitSet.valueOf(new long[] { x });
			assert (BitOperations.countBits(x) == checker.cardinality());
		}
	}

	@Test
	public void testSwapBits() {
		assert(BitOperations.swapBits(47, 1, 4) == 61);
		assert(BitOperations.swapBits(28, 0, 2) == 25);
	}

}
