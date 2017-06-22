package core.primitive;

public class BitOperations {

	public static short countBits(int x) {
		short numBits = 0;
		while (x != 0) {
			numBits += (x & 1);
			// clang-format off
			x >>>= 1;
			// clang-format on
		}
		return numBits;
	}

	/**
	 * <pre>
	 * i-th and j-th bits differ. We will swap them by flipping their values.
	   Select the bits to flip with bitMask. Since x^1 = 0 when x = 1 and 1
	   when x = 0, we can perform the flip XOR.
	 * </pre>
	 * 
	 * @param x
	 * @param i
	 * @param j
	 * @return
	 */
	public static long swapBits(long x, int i, int j) {
		if (((x >>> i) & 1) != ((x >>> j) & 1)) {
			long bitMask = (1L << i) | (1L << j);
			x ^= bitMask;
		}
		return x;
	}

	private static long[] precomputedReverse = new long[(1 << 16)];

	public static long reverseBits(long x, int n) {
		for (int i = 0, j = n; i < j; ++i, --j) {
			x = BitOperations.swapBits(x, i, j);
		}
		return x;
	}

	private static void createPrecomputedTable() {
		for (int i = 0; i < (1 << 16); ++i) {
			precomputedReverse[i] = reverseBits(i, 15);
			System.out.println(precomputedReverse[i]);
		}
	}

	public static long reverseBits(long x) {
		createPrecomputedTable();
		final int MASK_SIZE = 16;
		final int BIT_MASK = 0xFFFF;
		return precomputedReverse[(int) (x & BIT_MASK)] << (3 * MASK_SIZE)
				| precomputedReverse[(int) ((x >>> MASK_SIZE) & BIT_MASK)] << (2 * MASK_SIZE)
				| precomputedReverse[(int) ((x >>> (2 * MASK_SIZE)) & BIT_MASK)] << MASK_SIZE
				| precomputedReverse[(int) ((x >>> (3 * MASK_SIZE)) & BIT_MASK)];
	}

}
